package az.azure.manage.sensitive;

import java.lang.annotation.*;

/**
 * 脱敏字段主机
 *
 * @author Az
 * @date 2024/9/26
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Desensitize {
    DesensitizationTypeEnum type() default DesensitizationTypeEnum.DEFAULT;
}
