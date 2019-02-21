package fr.nadeva.spring.rest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    private static final List<String> NAMES = Arrays.asList("Jean", "Marie", "Bob", "Moundir", "Joe", "Mei-Ling", "Buffy", "François", "Philippe", "Jean-Marie", "Momo");
    private static final List<String> LAST_NAMES = Arrays.asList("Macrou", "Filenchon", "Metaud", "Letou", "Chemignant", "Hapen", "Ficron", "Poupen", "Lemon");


    @RequestMapping("/student")
    @ResponseStatus(value = HttpStatus.OK)
    public Student generate(@RequestParam(value = "name", defaultValue = "bob") String name) {
        return new Student(name, LAST_NAMES.get(RandomUtils.nextInt(0, LAST_NAMES.size())));
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Student get(@PathVariable Long id) {
        return new Student(NAMES.get(RandomUtils.nextInt(0, NAMES.size())), LAST_NAMES.get(RandomUtils.nextInt(0, LAST_NAMES.size())));
    }
}
