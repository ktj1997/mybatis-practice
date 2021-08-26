package study.mybatis.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NotExistContentsException.class)
    public ErrorResponse handleNotExistContentsException(NotExistContentsException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(NotValidArgumentException.class)
    public ErrorResponse handleNotValidArgumentException(NotValidArgumentException e) {
        return new ErrorResponse(e.getMessage());
    }
}
