import com.ycz.mapper.UserMapper;
import com.ycz.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyTest {

    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        sqlSessionFactory= builder.build(inputStream);
        sqlSession = this.sqlSessionFactory.openSession(true);
    }

    @Test
    public void t1() throws FileNotFoundException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList= mapper.selectAll();
        System.out.println(userList);
    }
    @Test
    public void t2(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.selectOne(1);
        System.out.println(user);
    }

    @Test
    public void t3(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user=new User();
        user.setAddress("sz").setSex("女").setUsername("haha").setBirthday("1999-11-09").setId(1);

       Integer i= mapper.updateUser(user);

        System.out.println(i>0?"修改成功":"修改失败");
    }


    @Test
    public void t4(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList=new ArrayList<>();
        User user=new User();
        user.setAddress("sz").setSex("女").setUsername("haha").setBirthday("1999-11-09");
        userList.add(user);
        userList.add(user);
        userList.add(user);
        userList.add(user);

        Integer i=   mapper.insertBatchUser(userList);

        System.out.println(i>0?"批量添加成功":"批量添加失败");
    }


}
