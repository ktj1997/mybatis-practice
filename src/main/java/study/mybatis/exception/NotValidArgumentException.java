package study.mybatis.exception;

public class NotValidArgumentException extends RuntimeException {

    public NotValidArgumentException() {
        super("잘못된 입력정보 입니다.");
    }
}
