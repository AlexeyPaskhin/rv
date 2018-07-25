package com.utils;

public class CustomDataProvider {
    private static PropertyLoader propertyLoader;
    private String email;
    private String emailForAutogen;
    private String URL;
    private String domain;
    private String browser;
    private String pass;
    private String domainWithoutAt;

    /* email's and pass's for social authorization */
    private String emailAuthVK;
    private String passAuthVK;
    private String emailAuthFB;
    private String passAuthFB;
    private String emailAuthOK;
    private String passAuthOK;
    private String emailAuthYA;
    private String passAuthYA;
    private String emailAuthMailRU;
    private String passAuthMailRU;
    /* email's and pass's for authorization via email */
    private String emailAuth;
    private String passAuth;

    /* email's and pass's for social registration */
    private String emailRegisterVK;
    private String passRegisterVK;
    private String emailRegisterVKAndroid;
    private String passRegisterVKAndroid;
    private String emailRegisterFB;
    private String emailRegisterFBAndroid;
    private String passRegisterFB;
    private String passRegisterFBAndroid;
    private String emailRegisterOK;
    private String passRegisterOK;
    private String emailRegisterOKAndroid;
    private String passRegisterOKAndroid;
    private String emailRegisterYA;
    private String passRegisterYA;
    private String emailRegisterYAAndroid;
    private String passRegisterYAAndroid;
    private String emailRegisterMailRU;
    private String passRegisterMailRU;
    private String emailRegisterMailRUAndroid;
    private String passRegisterMailRUAndroid;

    /* credential for MasterCard */
    private String cardNumberMaster;
    private String cardHolderMaster;
    private String cardCvvMaster;

    // password recovery
    private String passRecoveryEmail;

    //URLs of our groups at social networks
    private String fbGroupURL;
    private String twitterGroupURL;
    private String okGroupURL;
    private String vkGroupURL;
    private String youtubeGroupURL;
    private String googleGroupURL;
    private String instagramGroupURL;

    public CustomDataProvider() {
        propertyLoader = new PropertyLoader();
        this.email = propertyLoader.getEmail();
        this.emailForAutogen = propertyLoader.getEmailForAutogen();
        this.URL = propertyLoader.getURL();
        this.domain = propertyLoader.getDomain();
        this.browser = propertyLoader.getBrowser();
        this.pass = propertyLoader.getPass();
        this.domainWithoutAt = propertyLoader.getDomainWithoutAt();

        /* get email's and pass's for social authorization from PropertyLoader */
        this.emailAuthVK = propertyLoader.getAuthEmailVK();
        this.passAuthVK = propertyLoader.getAuthPassVK();
        this.emailAuthFB = propertyLoader.getAuthEmailFB();
        this.passAuthFB = propertyLoader.getAuthPassFB();
        this.emailAuthOK = propertyLoader.getAuthEmailOK();
        this.passAuthOK = propertyLoader.getAuthPassOK();
        this.emailAuthYA = propertyLoader.getAuthEmailYA();
        this.passAuthYA = propertyLoader.getAuthPassYA();
        this.emailAuthMailRU = propertyLoader.getAuthEmailMailRU();
        this.passAuthMailRU = propertyLoader.getAuthPassMailRU();

        /* email's and pass's for authorization via email */
        this.emailAuth = propertyLoader.getAuthEmail();
        this.passAuth = propertyLoader.getAuthPass();

        /* email's and pass's for social registeration from PropertyLoader */
        this.emailRegisterVK = propertyLoader.getRegisterEmailVK();
        this.passRegisterVK = propertyLoader.getRegisterPassVK();
        this.emailRegisterVKAndroid = propertyLoader.getRegisterEmailVKAndroid();
        this.passRegisterVKAndroid = propertyLoader.getRegisterPassVKAndroid();
        this.emailRegisterFB = propertyLoader.getRegisterEmailFB();
        this.emailRegisterFBAndroid = propertyLoader.getRegisterEmailFBAndroid();
        this.passRegisterFB = propertyLoader.getRegisterPassFB();
        this.passRegisterFBAndroid = propertyLoader.getRegisterPassFBAndroid();
        this.emailRegisterOK = propertyLoader.getRegisterEmailOK();
        this.passRegisterOK = propertyLoader.getRegisterPassOK();
        this.emailRegisterOKAndroid = propertyLoader.getRegisterEmailOKAndroid();
        this.passRegisterOKAndroid = propertyLoader.getRegisterPassOKAndroid();
        this.emailRegisterYA = propertyLoader.getRegisterEmailYA();
        this.passRegisterYA = propertyLoader.getRegisterPassYA();
        this.emailRegisterYAAndroid = propertyLoader.getRegisterEmailYAAndroid();
        this.passRegisterYAAndroid = propertyLoader.getRegisterPassYAAndroid();
        this.emailRegisterMailRU = propertyLoader.getRegisterEmailMailRU();
        this.passRegisterMailRU = propertyLoader.getRegisterPassMailRU();
        this.emailRegisterMailRUAndroid = propertyLoader.getRegisterEmailMailRUAndroid();
        this.passRegisterMailRUAndroid = propertyLoader.getRegisterPassMailRUAndroid();

        /* email and pass for authorization from PropertyLoader */
        this.cardNumberMaster = propertyLoader.getCardNumberMaster();
        this.cardHolderMaster = propertyLoader.getCardHolderMaster();
        this.cardCvvMaster = propertyLoader.getCardCvvMaster();

        /* password recovery e-mail */
        this.passRecoveryEmail = propertyLoader.getPassRecoveryEmail();

        //URLs of our groups at social networks
        this.fbGroupURL = propertyLoader.getFbGroupURL();
        this.twitterGroupURL = propertyLoader.getTwitterGroupURL();
        this.okGroupURL = propertyLoader.getOkGroupURL();
        this.vkGroupURL = propertyLoader.getVkGroupURL();
        this.youtubeGroupURL = propertyLoader.getYoutubeGroupURL();
        this.googleGroupURL = propertyLoader.getGoogleGroupURL();
        this.instagramGroupURL = propertyLoader.getInstagramGroupURL();
    }

