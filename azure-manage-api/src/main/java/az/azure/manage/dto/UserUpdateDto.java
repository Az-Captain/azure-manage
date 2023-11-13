package az.azure.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Az
 * @date 2022/2/10
 */
@Data
public class UserUpdateDto {

    @ApiModelProperty("用户姓名")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "年龄", example = "1")
    @NotNull
    private Integer age;

    @ApiModelProperty("电子邮箱")
    @Email
    private String email;

}
