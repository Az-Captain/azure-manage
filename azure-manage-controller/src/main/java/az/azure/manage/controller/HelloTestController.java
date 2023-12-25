package az.azure.manage.controller;

import az.azure.manage.dto.TransDto;
import az.azure.manage.dto.UserAddDto;
import az.azure.manage.result.ResponseEntity;
import az.azure.manage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Az
 * @date 2022/2/12
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试接口")
public class HelloTestController {

    @Resource
    private UserService userService;

    @GetMapping("/hello")
    public String test() {
        return "This is Hello Test!";
    }

    @PostMapping("/add")
    @ApiOperation("测试-新增")
    public ResponseEntity<String> addTest(@RequestBody UserAddDto userAddDto) {
        return ResponseEntity.success(userService.insert(userAddDto));
    }

    @DeleteMapping("/del/{id}")
    @ApiOperation("测试-删除")
    public ResponseEntity<Boolean> addTest(@PathVariable String id) {
        return ResponseEntity.success(userService.delete(id));
    }

}