    String generateRandomEmail() {
        int userLoginLength = emailForAutogen.length();
        int domainLength = domain.length();
        return emailForAutogen + RandomGenerate.randomString(34 - userLoginLength - domainLength) + domain;
    }

    public String getBasicURL() {
        return this.URL;
    }

    public String getEmail() {
        return this.email + this.domain;
    }

    public String getEmailForAutogen() {
        return this.emailForAutogen + this.domain;
    }

    public String getBrowser() {
        return this.browser;
    }

    String generateRandomPass() {
        return RandomGenerate.randomString(3, 33);
    }

    public String getPassword() {
        return this.pass;
    }

    /*
     * getters for social auth users email's and pass's
     * */
    public String getAuthEmailVK() {
        return this.emailAuthVK;
    }

    public String getAuthPassVK() {
        return this.passAuthVK;
    }

    public String getAuthEmailFB() {
        return this.emailAuthFB;
    }

    public String getAuthPassFB() {
        return this.passAuthFB;
    }

    public String getAuthEmailOK() {
        return this.emailAuthOK;
    }

    public String getAuthPassOK() {
        return this.passAuthOK;
    }

    public String getAuthEmailYA() {
        return this.emailAuthYA;
    }

    public String getAuthPassYA() {
        return this.passAuthYA;
    }

    public String getAuthEmailMailRU() {
        return this.emailAuthMailRU;
    }

    public String getAuthPassMailRU() {
        return this.passAuthMailRU;
    }

    /*
     * getters for auth via email
     * */
    public String getAuthEmail() {
        return this.emailAuth;
    }

    public String getAuthPass() {
        return this.passAuth;
    }

    /*
     * getters for social register users email's and pass's
     * */
    public String getRegisterEmailVK() {
        return this.emailRegisterVK;
    }

    public String getRegisterEmailVKAndroid() {
        return this.emailRegisterVKAndroid;
    }

    public String getRegisterPassVK() {
        return this.passRegisterVK;
    }

    public String getRegisterPassVKAndroid() {
        return this.passRegisterVKAndroid;
    }

    public String getRegisterEmailFB() {
        return this.emailRegisterFB;
    }

    public String getRegisterEmailFBAndroid() {
        return this.emailRegisterFBAndroid;
    }

    public String getRegisterPassFB() {
        return this.passRegisterFB;
    }

    public String getRegisterPassFBAndroid() {
        return this.passRegisterFBAndroid;
    }

    public String getRegisterEmailOK() {
        return this.emailRegisterOK;
    }

    public String getRegisterPassOK() {
        return this.passRegisterOK;
    }

    public String getRegisterEmailOKAndroid() {
        return this.emailRegisterOKAndroid;
    }

    public String getRegisterPassOKAndroid() {
        return this.passRegisterOKAndroid;
    }

    public String getRegisterEmailYA() {
        return this.emailRegisterYA;
    }

    public String getRegisterPassYA() {
        return this.passRegisterYA;
    }

    public String getRegisterEmailYAAndroid() {
        return this.emailRegisterYAAndroid;
    }

    public String getRegisterPassYAAndroid() {
        return this.passRegisterYAAndroid;
    }

    public String getRegisterEmailMailRU() {
        return this.emailRegisterMailRU;
    }

    public String getRegisterPassMailRU() {
        return this.passRegisterMailRU;
    }

    public String getRegisterEmailMailRUAndroid() {
        return this.emailRegisterMailRUAndroid;
    }

    public String getRegisterPassMailRUAndroid() {
        return this.passRegisterMailRUAndroid;
    }

    /*
     * getters for card credential
     * */
    public String getCardNumberMaster() {
        return this.cardNumberMaster;
    }

    public String getCardHolderMaster() {
        return this.cardHolderMaster;
    }

    public String getCardCvvMaster() {
        return this.cardCvvMaster;
    }

    // for negative test cases
    String generateRandomEmailWithoutAt() {
        int userLoginLength = emailForAutogen.length();
        int domainLength = domainWithoutAt.length();
        return emailForAutogen + RandomGenerate.randomString(34 - userLoginLength - domainLength) + domainWithoutAt;
    }

    public String getPassRecoveryEmail() {
        return this.passRecoveryEmail;
    }

    public String getFbGroupURL() {
        return this.fbGroupURL;
    }

    public String getTwitterGroupURL() {
        return this.twitterGroupURL;
    }

    public String getOkGroupUrl() {
        return this.okGroupURL;
    }

    public String getVkGroupUrl() {
        return this.vkGroupURL;
    }

    public String getYoutubeGroupUrl() {
        return this.youtubeGroupURL;
    }

    public String getGoogleGroupUrl() {
        return this.googleGroupURL;
    }

    public String getInstagramGroupUrl() {
        return this.instagramGroupURL;
    }
}
