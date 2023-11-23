package api.dnevnik.ru.exceptions;

public class DnevnikApiException extends Exception {

    public DnevnikApiException(String message) {
        super(message);
    }

    public DnevnikApiException(Throwable cause) {
        super(cause);
    }
}
