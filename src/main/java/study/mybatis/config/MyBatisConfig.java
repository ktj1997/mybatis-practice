package study.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import study.mybatis.domain.model.enums.Gender;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/*.xml");

        sessionFactory.setMapperLocations(res);
        sessionFactory.setTypeAliasesPackage("study.mybatis.domain.model");

        sessionFactory.setTypeHandlers(new Gender.TypeHandler(),
                new BooleanTypeHandler());

        return sessionFactory.getObject();
    }

    /*
     * myBatis Bean 등록,
     * SqlSessionTemplate은 SqlSession을 구현하고 코드에서 SqlSession를 대체하는 역할을 한다.
     * 쓰레드에 안전하게 작성되었기 때문에 여러 DAO나 매퍼에서 공유 할 수 있다.
     */
    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
