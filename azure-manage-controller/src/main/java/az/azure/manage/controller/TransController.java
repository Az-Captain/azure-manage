package az.azure.manage.controller;

import az.azure.manage.dto.TransDto;
import az.azure.manage.result.ResponseEntity;
import az.azure.manage.service.TransService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Az
 * @date 2022/10/11
 */
@RestController
@Api(tags = "谷歌翻译")
@RequestMapping("translation")
public class TransController {

    @Resource
    private TransService transService;

    @PostMapping("google/trans")
    @ApiOperation("翻译接口")
    public ResponseEntity<String> translation(@RequestBody TransDto transDto){
        return ResponseEntity.success(transService.translation(transDto));
    }

}
