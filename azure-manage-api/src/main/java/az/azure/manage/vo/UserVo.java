package az.azure.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Az
 * @date 2022/2/9
 */
@Data
public class UserVo implements Serializable {

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("电子邮箱")
    private String email;

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
