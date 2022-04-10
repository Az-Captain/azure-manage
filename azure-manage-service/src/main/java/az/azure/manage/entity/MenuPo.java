package az.azure.manage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Az
 * @date 2022/4/10
 */
@Data
@TableName("menu")
public class MenuPo {
    @ApiModelProperty("编号ID")
    private String id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父ID")
    private String parentId;

}
