package pro.sky.coursework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Coursework2Application {

    public static void main(String[] args) {
        SpringApplication.run(Coursework2Application.class, args);
    }

}
