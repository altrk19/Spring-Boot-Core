package guru.springframework.didemo;

import guru.springframework.didemo.controllers.ConstructorInjectedController;
import guru.springframework.didemo.controllers.MyController;
import guru.springframework.didemo.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println(myController.hello());
        //GreetingService'yi implement eden 3 tane sınıf var. Primary ile öncelik verildi.

        System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());


    }
}
//Test kısmında yazılan kodlarda dependency injection kullanıcının kontolü ile sağlanmakta.
//Biz burada dependency injection'ı ilgili annotation'ları kullanarak Spring'in kontrolüne bırakıyoruz.
//Dependency injection'ı kullanıcının ayarladıgı zaman @Controller ve @Autowired annotationları
//ConstructorInjectedController ve SetterInjectedController sınıflarında kullanılmadı.
