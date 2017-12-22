package com.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class was created to work with Properties, please use this class to read Properties don't be an asshole
 */

public class PropertyLoader {
   private final static Logger logger = LogManager.getLogger(PropertyLoader.class);
    private Properties prop = new Properties();
    private FileInputStream is;

    public PropertyLoader() {
        try {
            is = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                    File.separator + "resources" + File.separator + "properties" + File.separator + "config.properties");
            prop.load(is);
        } catch (IOException e) {
            logger.error("Something wrong with property file");
        }
    }

    protected String getBrowser() {
        return prop.getProperty("browser");
    }

    protected String getURL() {
        return prop.getProperty("basicURL");
    }

    protected String getEmailForAutogen() {
        return prop.getProperty("userLoginForAutoGen");
    }

    protected String getEmail() {
        return prop.getProperty("userLogin");
    }

    protected String getDomain() {
        return prop.getProperty("domain");
    }

    protected String getPass() {
        return prop.getProperty("password");
    }
}
