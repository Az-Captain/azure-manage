package az.azure.manage;

import com.spring4all.swagger.EnableSwagger2Doc;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author azimat
 */
@MapperScan(basePackages = {"az.azure.manage.mapper"})
@ComponentScan("az.azure")
@EnableSwagger2Doc
@EnableCaching
@SpringBootApplication
//@EnableScheduling
public class AzureManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureManageApplication.class, args);
    }

}

@Slf4j
@RequestMapping("/")
@Configuration
@Controller
class IndexController {

    /**
     * 端口
     */
    @Value("${server.port}")
    private String port;

    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            try {
                log.info("启用成功: " + "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port);
            } catch (UnknownHostException e) {
                log.error(e.getMessage());
            }
        };
    }
}
