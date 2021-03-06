package study.mybatis.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import study.mybatis.domain.dao.UserDao;
import study.mybatis.domain.dto.UserDto;
import study.mybatis.domain.model.enums.Gender;

import java.util.Date;

@Getter
@NoArgsConstructor
public class UserDetailResponse {

    private Long id;
    private String name;
    private Date birth;
    private Gender gender;

    public UserDetailResponse(UserDto dto) {
        this.id = dto.getId();
        this.gender = dto.getGender();
        this.name = dto.getName();
        this.birth = dto.getBirth();
    }
}
