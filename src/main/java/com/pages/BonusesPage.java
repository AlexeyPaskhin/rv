package com.pages;

import com.Elements.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Personal cabinet / Bonuses page - /users/bonuses
 */
public class BonusesPage extends AbstractPage {
    private final String BONUSES_PAGE_TITLE = "Бонусы в казино Русский Вулкан";
    Element bonusesTable = new Element(By.xpath("//table[@class='how_to_get vip_bonus']"));


    @Step
    public boolean isBonusesPageOpened() {
        return bonusesTable.isVisible();
    }
}
