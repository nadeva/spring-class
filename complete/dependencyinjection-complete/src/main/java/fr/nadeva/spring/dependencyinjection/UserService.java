package fr.nadeva.spring.dependencyinjection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import fr.nadeva.spring.dependencyinjection.event.EventPublisher;
import fr.nadeva.spring.dependencyinjection.model.User;
import fr.nadeva.spring.dependencyinjection.notifier.Notifier;
import fr.nadeva.spring.dependencyinjection.persistence.Persister;

@Component
public class UserService implements BeanNameAware, ApplicationContextAware {

    @Autowired
    private Persister persister;

    @Autowired
    private Notifier notifier;

    @Autowired
    private String myValue;

    @Autowired
    private int notificationCode;

    @Autowired
    private EventPublisher eventPublisher;

    @Value("injection directe")
    private String injectedValue;

    @PostConstruct
    private void init() {
        System.out.println("MY VALUE " + myValue);
        System.out.println("NOTIFICATION CODE " + notificationCode);
        System.out.println("INJECTED VALUE " + injectedValue);
    }

    public int createUser(User newUser) {
        System.out.println("Beginning method createUser");

        int confirmationCode = this.persister.persist(newUser);

        notificationCode = this.notifier.sendNotification("User " + newUser.toString() + " created");
        System.out.println("Notification Code " + notificationCode);
        System.out.println("Ending method createUser");

        eventPublisher.publishMyEvent("publication event live from UserService");

        return confirmationCode;
    }

    public int getNotificationCode() {
        return notificationCode;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("SET BEAN NAME " + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SET APPLICATION CONTEXT " + applicationContext);
    }
}
