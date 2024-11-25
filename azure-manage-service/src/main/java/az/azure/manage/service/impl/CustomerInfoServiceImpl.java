package az.azure.manage.service.impl;

import az.azure.manage.component.DesensitizeComponentV1;
import az.azure.manage.dao.CustomerInfoDao;
import az.azure.manage.dto.PageDto;
import az.azure.manage.entity.CustomerInfoPo;
import az.azure.manage.component.DesensitizeComponent;
import az.azure.manage.service.CustomerInfoService;
import az.azure.manage.vo.CustomerInfoVo;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 客户信息表（专门用来数据脱敏测试）(CustomerInfo)表服务实现类
 *
 * @author Az
 * @since 2024-09-25 18:59:12
 */
@Service("customerInfoService")
public class CustomerInfoServiceImpl implements CustomerInfoService {
    @Resource
    private CustomerInfoDao customerInfoDao;
    @Resource
    private DesensitizeComponentV1 desensitizeComponentV1;
    @Resource
    private DesensitizeComponent desensitizeComponent;

    @Override
    public Page<CustomerInfoVo> page(PageDto pageDto) {
        long pageNo = Long.parseLong(pageDto.getPageNo());
        long pageSize = Long.parseLong(pageDto.getPageSize());
        Page<CustomerInfoPo> page = customerInfoDao.page(new Page<>(pageNo, pageSize), null);
        Page<CustomerInfoVo> pageVo = new Page<>();
        BeanUtil.copyProperties(page, pageVo);
        return pageVo;

    }

    @Override
    public String insert(CustomerInfoVo customerInfoVo) {
        CustomerInfoPo customerInfoPo = BeanUtil.copyProperties(customerInfoVo, CustomerInfoPo.class);
        customerInfoDao.insert(customerInfoPo);
        return customerInfoPo.getId();
    }


    @Override
    @SneakyThrows
    public CustomerInfoVo queryById(String id) {
        CustomerInfoPo customerInfoPo = customerInfoDao.queryById(id);
        CustomerInfoVo customerInfoVo = new CustomerInfoVo();
        desensitizeComponent.desensitize(customerInfoPo, customerInfoVo);
//        desensitizeComponentV1.desensitize(customerInfoPo, customerInfoVo);
        return customerInfoVo;
    }

    @Override
    public boolean updateById(CustomerInfoVo customerInfoVo) {
        CustomerInfoPo customerInfoPo = BeanUtil.copyProperties(customerInfoVo, CustomerInfoPo.class);
        return customerInfoDao.update(customerInfoPo);
    }

    @Override
    public boolean deleteById(String id) {
        return customerInfoDao.delete(id);
    }

}

