package org.bindiego;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.configuration.ConfigurationException;

//import org.bindiego.servicepal.FaceRecognition;
import org.bindiego.util.Config;

import org.bindiego.google.translate.CloudTranslate;

/**
 * ServicePal image identification application
 * http://www.faceplusplus.com/
 */
public class App
{
    private static final Logger logger =
        LogManager.getFormatterLogger(App.class.getName());

    private static PropertiesConfiguration config;

    public static void main(String... args)
    {
        config = Config.getConfig();

        logger.info(config.getProperty("app.name").toString() + " started");

        // new FaceRecognition();

        if (config.getProperty("google.translate").toString().equalsIgnoreCase("on"))
            new CloudTranslate().start();

        logger.info(config.getProperty("app.name").toString() + " Stopped");
    }
}
