package fr.nadeva.spring.depencyinjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.nadeva.spring.dependencyinjection.MyConfiguration;
import fr.nadeva.spring.dependencyinjection.UserService;
import fr.nadeva.spring.dependencyinjection.model.User;
import fr.nadeva.spring.dependencyinjection.notifier.Notifier;
import fr.nadeva.spring.dependencyinjection.persistence.Persister;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfiguration.class})
public class InjectionByClassPackageScanTest {

    @Autowired
    private UserService userService;


    @Test
    public void injection() {
        int returnCode = userService.createUser(new User("John", "john@doe.com"));
        assertThat(returnCode).isEqualTo(Persister.DATABASE);
        assertThat(userService.getNotificationCode()).isEqualTo(Notifier.EMAIL);
    }
}
