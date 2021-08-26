package study.mybatis.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private Date timeStamp;

    public ErrorResponse(String message) {
        this.message = message;
        this.timeStamp = new Date();
    }
}
