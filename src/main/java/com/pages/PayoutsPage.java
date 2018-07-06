package com.pages;

/**
 * /payouts
 */
public class PayoutsPage extends AbstractPage {
    private static String title = "Получение выигрышей в казино Русский Вулкан";

    public Boolean isLoaded() {
        return getTitle().equals(title);
    }
}
