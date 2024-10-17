package az.azure.manage.strategy.impl;

import az.azure.manage.sensitive.DesensitizationTypeEnum;
import az.azure.manage.strategy.DesensitizeStrategy;
import org.springframework.stereotype.Component;

/**
 * @author Az
 * @date 2024/10/17
 */
@Component
public class IDCardDesensitizationStrategy implements DesensitizeStrategy {
    @Override
    public boolean support(DesensitizationTypeEnum type) {
        return type.equals(DesensitizationTypeEnum.ID_CARD);
    }

    @Override
    public String desensitization(String target) {
        return target.substring(0, 6) + "********" + target.substring(target.length() - 4, target.length() - 1);
    }
}
