package az.azure.manage.result;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Az
 * @date 2022/2/11
 * 返回信息
 */
@Getter
public enum ResultMsgEnum {

    /**
     * 请求成功
     * 200
     */
    SUCCESS(true, HttpStatus.OK.value(), "请求成功"),
    /**
     * 请求失败
     * -1
     */
    FAIL(false, -1, "请求失败"),

    AUTH_ERROR(true, HttpStatus.BAD_GATEWAY.value(), "Bad Gateway"),
    SERVER_UNAVAILABLE(true, HttpStatus.SERVICE_UNAVAILABLE.value(), "Service Unavailable"),
    ADD_ITEM_SUCCESS(true, HttpStatus.CREATED.value(), "添加成功！"),
    NAME_CANNOT_BE_NULL(false, HttpStatus.BAD_REQUEST.value(), "名称不能为空"),
    ;
    /**
     * 操作是否成功
     */
    boolean success;
    /**
     * 操作代码
     */
    Integer code;
    /**
     * 提示信息
     */
    String message;

    ResultMsgEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    ResultMsgEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
