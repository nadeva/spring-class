package fr.nadeva.spring.dependencyinjection.notifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Primary
@Component
public class EmailNotifier implements Notifier {
    @Override
    public int sendNotification(String notificationMessage) {
        System.out.println("Sending [" + notificationMessage + "] by email");
        return Notifier.EMAIL;
    }

    @PostConstruct
    public void callOnPostConstruct() {
        System.out.println("POST CONSTRUCT EmailNotifier");
    }

    @PreDestroy
    private void callOnPreDestroy() {
        System.out.println("PRE DESTROY EmailNotifier");
    }
}
