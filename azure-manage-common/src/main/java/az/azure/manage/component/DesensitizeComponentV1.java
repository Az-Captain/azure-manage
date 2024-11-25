package az.azure.manage.component;

import az.azure.manage.sensitive.Desensitize;
import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author Az
 * @date 2024/9/26
 */
@Component
@Slf4j
public class DesensitizeComponentV1 {

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
                switch (desensitize.type()) {
                    case PHONE:
                        String number = (String) value;
                        number = number.substring(0, 3) + "****" + number.substring(number.length() - 5, number.length() - 1);
                        field.set(target, number);
                        log.info("加密后的手机号：{}", number);
                        break;
                    case ID_CARD:
                        String newId = idCardDesensitize((String) value);
                        field.set(target, newId);
                        log.info("脱敏后的身份证号：{}", newId);
                        break;
                    case BANK_CARD:
                        System.out.println("银行卡");
                        break;
                    default:
                        System.out.println("没有合适类型");

                }
            }
        }


    }

    /**
     * 身份证脱敏
     *
     * @param oldValue 原来的身份证号
     * @return 脱敏后的身份证号
     */
    private String idCardDesensitize(String oldValue) {
        String temp = oldValue.substring(7, 14);
        return oldValue.replace(temp, "********");
    }
}
