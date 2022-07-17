import com.ycz.config.SpringConfig;
import com.ycz.controller.AccountController;
import com.ycz.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MyT23est1231241 {

    @Autowired
    private AccountController controller;

    @Test
    public void t1(){
        Account one = controller.getOne(1);
        System.out.println(one);

    }
    @Test
    public void t2(){
        List<Account> all = controller.getAll();
        System.out.println(all);
    }

    @Test
    public void t3(){
        Integer update = (Integer) controller.update(1, 2, 300);
        System.out.println(update==2?"修改成功":"修改失败");
    }

}
