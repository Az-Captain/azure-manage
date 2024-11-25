package az.azure.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author Az
 * @date 2022/4/10
 */
@Data
public class MenuAddDto {

    @NotBlank(message = "客户名不能为空")
    @Length(max = 80)
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty(value = "父ID(空或0表示父级菜单)")
    private String parentId;
}
