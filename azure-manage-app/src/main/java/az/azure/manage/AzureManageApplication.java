package az.azure.manage;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = {"az.azure.manage.mapper"})
@ComponentScan("az.azure")
@EnableSwagger2Doc
@SpringBootApplication
public class AzureManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureManageApplication.class, args);
    }

}
