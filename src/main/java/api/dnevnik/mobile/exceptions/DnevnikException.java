package api.dnevnik.mobile.exceptions;

import java.io.IOException;

public class DnevnikException extends IOException {

    public DnevnikException(String message) {
        super(message);
    }

    public DnevnikException(Throwable cause) {
        super(cause);
    }

}
