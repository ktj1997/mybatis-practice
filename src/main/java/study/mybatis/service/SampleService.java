package study.mybatis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.mybatis.domain.dao.UserDao;
import study.mybatis.domain.dto.UserDto;
import study.mybatis.domain.model.User;
import study.mybatis.exception.NotExistContentsException;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final UserDao userDao;

    public UserDto findUserById(Long id) {
        User user = userDao.findUserById(id);
        if (user == null)
            throw new NotExistContentsException();
        return new UserDto(user);
    }

    public UserDto saveUser(UserDto userDto) {
        User user = new User(null, userDto.getName(), userDto.getBirth(), userDto.getGender());
        userDao.save(user);
        if (user.getId() == null)
            throw new NotExistContentsException();
        return new UserDto(user);
    }
}
