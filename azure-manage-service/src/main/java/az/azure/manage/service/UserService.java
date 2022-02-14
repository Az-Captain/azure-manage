package az.azure.manage.service;

import az.azure.manage.dto.PageDto;
import az.azure.manage.dto.UserAddDto;
import az.azure.manage.dto.UserUpdateDto;
import az.azure.manage.entity.UserPo;
import az.azure.manage.vo.UserVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;

/**
 * @author Az
 * @date 2022/1/5
 */
public interface UserService {

    /**
     * 分页查询
     *
     * @param pageDto 分页DTO
     * @return 分页结果
     */
    Page<UserPo> page(PageDto pageDto);

    /**
     * 新增用户
     *
     * @param userAddDto 新增用户DTO
     * @return 新增用户ID
     */
    String insert(@Valid UserAddDto userAddDto);

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserVo queryById(String id);

    /**
     * 根据用户ID更新用户信息
     *
     * @param updateDto 更新用户信息DTO
     * @param id        用户ID
     * @return 是否更改成功
     */
    boolean updateById(@Valid UserUpdateDto updateDto, String id);

    /**
     * 根据单个ID删除
     * 通过dao使用update语句来实现
     *
     * @param id 用户ID
     * @return 是否删除成功
     */
    boolean deleteById(String id);

    /**
     * 根据单个ID删除
     * 通过mybatis-plus配置实现
     * @param id 用户Id
     * @return 是否删除成功
     */
    boolean delete(String id);
}
