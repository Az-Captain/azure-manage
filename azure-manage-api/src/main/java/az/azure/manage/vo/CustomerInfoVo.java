package az.azure.manage.vo;


import az.azure.manage.sensitive.DesensitizationTypeEnum;
import az.azure.manage.sensitive.Desensitize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 客户信息表
 *
 * @author Az
 * @since 2024-09-25 18:59:09
 */
@Data
public class CustomerInfoVo {

    @ApiModelProperty("客户ID")
    private String id;

    @ApiModelProperty("账户名称")
    private String userName;

    @ApiModelProperty("真是姓名")
    private String realName;

    @ApiModelProperty("密码")
    private String userPassword;

    @ApiModelProperty("性别 1-男；2-女")
    private String gender;

    @Desensitize(type = DesensitizationTypeEnum.PHONE)
    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @Desensitize(type = DesensitizationTypeEnum.ID_CARD)
    @ApiModelProperty("身份证号码")
    private String idCard;

    @ApiModelProperty("银行账户名")
    private String bankAccountName;

    @Desensitize(type = DesensitizationTypeEnum.BANK_CARD)
    @ApiModelProperty("银行卡号")
    private String bankAccountNo;

    @ApiModelProperty("是否生效 0-否；1-是")
    private Integer isActive;

    @ApiModelProperty("删除标志 1-未删除；0-已删除")
    private String delFlag;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}

