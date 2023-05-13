package az.azure.manage.service.impl;

import az.azure.manage.dao.UserDao;
import az.azure.manage.domain.DomainConstants;
import az.azure.manage.dto.PageDto;
import az.azure.manage.dto.UserAddDto;
import az.azure.manage.dto.UserUpdateDto;
import az.azure.manage.entity.UserPo;
import az.azure.manage.service.UserService;
import az.azure.manage.utils.BeanCopyUtils;
import az.azure.manage.utils.DateUtils;
import az.azure.manage.utils.SnowflakeIdUtil;
import az.azure.manage.vo.UserVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * @author Az
 * @date 2022/1/5
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
@Slf4j
@Validated
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 创建人
     */
    private static final String CREATE_BY = "Az";
    /**
     * 更新人
     */
    private static final String UPDATE_BY = "Az";

    @Override
    public Page<UserPo> page(PageDto pageDto) {
        long pageNo = Long.parseLong(pageDto.getPageNo());
        long pageSize = Long.parseLong(pageDto.getPageSize());
        return userDao.page(new Page<>(pageNo, pageSize), null);
    }

    @Override
    public String insert(UserAddDto userAddDto) {
        UserPo entity = BeanCopyUtils.copyBean(userAddDto, UserPo.class);
        entity.setId(String.valueOf(SnowflakeIdUtil.getSnowflakeId()));
//        entity.setId(IdWorker.get32UUID());
        entity.setCreateBy(CREATE_BY);
        entity.setCreateTime(DateUtils.getDateTime());

        return this.userDao.insert(entity) ? entity.getId() : null;
    }

    @Override
    @Cacheable(cacheNames = "user")
    public UserVo queryById(String id) {
        return BeanCopyUtils.copyBean(userDao.queryById(id), UserVo.class);
    }

    @Override
    @CacheEvict(cacheNames = "user", key = "#id")
    public boolean updateById(UserUpdateDto updateDto, String id) {
        UserPo entity = userDao.queryById(id);
        BeanUtils.copyProperties(updateDto, entity);
        entity.setId(id);
        entity.setUpdateBy(UPDATE_BY);
        entity.setUpdateTime(DateUtils.getDateTime());
        return this.userDao.update(entity);
    }

    @Override
    @CacheEvict(cacheNames = "user", key = "#id")
    public boolean deleteById(String id) {
        UserPo exist = this.userDao.queryById(id);
        if (StringUtils.equals(exist.getDelFlag(), DomainConstants.DEL_FLAG_DELETED)) {
            return true;
        }
        exist.setDelFlag(DomainConstants.DEL_FLAG_DELETED);
        return this.userDao.delete(exist);
    }

    @Override
    public boolean delete(String id) {
        return userDao.delete(id);
    }

}
