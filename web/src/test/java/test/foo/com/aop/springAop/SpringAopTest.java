package test.foo.com.aop.springAop;

import com.foo.dao.aop.Dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 动态代理测试类 
 * @author zyb 
 * @since 2012-8-9 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public class SpringAopTest {

    @Test
    public void testProxy() throws Throwable {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/aop.xml");
        Dao dao = (Dao)ac.getBean("daoImpl");
        dao.select();
    }  
}  