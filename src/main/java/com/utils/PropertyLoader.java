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

    /*
     * email's and pass's for social authorization from config.properties
     * */
    protected  String getAuthEmailVK() { return prop.getProperty("userAuthLoginVK"); }
    protected  String getAuthPassVK() { return prop.getProperty("userAuthPassVK"); }
    protected  String getAuthEmailFB() { return prop.getProperty("userAuthLoginFB"); }
    protected  String getAuthPassFB() { return prop.getProperty("userAuthPassFB"); }
    protected  String getAuthEmailOK() { return prop.getProperty("userAuthLoginOK"); }
    protected  String getAuthPassOK() { return prop.getProperty("userAuthPassOK"); }
    protected  String getAuthEmailYA() { return prop.getProperty("userAuthLoginYA"); }
    protected  String getAuthPassYA() { return prop.getProperty("userAuthPassYA"); }
    protected  String getAuthEmailMailRU() { return prop.getProperty("userAuthLoginMailRU"); }
    protected  String getAuthPassMailRU() { return prop.getProperty("userAuthPassMailRU"); }

    /*
     * email's and pass's for social registration from config.properties
     * */
    protected  String getRegisterEmailVK() { return prop.getProperty("userRegisterLoginVK"); }
    protected  String getRegisterPassVK() { return prop.getProperty("userRegisterPassVK"); }
    protected  String getRegisterEmailFB() { return prop.getProperty("userRegisterLoginFB"); }
    protected  String getRegisterPassFB() { return prop.getProperty("userRegisterPassFB"); }
    protected  String getRegisterEmailOK() { return prop.getProperty("userRegisterLoginOK"); }
    protected  String getRegisterPassOK() { return prop.getProperty("userRegisterPassOK"); }
    protected  String getRegisterEmailYA() { return prop.getProperty("userRegisterLoginYA"); }
    protected  String getRegisterPassYA() { return prop.getProperty("userRegisterPassYA"); }
    protected  String getRegisterEmailMailRU() { return prop.getProperty("userRegisterLoginMailRU"); }
    protected  String getRegisterPassMailRU() { return prop.getProperty("userRegisterPassMailRU"); }

    protected String getCardNumberMaster() { return prop.getProperty("cardNumberMaster"); }
    protected String getCardHolderMaster() { return prop.getProperty("cardHolderMaster"); }
    protected String getCardCvvMaster() { return prop.getProperty("cardCvvMaster"); }
}
