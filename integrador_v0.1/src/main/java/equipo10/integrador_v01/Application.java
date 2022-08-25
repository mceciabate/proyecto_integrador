package equipo10.integrador_v01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"equipo10.integrador_v01.controller"})




public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


/*@ComponentScan(basePackages = "com/dh/proyectoIntegrador/controllers/ CategoryController.java")
@ComponentScan(basePackages = "com/dh/proyectoIntegrador/controllers/CityController.java")
@ComponentScan(basePackages = "com/dh/proyectoIntegrador/controllers/ProductController.java")*/