package fr.nadeva.spring.dependencyinjection.persistence;


import fr.nadeva.spring.dependencyinjection.model.User;

public interface Persister {

    int DATABASE = 1;
    int PERSISTER = 0;

    int persist(User userToPersist);
}
