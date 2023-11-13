package az.azure.manage.dao;

import az.azure.manage.entity.MenuPo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Az
 * @date 2022/4/10
 */
@Repository
public interface MenuDao {
    /**
     * 添加菜单
     *
     * @param entity 菜单
     * @return 是否添加成功
     */
    boolean insert(MenuPo entity);

    /**
     * 获取菜单列表
     *
     * @return 列表
     */
    List<MenuPo> getList();

    MenuPo getMenuById(String id);
}
