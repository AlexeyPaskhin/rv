package com.pages;

import com.Elements.Element;
import io.qameta.allure.Step;
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

    private Element TASKS_TAB = new Element(By.xpath("//a[@href='/users/achievements-tasks']"));
    private Element COLLECTIONS_TAB = new Element(By.xpath("//a[@href='/users/achievements-collections']"));

    public Boolean achievementIsDisabled(Element achievementImage) {
        return achievementImage.getAttribute("src").contains("reward_disabled") &&
                !achievementImage.getAttribute("title").contains("получена");
    }

    public Boolean achievementIsEnabled(Element achievementImage) {
        return achievementImage.getAttribute("src").contains("reward_active") &&
                achievementImage.getAttribute("title").contains("получена");
    }

    @Step
    public AchievementsTasksPage clickTasksTab() {
        TASKS_TAB.click();
        return new AchievementsTasksPage();
    }

    @Step
    public AchievementsCollectionsPage clickCollectionsTab() {
        COLLECTIONS_TAB.click();
        return new AchievementsCollectionsPage();
    }

}
