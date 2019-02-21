package fr.nadeva.spring.dependencyinjection.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventSuscriber implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("Receiving Event [" + event.getMessage() + "]");
    }
}
