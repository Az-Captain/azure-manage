//package az.azure.manage.controller;
//
//import az.azure.manage.result.ResponseEntity;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Az
// * @date 2023/5/12
// */
//@RestController
//@Slf4j
//@Api(value = "测试Nacos", tags = "测试nacos配置")
//@RequestMapping("company")
//public class NacosTestController {
//
//    @Value("${company.name}")
//    private String companyName;
//    @Value("${company.address}")
//    private String companyAddress;
//
//    @GetMapping("info")
//    @ApiOperation("测试Naocs定义的变量")
//    public ResponseEntity<String> getCompanyInfo() {
//        log.info("公司信息查询成功");
//        return ResponseEntity.success("name:" + companyName + " " + "adr:" + companyAddress);
//    }
//
//}
