package fr.nadeva.spring.dependencyinjection.notifier;

public interface Notifier {

    int EMAIL = 1;
    int SMS = 2;
    int SMOKE_SIGNAL = 3;
    int CARRIER_PIGEON = 3;

    int sendNotification(String notificationMessage);
}
