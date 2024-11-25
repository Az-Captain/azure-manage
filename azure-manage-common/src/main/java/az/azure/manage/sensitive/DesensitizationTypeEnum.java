package az.azure.manage.sensitive;

/**
 * 脱敏字段类型
 *
 * @author Az
 * @date 2024/9/26
 */
public enum DesensitizationTypeEnum {
    /**
     * 默认，不脱敏
     */
    DEFAULT,
    /**
     * 手机号
     */
    PHONE,
    /**
     * 身份证号
     */
    ID_CARD,
    /**
     * 银行卡号
     */
    BANK_CARD,
    /**
     * 邮箱
     */
    EMAIL,
    /**
     * 住址
     */
    ADDRESS,
}
