package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * Personal cabinet - accessible only in authorised state  / Bonuses page - /users/bonuses
 */
@Getter
public class BonusesPage extends AbstractPage {
    private final String BONUSES_PAGE_TITLE = "История бонусов в казино";
    private Element bonusesTable = new Element(By.xpath("//table[@class='how_to_get vip_bonus']"));
    private Button ACTIVATE_FIRST_BONUS = new Button(By.xpath("//button[@class='bonus-first__action']"));


    @Step
    public boolean isBonusesPageOpened() {
        return this.getTitle().equals(BONUSES_PAGE_TITLE);
    }

    @Step
    public BonusesPage activateFirstBonus() {
        ACTIVATE_FIRST_BONUS.click();
        return this;
    }

}
