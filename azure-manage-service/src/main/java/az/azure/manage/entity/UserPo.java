package az.azure.manage.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Az
 * @date 2021/12/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserPo implements Serializable {
    private static final long serialVersionUID = -27943747310332045L;

    @ApiModelProperty("用户ID")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty(value = "年龄", example = "1")
    private Integer age;

    @ApiModelProperty("电子邮箱")
    private String email;

    @TableLogic
    @ApiModelProperty("删除标志 0:未删除, 1:已删除")
    private String delFlag;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;

}
