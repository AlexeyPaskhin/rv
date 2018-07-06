package com.pages;

/**
 * /faq
 */
public class FaqPage extends AbstractPage {
    private static String title = "FAQ и круглосуточная поддержка клиентов клуба Русский Вулкан:" +
            " мы доступны 24/7 по всей России, в Москве и Санкт-Петербурге.";

    public Boolean isLoaded() {
        return getTitle().equals(title);
    }
}
