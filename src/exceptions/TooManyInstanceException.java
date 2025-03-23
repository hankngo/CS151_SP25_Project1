package exceptions;

public class TooManyInstanceException extends Exception {
    public TooManyInstanceException(String message)
    {
        super(message);
    }
}