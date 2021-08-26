package study.mybatis.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.mybatis.domain.model.User;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Date birth;


    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.birth = user.getBirth();
    }
}
