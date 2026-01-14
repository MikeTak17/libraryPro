public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private Integer code;

    public BaseException(){
    }

    public BaseException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public BaseException(ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getDesc());
        this.code = errorCodeEnum.getCode();
    }

    public BaseException(Integer code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }

    public BaseException(String defaultMessage){
        super(defaultMessage);
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(final Integer code){
        this.code = code;
    }

    @Override
    public String toString(){
        return "BaseException(code=" + this.getCode() + ")";
    }

}