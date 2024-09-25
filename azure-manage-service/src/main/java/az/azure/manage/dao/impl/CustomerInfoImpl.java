package az.azure.manage.dao.impl;

import az.azure.manage.dao.CustomerInfoDao;
import az.azure.manage.entity.CustomerInfoPo;
import az.azure.manage.mapper.CustomerInfoMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * @author Az
 * @date 2024/9/25
 */
@Repository
public class CustomerInfoImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfoPo> implements CustomerInfoDao {

    @Override
    public Page<CustomerInfoPo> page(Page<CustomerInfoPo> page, Wrapper<CustomerInfoPo> queryWrapper) {
        LambdaQueryWrapper<CustomerInfoPo> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(CustomerInfoPo::getCreateBy);
        queryWrapper = wrapper;
        return super.page(page, queryWrapper);
    }

    @Override
    public int selectCount(Wrapper<CustomerInfoPo> queryWrapper) {
        return super.count();
    }

    @Override
    public boolean insert(CustomerInfoPo entity) {
        return super.save(entity);
    }

    @Override
    public CustomerInfoPo queryById(String id) {
        return super.getById(id);
    }

    @Override
    public boolean update(CustomerInfoPo entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }
}
