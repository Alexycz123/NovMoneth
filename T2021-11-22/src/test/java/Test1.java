import com.ycz.config.MyConfig;
import com.ycz.controller.UserController;
import com.ycz.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
//    private final ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
    private final ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);

    @Test
    public void t1(){
        UserController userController = (UserController) context.getBean("userController");
        userController.add();
    }
}
