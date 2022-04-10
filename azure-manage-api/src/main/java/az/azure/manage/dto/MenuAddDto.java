package az.azure.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Az
 * @date 2022/4/10
 */
@Data
public class MenuAddDto {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父ID")
    private String parentId;
}
