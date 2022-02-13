package az.azure.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author Az
 * @date 2022/2/9
 */
@Data
public class UserAddDto {

    @ApiModelProperty("用户姓名")
    @NotBlank
    private String name;

    @ApiModelProperty("年龄")
    @Min(8)
    private Integer age;

    @ApiModelProperty("电子邮箱")
    @Email
    private String email;
}
