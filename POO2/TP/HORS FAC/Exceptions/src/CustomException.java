public class CustomException extends Exception{
    //    private String message;
    public CustomException(String message) {
        super(message);     //throw a custom message with the exception
    }

    public CustomException(Throwable cause) {
        super(cause);       //throw  an existing exception as a new one
    }

    public CustomException(String message,  Throwable cause) {
        super(message, cause);
    }
}
