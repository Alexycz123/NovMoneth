import com.fasterxml.jackson.core.JsonProcessingException;
import com.ycz.config.MyConfig;
import com.ycz.controller.UserController;
import com.ycz.dao.UserMapper;
import com.ycz.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
public class DSTest {
//    private final ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
//    @Test
//    public void t1(){
//        JdbcTemplate getTemplate = context.getBean("getTemplate", JdbcTemplate.class);
//        String sql="select * from user where id=1";
//        Map<String, Object> map = getTemplate.queryForMap(sql);
//
//        System.out.println(map);
//    }
//    SqlSession sqlSession = context.getBean("getSqlSession", SqlSession.class);
//    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Autowired
    private UserController userController;

    @Test
    public void t2() throws JsonProcessingException {

        System.out.println(userController.selectList());
//        List<User> userList = mapper.selectList();
//        System.out.println(userList);

    }
}
