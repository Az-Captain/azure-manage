package az.azure.manage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Az
 * @date 2022/1/6
 */
@Data
@ApiModel("分页DTO")
public class PageDto {
    @ApiModelProperty("页码")
    private String pageNo;

    @ApiModelProperty("每页数量")
    private String pageSize;
}
