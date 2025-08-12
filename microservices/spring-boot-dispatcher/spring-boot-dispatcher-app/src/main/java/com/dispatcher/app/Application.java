package com.dispatcher.app;

import com.dispatcher.odoo.Session;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dispatcher"})
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private final Environment environment;
    private final Session session;

    public Application(Environment environment, Session session) {
        this.environment = environment;
        this.session = session;
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
        try {
            session.startSession();
        } catch (Exception e) {
            logger.error("error in connecting odoo server");
        }
    }
}
