package ccbill.training.sfgdi;

import ccbill.training.sfgdi.controllers.ConstructorInjectedController;
import ccbill.training.sfgdi.controllers.MyController;
import ccbill.training.sfgdi.controllers.PropertyInjectedController;
import ccbill.training.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController"); //bean name is class name but lowercase first letter

		System.out.println("\n---------- Primary Bean ----------\n");

		System.out.println(myController.sayHello());

		System.out.println("\n---------- Property ----------\n");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("\n---------- Setter ----------\n");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("\n---------- Constructor ----------\n");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
