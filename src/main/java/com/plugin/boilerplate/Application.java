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
        application.outputMessage("outputting from application.");
    }

    /**
     * Logout a message.
     * @param message
     */
    public void outputMessage(final String message) {
        LOGGER.info(message);
    }
}
