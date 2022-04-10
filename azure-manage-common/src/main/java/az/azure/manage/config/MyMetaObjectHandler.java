//package az.azure.manage.config;
//
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.reflection.MetaObject;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @author Az
// * @date 2022/2/14
// */
//@Slf4j
////使用时要添加到IOC容器中，相当于启动下面注释
////@Component
//public class MyMetaObjectHandler implements MetaObjectHandler {
//
//    //插入时填充策略
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        log.info("start insert fill ...");
//        this.setFieldValByName("create_data",new Date(),metaObject);
//        this.setFieldValByName("update_data",new Date(),metaObject);
//    }
//
//    // 更新时填充策略
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        log.info("start update fill...");
//        this.setFieldValByName("update_time",new Date(),metaObject);
//    }
//}
