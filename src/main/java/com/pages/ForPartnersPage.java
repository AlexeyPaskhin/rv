package com.pages;

/**
 * http://cashplanet.org/?utm_medium=referal&utm_source=rv&utm_campaign=footer
 */
public class ForPartnersPage extends AbstractPage {
    private static String title = "Профессиональная монетизация азартного трафика - CashPlanet";

    public Boolean isLoaded() {
        return getTitle().equals(title);
    }
}
