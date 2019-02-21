package fr.nadeva.spring.dependencyinjection.persistence;

import org.springframework.stereotype.Component;

import fr.nadeva.spring.dependencyinjection.model.User;

@Component
public class DatabasePersister implements Persister {
    @Override
    public int persist(User userToPersist) {
        System.out.println("Database Persist");
        return Persister.DATABASE;
    }
}
