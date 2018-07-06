package com.pages;

/**
 * /sitemap
 */
public class SitemapPage extends AbstractPage {
    private static String title = "Карта сайта";

    public Boolean isLoaded() {
        return getTitle().equals(title);
    }
}
