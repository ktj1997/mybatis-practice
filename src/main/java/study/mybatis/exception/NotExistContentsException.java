package study.mybatis.exception;

public class NotExistContentsException extends RuntimeException {
    public NotExistContentsException() {
        super("정보가 존재하지 않습니다.");
    }
}
