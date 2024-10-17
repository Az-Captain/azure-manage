package az.azure.manage.strategy.impl;

import az.azure.manage.sensitive.DesensitizationTypeEnum;
import az.azure.manage.strategy.DesensitizeStrategy;
import org.springframework.stereotype.Component;

/**
 * @author Az
 * @date 2024/10/17
 */
@Component
public class PhoneDesensitizationStrategy implements DesensitizeStrategy {

    @Override
    public boolean support(DesensitizationTypeEnum type) {
        return type.equals(DesensitizationTypeEnum.PHONE);
    }

    @Override
    public String desensitization(String target) {
        return target.substring(0, 3) + "****" + target.substring(7, 11);
    }
}
