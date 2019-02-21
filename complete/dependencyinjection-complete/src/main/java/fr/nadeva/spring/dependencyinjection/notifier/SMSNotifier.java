package fr.nadeva.spring.dependencyinjection.notifier;

import org.springframework.stereotype.Component;

@PhoneQualifier
@Component
public class SMSNotifier implements Notifier {

    @Override
    public int sendNotification(String notificationMessage) {
        System.out.println("Sending SMS [" + notificationMessage + "]");
        return Notifier.SMS;
    }
}
