package study.mybatis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.mybatis.domain.dao.UserDao;
import study.mybatis.domain.dto.UserDto;
import study.mybatis.domain.model.User;
import study.mybatis.exception.NotExistContentsException;
import study.mybatis.exception.NotValidArgumentException;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final UserDao userDao;

    public UserDto findUserById(Long id) throws Exception {
        User user = userDao.findUser(id);
        if (user == null)
            throw new NotExistContentsException();
        return new UserDto(user);
    }

    public UserDto saveUser(UserDto userDto) throws Exception {
        User user = new User(null, userDto.getName(), userDto.getBirth());
        userDao.saveUser(user);
        if (user.getId() == null)
            throw new NotExistContentsException();
        return new UserDto(user);
    }
}
