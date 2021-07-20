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
   
   // spring에서 제공해 주는 것. 안 써도 된다.
   private static Logger logger = LoggerFactory.getLogger(HelloController.class);
   
   @RequestMapping("hello")
   public String helloMethod() { // 컨드롤러에 왔니 ?
      logger.info("HelloController helloMethod() " + new Date());
      
      return "hello";      // hello.jsp로 가라!
   }
   // .do가 붙으면 무조건 컨트롤러로 간다.
   @RequestMapping(value = "hello.do", method = RequestMethod.GET )
   public String hello(Model model) { // Model은 데이터를 전송하기 위한 용도이다.
      logger.info("HelloController helloMethod() " + new Date());
      
      String name = "홍길동";
      
      model.addAttribute("name", name);   // 짐싸! == setAttribute와 동일
      return "helloview";   // 전진
   }
   
   /*
   @RequestMapping(value = "world.do", method = RequestMethod.GET )
   public String world(String name, int age) { // 파라미터의 자료형을 자동으로 바꿔준다(spring이 알아서 해줌 / IoC - 제어의 반전)
      logger.info("HelloController helloMethod() " + new Date());
      
      System.out.println("name : " + name);
      System.out.println("age : " + age);
      return "helloview";
   }
   */
   
  
}
