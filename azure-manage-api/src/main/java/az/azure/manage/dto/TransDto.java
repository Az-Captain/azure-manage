package az.azure.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Az
 * @date 2022/10/11
 */
@Data
public class TransDto {
    @ApiModelProperty(value = "OKyj7Nq26LuXRMMD7JWiMGDvcD",name = "用户请求密钥")
    private String key;

    @ApiModelProperty("原文语种标识（默认：zh-CN）")
    private String sl;

    @ApiModelProperty("需要翻译的语种标识（默认：en）")
    private String tl;

    @ApiModelProperty("需要翻译的原文内容")
    private String original;
}
