package com.utils;

public class CustomDataProvider {
    private static PropertyLoader propertyLoader;
    private String email;
    private String emailForAutogen;
    private String URL;
    private String domain;
    private String browser;
    private String pass;

    private  String emailVK;
    private  String passVK;

    private  String emailFB;
    private  String passFB;

    private  String emailOK;
    private  String passOK;

    private  String emailYA;
    private  String passYA;

    private  String emailMailRU;
    private  String passMailRU;

    public CustomDataProvider() {
        propertyLoader = new PropertyLoader();
        this.email = propertyLoader.getEmail();
        this.emailForAutogen = propertyLoader.getEmailForAutogen();
        this.URL = propertyLoader.getURL();
        this.domain = propertyLoader.getDomain();
        this.browser = propertyLoader.getBrowser();
        this.pass = propertyLoader.getPass();

        this.emailVK = propertyLoader.getEmailVK();
        this.passVK = propertyLoader.getPassVK();

        this.emailFB = propertyLoader.getEmailFB();
        this.passFB = propertyLoader.getPassFB();

        this.emailOK = propertyLoader.getEmailOK();
        this.passOK = propertyLoader.getPassOK();

        this.emailYA = propertyLoader.getEmailYA();
        this.passYA = propertyLoader.getPassYA();

        this.emailMailRU = propertyLoader.getEmailMailRU();
        this.passMailRU = propertyLoader.getPassMailRU();
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

    public String getEmailVK() { return this.emailVK; }
    public String getPassVK() { return this.passVK; }

    public String getEmailFB() { return this.emailFB; }
    public String getPassFB() { return this.passFB; }

    public String getEmailOK() { return this.emailOK; }
    public String getPassOK() { return this.passOK; }

    public String getEmailYA() { return this.emailYA; }
    public String getPassYA() { return this.passYA; }

    public String getEmailMailRU() { return this.emailMailRU; }
    public String getPassMailRU() { return this.passMailRU; }

}
