package co.com.udea.tourofhero.errorhandler;


import org.springframework.http.HttpStatus;

public class BadResponseErrorHandler extends RuntimeException{

    private final String id;
    private final HttpStatus httpStatus;

    public BadResponseErrorHandler (String message, String id, HttpStatus httpStatus) {
        super(message);
        this.id = id;
        this.httpStatus = httpStatus;
    }

    public String getId() {
        return id;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
