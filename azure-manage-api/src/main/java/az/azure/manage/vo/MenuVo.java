package az.azure.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Az
 * @date 2022/4/10
 */
@Data
public class MenuVo {
    @ApiModelProperty("编号ID")
    private String id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父ID")
    private String parentId;

    @ApiModelProperty("子列表")
    private List<MenuVo> childList;
}
