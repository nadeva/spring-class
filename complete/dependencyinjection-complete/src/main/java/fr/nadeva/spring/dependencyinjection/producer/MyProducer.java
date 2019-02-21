package fr.nadeva.spring.dependencyinjection.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

    @Bean
    private String monString(){
        return "string producer";
    }

    @Bean
    private int monInt(){
        return 42;
    }

}
