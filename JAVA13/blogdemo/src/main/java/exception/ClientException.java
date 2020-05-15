package exception;

public class ClientException extends BaseException {




    public ClientException(String code, String message) {

        this(code, message,null);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("Client"+code, "客户端错误："+message, cause);
    }


}
