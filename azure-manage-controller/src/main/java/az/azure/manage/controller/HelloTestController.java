package az.azure.manage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Az
 * @date 2022/2/12
 */
@RestController
public class HelloTestController {

    @GetMapping("/test")
    public String test() {
        return "This is Hello Test!";
    }
}
