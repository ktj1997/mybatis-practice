package study.mybatis.domain.dao;

import org.apache.ibatis.annotations.*;
import study.mybatis.domain.model.User;


@Mapper
public interface UserDao {
    User findUserById(Long id);

    void save(User user);
}
