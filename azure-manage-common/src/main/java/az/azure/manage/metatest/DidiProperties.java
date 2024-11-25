package az.azure.manage.metatest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 我们在配置文件中尝试编写这个自定义的配置项时，可以看到编译器给出了联想和提示
 * url: https://www.didispace.com/spring-boot-2/2-4-metadata.html#%E9%85%8D%E7%BD%AE%E5%85%83%E6%95%B0%E6%8D%AE%E7%9A%84%E8%87%AA%E5%8A%A8%E7%94%9F%E6%88%90
 * @author Az
 * @date 2024/4/29
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "com.didi")
public class DidiProperties {
    /**
     * 这是一个测试配置(在yml/properties中使用)
     */
    private String from;
}
