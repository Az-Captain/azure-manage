package az.azure.manage.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Az
 * @date 2022/2/11
 */
@Data
public class ResponseEntity<T> {

    @ApiModelProperty(value = "请求是否成功",required = true)
    private boolean success;
    @ApiModelProperty(value = "状态码",required = true)
    private Integer code;
    @ApiModelProperty(value = "返回消息",required = true)
    private String message;
    private T data;

    public ResponseEntity() {
    }

    public ResponseEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(ResultMsgEnum rc) {
        this.success = rc.success;
        this.code = rc.code;
        this.message = rc.message;
    }

    /**
     * 成功
     */
    public static <T> ResponseEntity<T> success(T data) {
        ResponseEntity<T> result = result(ResultMsgEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败
     */
    public static <T> ResponseEntity<T> error(T data) {
        ResponseEntity<T> result = result(ResultMsgEnum.FAIL);
        result.setData(data);
        return result;
    }
    public static <T> ResponseEntity<T> error(Integer code, String message) {
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> ResponseEntity<T> success() {
        return result(ResultMsgEnum.SUCCESS);
    }

    public static <T> ResponseEntity<T> result(ResultMsgEnum codeEnum) {
        return new ResponseEntity<>(codeEnum);
    }

}
