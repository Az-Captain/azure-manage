package az.azure.manage.controller;

import az.azure.manage.utils.RedisUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Az
 * @date 2023/9/15
 */
@Slf4j
@RequestMapping("/redis")
@RestController
@Api(tags = "redis测试接口")
public class RedisController {
    @Resource
    private RedisUtil redisUtil;

    @GetMapping("set")
    public boolean redisSet(String key, String value) {
        System.out.println(key + "--" + value);
        return redisUtil.set(key, value);
    }

    @GetMapping("get")
    public Object redisGet(String key) {
        System.out.println(redisUtil.get(key));
        return redisUtil.get(key);
    }

    @GetMapping("expire")
    public boolean expire(String key, long expireTime) {
        return redisUtil.expire(key, expireTime);
    }
}
