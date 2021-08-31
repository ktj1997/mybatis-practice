package study.mybatis.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.mybatis.domain.model.enums.Gender;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveUserRequest {
    private String name;
    private String birth;
    private Gender gender;
}
