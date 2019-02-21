package fr.nadeva.spring.dependencyinjection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import fr.nadeva.spring.dependencyinjection.model.User;
import fr.nadeva.spring.dependencyinjection.persistence.Persister;

public class Main {


    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("META-INF/spring/xml-bean-factory-config.xml"));

        Persister persister = (Persister) factory.getBean("persister");
        int returnCode = persister.persist(new User("John", "john@doe.com"));
        System.out.println("Return code " + returnCode);
    }
}
