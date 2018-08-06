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
    private Button GET_GIFT_FOR_THE_FIRST_STEPS = new Button(By.xpath("//h5[text()='Первые шаги']/..//button[contains(text(), 'Забрать подарок')]"));
    private Element PROMO_CODE_FOR_THE_FIRST_STEPS = new Element(By.xpath("//h5[text()='Первые шаги']/..//div[@class='achievement-task__tooltip-code']"));

    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_2_DAYS = new Element(By.xpath("//h5[text()='Ни дня без слота']/..//img[@alt='Активная игра']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_3_DAYS = new Element(By.xpath("//h5[text()='Ни дня без слота']/..//img[@alt='Да Вы композитор!']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_4_DAYS = new Element(By.xpath("//h5[text()='Ни дня без слота']/..//img[@alt='Любитель риска']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_5_DAYS = new Element(By.xpath("//h5[text()='Ни дня без слота']/..//img[@alt='Затяжная партия']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_6_DAYS = new Element(By.xpath("//h5[text()='Ни дня без слота']/..//img[@alt='Опытный слотонавт']"));
    private Button GET_GIFT_FOR_THE_NOT_A_DAY_WITHOUT_A_SLOT = new Button(By.xpath("//h5[text()='Ни дня без слота']/..//button[contains(text(), 'Забрать подарок')]"));
    private Element PROMO_CODE_FOR_THE_NOT_A_DAY_WITHOUT_A_SLOT = new Element(By.xpath("//h5[text()='Ни дня без слота']/..//div[@class='achievement-task__tooltip-code']"));

    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_20_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Полный атас']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_250_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Нерукотворный памятник']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_500_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Урал покорён']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_1000_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Не расстрелять, а наградить!']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_2500_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Вождь одобряет']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_5000_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Шайбу! Шайбу!']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_10000_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Супер-игра!']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_25000_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Князь всея Вулкана']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_50000_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Любимец клуба']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_100000_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Вверх, к звёздам!']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_250000_ROUNDS = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//img[@alt='Фаворит императрицы']"));
    private Button GET_GIFT_FOR_THE_AH_ONCE_AND_AGAIN = new Button(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//button[contains(text(), 'Забрать подарок')]"));
    private Element PROMO_CODE_FOR_THE_AH_ONCE_AND_AGAIN = new Element(By.xpath("//h5[text()='Эх, раз, да ещё раз']/..//div[@class='achievement-task__tooltip-code']"));

    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_5000_ROUNDS_PER_24_HOURS = new Element(By.xpath("//h5[text()='Время – деньги']/..//img[@alt='От рассвета до заката']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_10000_ROUNDS_PER_24_HOURS = new Element(By.xpath("//h5[text()='Время – деньги']/..//img[@alt='Сколько Вам отсыпать?']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_15000_ROUNDS_PER_48_HOURS = new Element(By.xpath("//h5[text()='Время – деньги']/..//img[@alt='Победа в кармане']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_20000_ROUNDS_PER_48_HOURS = new Element(By.xpath("//h5[text()='Время – деньги']/..//img[@alt='Накукуй на джекпот']"));
    private Element IMAGE_ACHIEVEMENT_FOR_PLAYING_25000_ROUNDS_PER_48_HOURS = new Element(By.xpath("//h5[text()='Время – деньги']/..//img[@alt='Часы стоят – игра идёт!']"));
    private Button GET_GIFT_FOR_THE_TIME_IS_MONEY = new Button(By.xpath("//h5[text()='Время – деньги']/..//button[contains(text(), 'Забрать подарок')]"));
    private Element PROMO_CODE_FOR_THE_TIME_IS_MONEY = new Element(By.xpath("//h5[text()='Время – деньги']/..//div[@class='achievement-task__tooltip-code']"));


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
    public AchievementsTasksPage clickGetGiftForTheFirstSteps() {
        GET_GIFT_FOR_THE_FIRST_STEPS.click();
        return this;
    }

    @Step
    public AchievementsTasksPage clickGetGiftForTheNotADayWithoutASlotTasks() {
        GET_GIFT_FOR_THE_NOT_A_DAY_WITHOUT_A_SLOT.click();
        return this;
    }

    @Step
    public AchievementsTasksPage clickGetGiftForTheAhOnceAndAgainTasks() {
        GET_GIFT_FOR_THE_AH_ONCE_AND_AGAIN.click();
        return this;
    }

    @Step
    public AchievementsTasksPage clickGetGiftForTheTimeIsMoneyTasks() {
        GET_GIFT_FOR_THE_TIME_IS_MONEY.click();
        return this;
    }
}
