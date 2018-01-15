package com.utils;


public class CustomDataProvider {
    private static PropertyLoader propertyLoader;
    private String email;
    private String emailForAutogen;
    private String URL;
    private String domain;
    private String browser;
    private String pass;

    public CustomDataProvider() {
        propertyLoader = new PropertyLoader();
        this.email = propertyLoader.getEmail();
        this.emailForAutogen = propertyLoader.getEmailForAutogen();
        this.URL = propertyLoader.getURL();
        this.domain = propertyLoader.getDomain();
        this.browser = propertyLoader.getBrowser();
        this.pass = propertyLoader.getPass();
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

}
