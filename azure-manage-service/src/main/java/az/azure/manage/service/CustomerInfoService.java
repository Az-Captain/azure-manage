package az.azure.manage.service;

import az.azure.manage.dto.PageDto;
import az.azure.manage.vo.CustomerInfoVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;

/**
 * 客户信息表（专门用来数据脱敏测试）(CustomerInfo)表服务接口
 *
 * @author Az
 * @since 2024-09-25 18:59:11
 */
public interface CustomerInfoService {
    /**
     * 分页查询
     *
     * @param pageDto 分页DTO
     * @return 分页结果
     */
    Page<CustomerInfoVo> page(PageDto pageDto);

    /**
     * 新增用户
     *
     * @param customerInfoVo 新增用户DTO
     * @return 新增用户ID
     */
    String insert(@Valid CustomerInfoVo customerInfoVo);

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    CustomerInfoVo queryById(String id);

    /**
     * 根据用户ID更新用户信息
     *
     * @param customerInfoVo 更新用户信息DTO
     * @return 是否更改成功
     */
    boolean updateById(@Valid CustomerInfoVo customerInfoVo);

    /**
     * 根据单个ID删除
     * 通过dao使用update语句来实现
     *
     * @param id 用户ID
     * @return 是否删除成功
     */
    boolean deleteById(String id);


}

