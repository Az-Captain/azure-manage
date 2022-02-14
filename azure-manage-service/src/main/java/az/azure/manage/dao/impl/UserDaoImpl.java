package az.azure.manage.dao.impl;

import az.azure.manage.constants.ColumnName;
import az.azure.manage.dao.UserDao;
import az.azure.manage.domain.DomainConstants;
import az.azure.manage.entity.UserPo;
import az.azure.manage.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * @author Az
 * @date 2022/1/5
 */
@Repository
public class UserDaoImpl extends ServiceImpl<UserMapper, UserPo> implements UserDao {

    @Override
    public Page<UserPo> page(Page<UserPo> page, Wrapper<UserPo> queryWrapper) {
        QueryWrapper<UserPo> wrapper = new QueryWrapper<>();
        wrapper.eq(ColumnName.DEL_FLAG, DomainConstants.DEL_FLAG_NORMAL)
                .orderByDesc(ColumnName.CREATE_TIME);
        queryWrapper = wrapper;
        return super.page(page, queryWrapper);
    }

    @Override
    public int selectCount(Wrapper<UserPo> queryWrapper) {
        return super.count(null);
    }

    @Override
    public boolean insert(UserPo entity) {
        return super.save(entity);
    }

    @Override
    public UserPo queryById(String id) {
        return super.getById(id);
    }

    @Override
    public boolean update(UserPo entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean delete(UserPo entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }

}
