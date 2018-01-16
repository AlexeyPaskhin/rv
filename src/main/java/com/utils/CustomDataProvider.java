package com.utils;

public class CustomDataProvider {
    private static PropertyLoader propertyLoader;
    private String email;
    private String emailForAutogen;
    private String URL;
    private String domain;
    private String browser;
    private String pass;

    /*
      * email's and pass's for social authorization
      * */
    private  String emailAuthVK;
    private  String passAuthVK;
    private  String emailAuthFB;
    private  String passAuthFB;
    private  String emailAuthOK;
    private  String passAuthOK;
    private  String emailAuthYA;
    private  String passAuthYA;
    private  String emailAuthMailRU;
    private  String passAuthMailRU;

    /*
      * email's and pass's for social registeration
      * */
    private  String emailRegisterVK;
    private  String passRegisterVK;
    private  String emailRegisterFB;
    private  String passRegisterFB;
    private  String emailRegisterOK;
    private  String passRegisterOK;
    private  String emailRegisterYA;
    private  String passRegisterYA;
    private  String emailRegisterMailRU;
    private  String passRegisterMailRU;

    public CustomDataProvider() {
        propertyLoader = new PropertyLoader();
        this.email = propertyLoader.getEmail();
        this.emailForAutogen = propertyLoader.getEmailForAutogen();
        this.URL = propertyLoader.getURL();
        this.domain = propertyLoader.getDomain();
        this.browser = propertyLoader.getBrowser();
        this.pass = propertyLoader.getPass();

        /*
         * get email's and pass's for social authorization from PropertyLoader
         * */
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

        /*
         * email's and pass's for social registeration from PropertyLoader
         * */
        this.emailRegisterVK = propertyLoader.getRegisterEmailVK();
        this.passRegisterVK = propertyLoader.getRegisterPassVK();
        this.emailRegisterFB = propertyLoader.getRegisterEmailFB();
        this.passRegisterFB = propertyLoader.getRegisterPassFB();
        this.emailRegisterOK = propertyLoader.getRegisterEmailOK();
        this.passRegisterOK = propertyLoader.getRegisterPassOK();
        this.emailRegisterYA = propertyLoader.getRegisterEmailYA();
        this.passRegisterYA = propertyLoader.getRegisterPassYA();
        this.emailRegisterMailRU = propertyLoader.getRegisterEmailMailRU();
        this.passRegisterMailRU = propertyLoader.getRegisterPassMailRU();
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
    public String getAuthEmailVK() { return this.emailAuthVK; }
    public String getAuthPassVK() { return this.passAuthVK; }
    public String getAuthEmailFB() { return this.emailAuthFB; }
    public String getAuthPassFB() { return this.passAuthFB; }
    public String getAuthEmailOK() { return this.emailAuthOK; }
    public String getAuthPassOK() { return this.passAuthOK; }
    public String getAuthEmailYA() { return this.emailAuthYA; }
    public String getAuthPassYA() { return this.passAuthYA; }
    public String getAuthEmailMailRU() { return this.emailAuthMailRU; }
    public String getAuthPassMailRU() { return this.passAuthMailRU; }

    /*
     * getters for social register users email's and pass's
     * */
    public String getRegisterEmailVK() { return this.emailRegisterVK; }
    public String getRegisterPassVK() { return this.passRegisterVK; }
    public String getRegisterEmailFB() { return this.emailRegisterFB; }
    public String getRegisterPassFB() { return this.passRegisterFB; }
    public String getRegisterEmailOK() { return this.emailRegisterOK; }
    public String getRegisterPassOK() { return this.passRegisterOK; }
    public String getRegisterEmailYA() { return this.emailRegisterYA; }
    public String getRegisterPassYA() { return this.passRegisterYA; }
    public String getRegisterEmailMailRU() { return this.emailRegisterMailRU; }
    public String getRegisterPassMailRU() { return this.passRegisterMailRU; }



}
