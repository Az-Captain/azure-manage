package az.azure.manage.controller;

import az.azure.manage.dto.MenuAddDto;
import az.azure.manage.result.ResponseEntity;
import az.azure.manage.service.MenuService;
import az.azure.manage.vo.MenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Az
 * @date 2022/4/10
 */
@RestController
@Api(tags = "菜单接口")
@RequestMapping("menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @PostMapping("/add")
    @ApiOperation(value = "新增菜单", response = String.class)
    public ResponseEntity<String> insert(@RequestBody MenuAddDto menuAddDto) {
        return ResponseEntity.success(menuService.insert(menuAddDto));
    }

    @GetMapping("/list")
    @ApiOperation("获取菜单列表")
    public ResponseEntity<List<MenuVo>> list() {
        return ResponseEntity.success(menuService.list());
    }

    @GetMapping("/list/{id}")
    @ApiOperation("根据id获取对应的菜单")
    public ResponseEntity<List<MenuVo>> getMenuById(@PathVariable("id") String id) {
        return ResponseEntity.success(menuService.getMenuById(id));
    }
}
