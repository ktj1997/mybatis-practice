package study.mybatis.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.mybatis.domain.model.User;
import study.mybatis.domain.model.enums.Gender;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Gender gender;
    private Date birth;


    public UserDto(User user) {
        this.id = user.getId();
        this.gender = user.getGender();
        this.name = user.getName();
        this.birth = user.getBirth();
    }
}
