package fr.nadeva.spring.dependencyinjection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import fr.nadeva.spring.dependencyinjection.model.User;
import fr.nadeva.spring.dependencyinjection.notifier.Notifier;
import fr.nadeva.spring.dependencyinjection.persistence.Persister;


public class UserService {

    @Autowired
    private Persister persister;

    @Autowired
    private Notifier notifier;

    private int notificationCode;

    public int createUser(User newUser) {

        System.out.println("Beginning method createUser");

        int confirmationCode = this.persister.persist(newUser);

        notificationCode = this.notifier.sendNotification("User " + newUser.toString() + " created");
        System.out.println("Notification Code " + notificationCode);

        System.out.println("Ending method createUser");

        return confirmationCode;
    }

    public int getNotificationCode() {
        return notificationCode;
    }


}
