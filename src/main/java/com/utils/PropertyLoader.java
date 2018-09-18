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

    // for negative test case
    protected String getDomainWithoutAt() {
        return prop.getProperty("domainWithoutAt");
    }

    protected String getPass() {
        return prop.getProperty("password");
    }

    /*
     * email's and pass's for social authorization from config.properties
     * */
    protected String getAuthEmailVK() {
        return prop.getProperty("userAuthLoginVK");
    }

    protected String getAuthPassVK() {
        return prop.getProperty("userAuthPassVK");
    }

    protected String getAuthEmailFB() {
        return prop.getProperty("userAuthLoginFB");
    }

    protected String getAuthPassFB() {
        return prop.getProperty("userAuthPassFB");
    }

    protected String getAuthEmailOK() {
        return prop.getProperty("userAuthLoginOK");
    }

    protected String getAuthPassOK() {
        return prop.getProperty("userAuthPassOK");
    }

    protected String getAuthEmailYA() {
        return prop.getProperty("userAuthLoginYA");
    }

    protected String getAuthPassYA() {
        return prop.getProperty("userAuthPassYA");
    }

    protected String getAuthEmailMailRU() {
        return prop.getProperty("userAuthLoginMailRU");
    }

    protected String getAuthPassMailRU() {
        return prop.getProperty("userAuthPassMailRU");
    }

    /*
     * email's and pass's for email authorization from config.properties
     * */
    protected String getAuthEmail() {
        return prop.getProperty("userAuthLogin");
    }

    protected String getAuthPass() {
        return prop.getProperty("userAuthPass");
    }

    protected String getProdAuthEmail() {
        return prop.getProperty("prodUserAuthLogin");
    }

    protected String getProdAuthPass() {
        return prop.getProperty("prodUserAuthPass");
    }

    /*
     * email's and pass's for social registration from config.properties
     * */
    protected String getRegisterEmailVK() {
        return prop.getProperty("userRegisterLoginVK");
    }

    protected String getRegisterPassVK() {
        return prop.getProperty("userRegisterPassVK");
    }
    protected String getRegisterEmailVKAndroid() {
        return prop.getProperty("userRegisterLoginVKAndroid");
    }

    protected String getRegisterPassVKAndroid() {
        return prop.getProperty("userRegisterPassVKAndroid");
    }

    protected String getRegisterEmailFB() {
        return prop.getProperty("userRegisterLoginFB");
    }

    protected String getRegisterEmailFBAndroid() {
        return prop.getProperty("userRegisterLoginFBAndroid");
    }

    protected String getRegisterPassFB() {
        return prop.getProperty("userRegisterPassFB");
    }

    protected String getRegisterPassFBAndroid() {
        return prop.getProperty("userRegisterPassFBAndroid");
    }

    protected String getRegisterEmailOK() {
        return prop.getProperty("userRegisterLoginOK");
    }

    protected String getRegisterPassOK() {
        return prop.getProperty("userRegisterPassOK");
    }

    protected String getRegisterEmailOKAndroid() {
        return prop.getProperty("userRegisterLoginOKAndroid");
    }

    protected String getRegisterPassOKAndroid() {
        return prop.getProperty("userRegisterPassOKAndroid");
    }

    protected String getRegisterEmailYA() {
        return prop.getProperty("userRegisterLoginYA");
    }

    protected String getRegisterPassYA() {
        return prop.getProperty("userRegisterPassYA");
    }

    protected String getRegisterEmailYAAndroid() {
        return prop.getProperty("userRegisterLoginYAAndroid");
    }

    protected String getRegisterPassYAAndroid() {
        return prop.getProperty("userRegisterPassYAAndroid");
    }

    protected String getRegisterEmailMailRU() {
        return prop.getProperty("userRegisterLoginMailRU");
    }

    protected String getRegisterPassMailRU() {
        return prop.getProperty("userRegisterPassMailRU");
    }
   protected String getRegisterEmailMailRUAndroid() {
        return prop.getProperty("userRegisterLoginMailRUAndroid");
    }

    protected String getRegisterPassMailRUAndroid() {
        return prop.getProperty("userRegisterPassMailRUAndroid");
    }

     // MasterCard credentials from config.properties
    protected String getCardNumberMaster() {
        return prop.getProperty("cardNumberMaster");
    }

    protected String getCardHolderMaster() {
        return prop.getProperty("cardHolderMaster");
    }

    protected String getCardCvvMaster() {
        return prop.getProperty("cardCvvMaster");
    }

// MasterCard prod credentials from config.properties
    protected String getProdCardNumberMaster() {
        return prop.getProperty("prodCardNumberMaster");
    }

    protected String getProdCardHolderMaster() {
        return prop.getProperty("prodCardHolderMaster");
    }

    protected String getProdCardCvvMaster() {
        return prop.getProperty("prodCardCvvMaster");
    }

    // Email for recovery password
    protected String getPassRecoveryEmail() {
        return prop.getProperty("userResetPasswordEmail");
    }

    protected String getFbGroupURL() {
        return prop.getProperty("fbGroupURL");
    }

    public String getTwitterGroupURL() {
        return prop.getProperty("twitterGroupURL");
    }

    public String getOkGroupURL() {
        return prop.getProperty("okGroupURL");
    }

    public String getVkGroupURL() {
        return prop.getProperty("vkGroupURL");
    }

    public String getYoutubeGroupURL() {
        return prop.getProperty("youtubeGroupURL");
    }

    public String getGoogleGroupURL() {
        return prop.getProperty("googleGroupURL");
    }

    public String getInstagramGroupURL() {
        return prop.getProperty("instagramGroupURL");
    }
}
