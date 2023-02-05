package az.azure.manage.service.impl;

import az.azure.manage.dao.MenuDao;
import az.azure.manage.dto.MenuAddDto;
import az.azure.manage.entity.MenuPo;
import az.azure.manage.utils.BeanCopyUtils;
import az.azure.manage.utils.SnowflakeIdUtil;
import az.azure.manage.vo.MenuVo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import az.azure.manage.service.MenuService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Az
 * @date 2022/4/10
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;

    @Override
    public String insert(MenuAddDto menuAddDto) {
        MenuPo entity = BeanCopyUtils.copyBean(menuAddDto, MenuPo.class);
        entity.setId(String.valueOf(SnowflakeIdUtil.getSnowflakeId()));
        menuDao.insert(entity);
        return entity.getId();
    }

    @Override
    public List<MenuVo> list() {
        List<MenuPo> menuPos = menuDao.getList();

        List<MenuVo> menuVoList = Lists.newArrayList();
        for (MenuPo entity : menuPos) {
            MenuVo menuVo = BeanCopyUtils.copyBean(entity, MenuVo.class);
            menuVoList.add(menuVo);
        }
        if (!CollectionUtils.isEmpty(menuVoList)) {
            List<MenuVo> menuVos = menuVoList.stream().filter(m -> "0".equals(m.getParentId())).peek(
                    (m) -> m.setChildList(getChildrens(m, menuVoList))
            ).collect(Collectors.toList());
            return menuVos;
        }
        return menuVoList;
    }

    @Override
    public List<MenuVo> getMenuById(String id) {
        MenuPo menuPo = menuDao.getMenuById(id);
        MenuVo menuVo = BeanCopyUtils.copyBean(menuPo, MenuVo.class);
        List<MenuPo> menuPos = menuDao.getList();

        List<MenuVo> menuVoList = Lists.newArrayList();
        for (MenuPo entity : menuPos) {
            MenuVo menuVo1 = BeanCopyUtils.copyBean(entity, MenuVo.class);
            menuVoList.add(menuVo1);
        }
        List<MenuVo> childrens = getChildrens(menuVo, menuVoList);
        System.out.println("**********************************");
        List<String> idList = Lists.newArrayList();
        System.out.println(getidList(childrens,idList));
        System.out.println("**********************************");
        return childrens;
    }

    public List<String> getidList(List<MenuVo> list,List<String> idList){
        for (MenuVo menuVo : list) {
            idList.add(menuVo.getId());
            if(!CollectionUtils.isEmpty(menuVo.getChildList())){
                getidList(menuVo.getChildList(),idList);
            }
        }
        return idList;

    }

    /**
     * 递归查询子节点
     *
     * @param root 根节点
     * @param all  所有节点
     * @return 根节点信息
     */
    private List<MenuVo> getChildrens(MenuVo root, List<MenuVo> all) {
        List<MenuVo> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getId());
        }).map(
                (m) -> {
                    m.setChildList(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }
}
