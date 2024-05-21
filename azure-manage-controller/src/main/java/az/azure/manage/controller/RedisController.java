package az.azure.manage.controller;

import az.azure.manage.constants.RedisChanelConstants;
import az.azure.manage.utils.RedisUtil;
import com.google.common.collect.Sets;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author Az
 * @date 2023/9/15
 */
@RequestMapping("/redis")
@RestController
@Api(tags = "redis测试接口")
public class RedisController {

    @Resource
    private RedisUtil redisUtil;

    @GetMapping("set")
    @ApiOperation(value = "设置值", response = Boolean.class)
    public boolean redisSet(String key, String value) {
        System.out.println(key + "--" + value);
        return redisUtil.set(key, value);
    }

    @GetMapping("get")
    @ApiOperation(value = "获取值", response = Boolean.class)
    public Object redisGet(String key) {
        System.out.println(redisUtil.get(key));
        return redisUtil.get(key);
    }

    @GetMapping("expire")
    @ApiOperation(value = "设置值并设定过期时间", response = Boolean.class)
    public boolean expire(String key, long expireTime) {
        return redisUtil.expire(key, expireTime);
    }

    @DeleteMapping("del")
    @ApiOperation(value = "删除值(批量删除用逗号','拼接)", response = Boolean.class)
    public boolean deleteByKey(String keys) {
        String[] keyArray = keys.split(",");
        redisUtil.del(keyArray);
        Set<Object> set = Sets.newHashSet();
        for (String s : keyArray) {
            set.add(redisUtil.get(s));
        }
        return set.size() == 1;
    }

    @GetMapping("publish")
    @ApiOperation(value = "发布消息", response = Void.class)
    public void publish(@RequestParam("message") String message) {
        redisUtil.publish(RedisChanelConstants.CHANNEL_GLOBAL_NAME, message);
    }

}
