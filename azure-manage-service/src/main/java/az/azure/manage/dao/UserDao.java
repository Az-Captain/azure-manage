package az.azure.manage.dao;

import az.azure.manage.entity.UserPo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

/**
 * @author Az
 * @date 2022/1/5
 */
@Repository
public interface UserDao{

    /**
     * 分页查询
     *
     * @param page         分页数据
     * @param queryWrapper 分页额外条件
     * @return 分页结果
     */
    Page<UserPo> page(Page<UserPo> page, Wrapper<UserPo> queryWrapper);

    /**
     * 查询所有记录
     *
     * @param queryWrapper 条件
     * @return 记录总条数
     */
    int selectCount(Wrapper<UserPo> queryWrapper);

    /**
     * 新增用户
     *
     * @param entity 用户实体
     * @return 是否添加成功
     */
    boolean insert(UserPo entity);

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserPo queryById(String id);

    /**
     * 更新用户
     *
     * @param entity 用户实体
     * @return 是否更新成功
     */
    boolean update(UserPo entity);

    /**
     * 删除用户
     *
     * @param entity 用户实体
     * @return 是否删除成功
     */
    boolean delete(UserPo entity);

    /**
     * 根据ID删除
     * 使用mybatis-plus配置的逻辑删除，SQL语句时Update
     * global-config:
     *     db-config:
     *       logic-delete-field: del_flag  #全局逻辑删除字段值 3.3.0开始支持。
     *       logic-delete-value: 1 # 逻辑已删除值(默认为 1)
     *       logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
     * @param id 用户ID
     * @return 是否删除成功
     */
    boolean delete(String id);
}
