package az.azure.manage.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Az
 * @date 2022/2/11
 */
@RestControllerAdvice
@Slf4j
public class CustomerExceptionHandler {
    /**
     * 自定义异常处理 ServerBusyException
     */
    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> ErrorHandler(MyException e) {
        log.error("服务器正忙，请稍后再试!！", e);
        return ResponseEntity.error(ResultMsgEnum.SERVER_UNAVAILABLE.getCode(),ResultMsgEnum.SERVER_UNAVAILABLE.getMessage());
    }

    /**
     * 统一未知异常处理
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> Execption(Exception e) {
        log.error("未知异常！", e);
        return ResponseEntity.error(e.getMessage());
    }
}
