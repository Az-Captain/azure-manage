package az.azure.manage.component;

import az.azure.manage.sensitive.Desensitize;
import az.azure.manage.strategy.DesensitizeStrategy;
import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Az
 * @date 2024/9/26
 */
@Component
@Slf4j
public class DesensitizeComponent {

    @Resource
    List<DesensitizeStrategy> desensitizeStrategyList;

    /**
     * 把source转换为target，并把带有脱敏注解的字段脱敏处理
     *
     * @param source 源对象
     * @param target 目标对象（Vo）
     */
    public void desensitize(Object source, Object target) throws IllegalAccessException {
        // 属性转换
        BeanUtil.copyProperties(source, target);
        // 进行脱敏
        Field[] fields = target.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Desensitize.class)) {
                field.setAccessible(true);
                Object value = field.get(target);
                log.info("属性名:{},字段值：{},是否敏感字段:{}", field.getName(), value, true);

                // 调用脱敏方法
                Desensitize desensitize = field.getAnnotation(Desensitize.class);

                for (DesensitizeStrategy strategy : desensitizeStrategyList) {
                    if (strategy.support(desensitize.type())) {
                        String desensitizationValue = strategy.desensitization((String)value);
                        field.set(target, desensitizationValue);
                    }
                }
            }
        }


    }
}
