package com.pages;

import com.Elements.Element;
import org.openqa.selenium.By;

/**
 * page Rules and Conditions - /rules
 */

public class RulesPage extends AbstractPage {

    private static final Element H1_TEXT = new Element(By.xpath("//h1[contains(text(), 'Правила и условия онлайн казино Русский Вулкан')]"));

    public HeaderNotAutorizedUser getNotAuthorizedHeader() {
        return new HeaderNotAutorizedUser();
    }

    public HeaderAutorizedUser getAuthorizedHeader() {
        return new HeaderAutorizedUser();
    }

    public boolean isRulesPageLoaded() {
        H1_TEXT.waitForElementToBeVisible(5);
        return H1_TEXT.isVisible();
    }
}
