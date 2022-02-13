package az.azure.manage.result;

/**
 * @author Az
 * @date 2022/2/11
 */
public class MyException extends RuntimeException{
    private ResultMsgEnum resultMsgEnum;

    public MyException(ResultMsgEnum resultMsgEnum) {
        this.resultMsgEnum = resultMsgEnum;
    }

    public MyException() {
    }

    public ResultMsgEnum getExceptionEnum() {
        return resultMsgEnum;
    }

    public void setExceptionEnum(ResultMsgEnum resultMsgEnum) {
        this.resultMsgEnum = resultMsgEnum;
    }
}
