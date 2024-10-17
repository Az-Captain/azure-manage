package az.azure.manage.strategy;

import az.azure.manage.sensitive.DesensitizationTypeEnum;

/**
 * 脱敏策略
 * @author Az
 * @date 2024/10/17
 */
public interface DesensitizeStrategy {

    /**
     * 判断是否支持
     * @param type 脱敏类型
     * @return 判断结果
     */
    boolean support(DesensitizationTypeEnum type);

    /**
     * 进行脱敏
     * @param target 脱敏目标
     * @return 脱敏后结果
     */
    String desensitization(String target);
}
