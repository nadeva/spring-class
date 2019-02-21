package fr.nadeva.spring.depencyinjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.nadeva.spring.dependencyinjection.model.User;
import fr.nadeva.spring.dependencyinjection.notifier.Notifier;
import fr.nadeva.spring.dependencyinjection.persistence.Persister;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/xml-bean-factory-config.xml"})
public class InjectionByXMLDeclarationTest {

    @Test
    public void injection() {
    }
}
