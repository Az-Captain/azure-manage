package az.azure.manage.dao.impl;

import az.azure.manage.dao.MenuDao;
import az.azure.manage.entity.MenuPo;
import az.azure.manage.mapper.MenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Az
 * @date 2022/4/10
 */
@Repository
public class MenuDaoImpl extends ServiceImpl<MenuMapper, MenuPo> implements MenuDao {

    @Override
    public boolean insert(MenuPo entity) {
        return super.save(entity);
    }

    @Override
    public List<MenuPo> getList() {
        return super.list();
    }

    @Override
    public MenuPo getMenuById(String id) {
        return super.getById(id);
    }
}
