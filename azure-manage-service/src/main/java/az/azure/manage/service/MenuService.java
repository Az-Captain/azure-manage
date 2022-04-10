package az.azure.manage.service;


import az.azure.manage.dto.MenuAddDto;
import az.azure.manage.vo.MenuVo;

import java.util.List;

/**
 * @author Az
 * @date 2022/4/10
 */
public interface MenuService {
    /**
     * 添加菜单
     *
     * @param menuAddDto 新增菜单DTO
     * @return 菜单ID
     */
    String insert(MenuAddDto menuAddDto);

    /**
     * 获取菜单列表
     *
     * @return 菜单列表
     */
    List<MenuVo> list();
}
