package az.azure.manage.controller;


import az.azure.manage.dto.PageDto;
import az.azure.manage.result.ResponseEntity;
import az.azure.manage.service.CustomerInfoService;
import az.azure.manage.vo.CustomerInfoVo;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 客户信息表（专门用来数据脱敏测试）(CustomerInfo)表控制层
 *
 * @author Az
 * @since 2024-09-25 18:59:06
 */
@RestController
@RequestMapping("customerInfo")
@Api(tags = "客户信息表接口")
public class CustomerInfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerInfoService customerInfoService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", response = Page.class)
    public ResponseEntity<Page<CustomerInfoVo>> page(PageDto pageDto) {
        Page<CustomerInfoVo> page = customerInfoService.page(pageDto);
        return ResponseEntity.success(page);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据ID查询", response = CustomerInfoVo.class)
    public ResponseEntity<CustomerInfoVo> selectOne(@PathVariable String id) {
        CustomerInfoVo customerInfoVo = customerInfoService.queryById(id);
        return ResponseEntity.success(customerInfoVo);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增", response = String.class)
    public ResponseEntity<String> insert(@RequestBody CustomerInfoVo customerInfoVo) {
        return ResponseEntity.success(customerInfoService.insert(customerInfoVo));
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改", response = String.class)
    public ResponseEntity<Boolean> update(@RequestBody CustomerInfoVo customerInfoVo) {
        return ResponseEntity.success(customerInfoService.updateById(customerInfoVo));
    }

    @PutMapping("/delete/{id}")
    @ApiOperation(value = "删除", response = Boolean.class)
    public ResponseEntity<Boolean> update(@PathVariable String id) {
        return ResponseEntity.success(customerInfoService.deleteById(id));
    }

}

