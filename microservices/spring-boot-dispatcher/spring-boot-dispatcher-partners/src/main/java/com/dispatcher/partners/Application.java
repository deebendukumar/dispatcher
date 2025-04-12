package com.dispatcher.partners;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private final Environment environment;

    public Application(Environment environment) {
        this.environment = environment;
    }

    /**
     * void main.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * The @PostConstruct annotation can only be used on methods that are declared as public or protected.
     * It cannot be used on static methods or methods that have a return type other than void.
     */
    @PostConstruct
    public void init() {
        //TODO
    }
}
