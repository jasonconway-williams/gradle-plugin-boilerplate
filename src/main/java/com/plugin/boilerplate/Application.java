package com.plugin.boilerplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application boilerplate class.
 */
public final class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Creating an instance of Application.");
        final Application application = new Application();
        LOGGER.info(application.getGreeting("System"));
    }

    /**
     * Get a greeting message.
     * @param user
     */
    public String getGreeting(final String user) {
        return "Hello from the Application class " + user;
    }
}
