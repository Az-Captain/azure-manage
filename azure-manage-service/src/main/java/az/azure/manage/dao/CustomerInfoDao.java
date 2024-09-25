package az.azure.manage.dao;

import az.azure.manage.entity.CustomerInfoPo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

/**
 * 客户信息表（专门用来数据脱敏测试）(CustomerInfo)表数据库访问层
 *
 * @author Az
 * @since 2024-09-25 18:59:08
 */
@Repository
public interface CustomerInfoDao {
    /**
     * 分页查询
     *
     * @param page         分页数据
     * @param queryWrapper 分页额外条件
     * @return 分页结果
     */
    Page<CustomerInfoPo> page(Page<CustomerInfoPo> page, Wrapper<CustomerInfoPo> queryWrapper);

    /**
     * 查询所有记录
     *
     * @param queryWrapper 条件
     * @return 记录总条数
     */
    int selectCount(Wrapper<CustomerInfoPo> queryWrapper);

    /**
     * 新增用户
     *
     * @param entity 用户实体
     * @return 是否添加成功
     */
    boolean insert(CustomerInfoPo entity);

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    CustomerInfoPo queryById(String id);

    /**
     * 更新用户
     *
     * @param entity 用户实体
     * @return 是否更新成功
     */
    boolean update(CustomerInfoPo entity);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 是否删除成功
     */
    boolean delete(String id);

}

