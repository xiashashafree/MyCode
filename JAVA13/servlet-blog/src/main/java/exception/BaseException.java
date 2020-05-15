package exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BaseException extends  RuntimeException{

    protected  String code;

    protected  String message;

    public BaseException(String code) {
       this(code,null);
    }

    public BaseException( String code,String message) {
        this(code,message,null);
    }

    public BaseException(String code, String message,Throwable cause ) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}
