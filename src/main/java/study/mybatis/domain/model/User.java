package study.mybatis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.mybatis.domain.model.enums.Gender;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Date birth;
    private Gender gender;
}
