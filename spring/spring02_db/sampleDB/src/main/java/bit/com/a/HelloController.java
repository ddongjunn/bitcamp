package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller      // annotation
public class HelloController {
   
   // spring���� ������ �ִ� ��. �� �ᵵ �ȴ�.
   private static Logger logger = LoggerFactory.getLogger(HelloController.class);
   
   @RequestMapping("hello")
   public String helloMethod() { // ����ѷ��� �Դ� ?
      logger.info("HelloController helloMethod() " + new Date());
      
      return "hello";      // hello.jsp�� ����!
   }
   // .do�� ������ ������ ��Ʈ�ѷ��� ����.
   @RequestMapping(value = "hello.do", method = RequestMethod.GET )
   public String hello(Model model) { // Model�� �����͸� �����ϱ� ���� �뵵�̴�.
      logger.info("HelloController helloMethod() " + new Date());
      
      String name = "ȫ�浿";
      
      model.addAttribute("name", name);   // ����! == setAttribute�� ����
      return "helloview";   // ����
   }
   
   /*
   @RequestMapping(value = "world.do", method = RequestMethod.GET )
   public String world(String name, int age) { // �Ķ������ �ڷ����� �ڵ����� �ٲ��ش�(spring�� �˾Ƽ� ���� / IoC - ������ ����)
      logger.info("HelloController helloMethod() " + new Date());
      
      System.out.println("name : " + name);
      System.out.println("age : " + age);
      return "helloview";
   }
   */
   
  
}
