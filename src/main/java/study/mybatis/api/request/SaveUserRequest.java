package study.mybatis.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class SaveUserRequest {

    private String name;
    private String birth;
}
