package study.mybatis.domain.dao;

import org.apache.ibatis.annotations.*;
import study.mybatis.domain.model.User;


@Mapper
public interface UserDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "birth", column = "birth")
    })
    @Select("SELECT * FROM User WHERE id = #{id}")
    User findUser(Long id) throws Exception;

    /**
     * Options에 Auto Increment를 위한 useGeneratedKeys와  keyProperty를 설정했어도,
     * DB Schema에 AutoIncrement가 설정 안되어있으면 에러가난다.
     * <p>
     * Insert Query는 원래 리턴값이 없다. (Integer리턴값은 영향을준 Row의 갯수)
     * SelectKey를 하면 자동으로 설정해준 keyPropery에 넣어준다
     */
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    @Insert("INSERT INTO User(name,birth) VALUES(#{name},#{birth})")
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache = Options.FlushCachePolicy.TRUE)
    void saveUser(User user);


}
