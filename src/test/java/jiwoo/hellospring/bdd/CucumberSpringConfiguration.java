package jiwoo.hellospring.bdd;

import io.cucumber.spring.CucumberContextConfiguration;
import jiwoo.hellospring.HelloSpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = HelloSpringApplication.class)
public class CucumberSpringConfiguration {
}
