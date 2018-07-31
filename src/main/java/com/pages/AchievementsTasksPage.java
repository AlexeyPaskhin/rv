package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * /users/achievements-tasks
 */
@Getter
public class AchievementsTasksPage extends AbstractPage {
    private Element IMAGE_ACHIEVEMENT_FOR_REGISTRATION = new Element(By.xpath("//h5[text()='Первые шаги']/..//img[@alt='Хлеб-соль']"));
    private Element IMAGE_ACHIEVEMENT_FOR_EMAIL_CONFIRMATION = new Element(By.xpath("//h5[text()='Первые шаги']/..//img[@alt='Пляшите, Вам письмо']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PHONE_CONFIRMATION = new Element(By.xpath("//h5[text()='Первые шаги']/..//img[@alt='На проводе']"));
    private Element IMAGE_ACHIEVEMENT_FOR_FILLING_PERSONAL_INFO = new Element(By.xpath("//h5[text()='Первые шаги']/..//img[@alt='По всей форме']"));
    private Element IMAGE_ACHIEVEMENT_FOR_REFILLING_ACCOUNT = new Element(By.xpath("//h5[text()='Первые шаги']/..//img[@alt='С почином!']"));

    private Button GET_GIFT_FOR_FIRST_STEPS = new Button(By.xpath("//h5[text()='Первые шаги']/..//button[contains(text(), 'Забрать подарок')]"));
    private Button PROMO_CODE_FOR_FIRST_STEPS = new Button(By.xpath("//h5[text()='Первые шаги']/..//div[@class='achievement-task__tooltip-code']"));

    public Boolean achievementIsReceived(Element achievementImage) {
        return !achievementImage.getAttribute("src").contains("inactive") &&
                achievementImage.getSubElementByXpath("/../..//p[3]").getAttribute("class").equals("achievement__status  achievement__status--received");
    }

    public String getNameOfAchievement(Element achievementImage) {
        return achievementImage.getSubElementByXpath("/../../h3[@class='achievement__name']").getText();
    }

    public Boolean labelNewIsPresentOnAchievement(Element achievementImage) {
        return achievementImage.getSubElementByXpath("/../span[@class='achievement__new-label']").isPresent();
    }

    @Step
    public AchievementsTasksPage clickGetGiftForFirstSteps() {
        GET_GIFT_FOR_FIRST_STEPS.click();
        return this;
    }
}
