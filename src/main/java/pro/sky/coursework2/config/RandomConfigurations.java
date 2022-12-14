package pro.sky.coursework2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomConfigurations {
    @Bean
    public Random getRandom() {
        return new Random();
    }
}
