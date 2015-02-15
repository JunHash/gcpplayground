package org.bindiego.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.configuration.ConfigurationException;

import org.bindiego.Settings;

public class Config implements Cloneable {

    private static final Logger logger =
        LogManager.getFormatterLogger(Config.class.getName());
    private static PropertiesConfiguration config = null;

    public Config clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static PropertiesConfiguration getConfig() {
        if (config == null) {
            try{
                config = new PropertiesConfiguration(
                    Settings.CONF_FILE);
            } catch (ConfigurationException e) {
                logger.fatal("Configuration failed to intialize", e);
            }

            config.setReloadingStrategy(new FileChangedReloadingStrategy());
            config.setAutoSave(true);
            config.setProperty("app.name", "Face Identification Application");
            //config.save();
        }

        return config;
    }
}
