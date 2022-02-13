package az.azure.manage.controller;

import az.azure.manage.dto.PageDto;
import az.azure.manage.dto.UserAddDto;
import az.azure.manage.dto.UserUpdateDto;
import az.azure.manage.entity.UserPo;
import az.azure.manage.result.ResponseEntity;
import az.azure.manage.service.UserService;
import az.azure.manage.utils.SnowflakeIdUtil;
import az.azure.manage.vo.UserVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Az
 * @date 2022/1/6
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户接口")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/test")
    @ApiOperation("测试接口")
    public String test() {
        return "This is Test API" + SnowflakeIdUtil.getSnowflakeId();
    }

    @GetMapping("/test/v2")
    @ApiOperation("V2测试接口")
    public ResponseEntity<String> testV2() {
        return ResponseEntity.success("This is Test API");
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", response = Page.class)
    public ResponseEntity<Page<UserPo>> page(PageDto pageDto) {
        Page<UserPo> page = userService.page(pageDto);
        return ResponseEntity.success(page);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增用户", response = String.class)
    public ResponseEntity<String> insert(@RequestBody UserAddDto userAddDto) {
        return ResponseEntity.success(userService.insert(userAddDto));
    }

    @GetMapping("/one/{id}")
    @ApiOperation(value = "根据ID查询", response = UserVo.class)
    public ResponseEntity<UserVo> queryById(@ApiParam("用户ID") @PathVariable String id) {
        return ResponseEntity.success(userService.queryById(id));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据ID编辑", response = Boolean.class)
    public ResponseEntity<Boolean> updateById(
            @RequestBody UserUpdateDto updateDto,
            @PathVariable @ApiParam("用户ID") String id
    ) {
        return ResponseEntity.success(userService.updateById(updateDto, id));
    }

    @DeleteMapping("del/{id}")
    @ApiOperation(value = "根据ID删除", response = Boolean.class)
    public ResponseEntity<Boolean> deleteById(@PathVariable @ApiParam("用户ID") String id) {
        return ResponseEntity.success(userService.deleteById(id));
    }
}
