package com.pages;

import com.Elements.Element;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * "/users/achievements"
 */

@Getter
public class AchievementsPage extends AbstractPage {

    private Element IMAGE_ACHIEVEMENT_FOR_AGE_ITEM = new Element(By.xpath("//h5[text()='Драгоценный опыт']/..//img"));
    private Element LABEL_NEW_ACHIEVEMENT_FOR_AGE_ITEM = IMAGE_ACHIEVEMENT_FOR_AGE_ITEM.getSubElementByXpath("/../span[@class='achievement__new-label']");
    private Element NAME_OF_ACHIEVEMENT_FOR_AGE_ITEM = IMAGE_ACHIEVEMENT_FOR_AGE_ITEM.getSubElementByXpath("/../../p[@class='achievement__name']");

    private Element IMAGE_ACHIEVEMENT_FOR_DEPS_ITEM = new Element(By.xpath("//h5[text()='Деньги любят счёт']/..//img"));
    private Element LABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM = IMAGE_ACHIEVEMENT_FOR_DEPS_ITEM.getSubElementByXpath("/../span[@class='achievement__new-label']");
    private Element NAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM = IMAGE_ACHIEVEMENT_FOR_DEPS_ITEM.getSubElementByXpath("/../../p[@class='achievement__name']");

    private Element IMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM = new Element(By.xpath("//h5[text()='Фортуна-лотерея']/..//img"));
    private Element LABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM = IMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM.getSubElementByXpath("/../span[@class='achievement__new-label']");
    private Element NAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM = IMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM.getSubElementByXpath("/../../p[@class='achievement__name']");


    public Boolean achievementIsDisabled(Element achievementImage) {
        return achievementImage.getAttribute("src").contains("reward_disabled") &&
                !achievementImage.getAttribute("title").contains("получена");
    }

    public Boolean achievementIsEnabled(Element achievementImage) {
        return achievementImage.getAttribute("src").contains("reward_active") &&
                achievementImage.getAttribute("title").contains("получена");
    }

}
