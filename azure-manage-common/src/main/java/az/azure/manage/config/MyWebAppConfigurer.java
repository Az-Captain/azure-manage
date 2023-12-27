package az.azure.manage.config;

import az.azure.manage.component.MyHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 注册拦截器
 * 可以yml文件配置的方式
 *
 * @author Az
 * @date 2023/12/27
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Resource
    private MyHandlerInterceptor myHandlerInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于指定需要拦截的请求路径
        // excludePathPatterns excludePathPatterns方法用于指定不需要拦截的请求路径
        registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/register");

//        super.addInterceptors(registry);


//        WebMvcConfigurer.super.addInterceptors(registry);


        // 多个拦截器组成一个拦截器链
//        registry.addInterceptor(new ExecuteTimeInterceptor())
//        .addPathPatterns("/**");

        //API限流拦截
//        registry.addInterceptor(accessLimitAjaxInterceptor())
//        .addPathPatterns("/**")
//        .excludePathPatterns("/static/**","/login.html");
//        registry.addInterceptor(accessInterceptor())
//        .addPathPatterns("/**")
//        .excludePathPatterns("/static/**","/login.html");
    }
}
