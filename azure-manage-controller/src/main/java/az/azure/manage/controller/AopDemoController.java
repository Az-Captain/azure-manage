package az.azure.manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Az
 * @date 2023/6/20
 */
@RestController
@Api("测试AOP注解")
public class AopDemoController {

    @GetMapping("/hello")
    String sayHello(@ApiParam("姓名") @RequestParam("name") String name) throws InterruptedException {
        System.out.println("传递过来参数是" + name);
        Thread.sleep(2000);
        return "hello " + name;
    }

}
