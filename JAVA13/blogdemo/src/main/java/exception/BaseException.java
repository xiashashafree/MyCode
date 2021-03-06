package exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseException extends RuntimeException{
    protected String code;



    public BaseException(String code,String message){
        this(code,message,null);
    }
    public BaseException(String code,String message,Throwable cause){
        super(message,cause);
    }

}
