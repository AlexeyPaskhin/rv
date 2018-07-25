package com.pages;

import com.Elements.Element;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * "/users/achievements"
 */

@Getter
public class AchievementsPage extends AbstractPage {

    private Element ACHIEVEMENT_IMAGE_FOR_AGE_ITEM = new Element(By.xpath("//h5[text()='Драгоценный опыт']/..//img"));
    private Element LABEL_NEW_ACHIEVEMENT_FOR_AGE_ITEM = ACHIEVEMENT_IMAGE_FOR_AGE_ITEM.getSubElementByXpath("/../span[@class='achievement__new-label']");
    private Element ACHIEVEMENT_NAME_FOR_AGE_ITEM = ACHIEVEMENT_IMAGE_FOR_AGE_ITEM.getSubElementByXpath("/../../p[@class='achievement__name']");


    public Boolean achievementIsDisabled(Element achievementImage) {
        return achievementImage.getAttribute("src").contains("reward_disabled") &&
                !achievementImage.getAttribute("title").contains("получена");
    }

    public Boolean achievementIsEnabled(Element achievementImage) {
        return achievementImage.getAttribute("src").contains("reward_active") &&
                achievementImage.getAttribute("title").contains("получена");
    }

}
