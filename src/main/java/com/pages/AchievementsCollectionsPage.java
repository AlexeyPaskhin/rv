package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * /users/achievements-collections
 */
@Getter
public class AchievementsCollectionsPage extends AbstractPage {
    private Element COLLECTION_TABS_HEADER = new Element(By.xpath("//div[@class='collection-tabs__header']"));
    private Element IMAGE_OF_DISPLAYED_COLLECTION_ITEM = new Element(By.xpath("//div[@class='collection-tabs__body-item active']//img"));
    private Button GET_A_GIFT_BUTTON = new Button(By.xpath("//div[@class='collection-tabs__body-item active']//a[@data-collection-promocode]"));
    private Element PROMO_CODE = new Element(By.xpath("//div[@class='collection-album__promocode']"));

    public AchievementsCollectionsPage clickNeededGame(String titleForFrontEndSelector) {
        COLLECTION_TABS_HEADER.getSubElementByXpath("/div[@data-tab-for='" + titleForFrontEndSelector + "']").click();
        return this;
    }

    public Boolean achievementIsActiveByNumber(int numberOfAchievement) {
        return ! IMAGE_OF_DISPLAYED_COLLECTION_ITEM.getAllElements().get(numberOfAchievement-1).getAttribute("src").contains("inactive");
    }

    public Boolean labelNewOnAchievementByNumberIsPresent(int numberOfAchievement) {
        return IMAGE_OF_DISPLAYED_COLLECTION_ITEM.getAllElements().get(numberOfAchievement-1)
                .getSubElementByXpath("/../span[@class='achievement__new-label']").isPresent();
    }

    public AchievementsCollectionsPage clickGetPromoCode() {
        GET_A_GIFT_BUTTON.click();
        return this;
    }

}
