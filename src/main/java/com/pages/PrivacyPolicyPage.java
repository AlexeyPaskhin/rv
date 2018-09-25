package com.pages;

/**
 * /privacy-policy
 */
public class PrivacyPolicyPage extends AbstractPage {
    private static String title = "Политика конфиденциальности казино Русский Вулкан";

    public Boolean isLoaded() {
        return getTitle().equals(title);
    }
}
