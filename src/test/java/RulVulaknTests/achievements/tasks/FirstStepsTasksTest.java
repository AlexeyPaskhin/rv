package RulVulaknTests.achievements.tasks;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.pages.AchievementsTasksPage;
import com.utils.RandomGenerate;
import com.utils.User;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FirstStepsTasksTest extends BaseTestPage {
    private User user;

    @DataProvider
    private Object[][] userProvider() {
        Object[][] object = new Object[1][1];
        object[0][0] = user;
        return object;
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"first-steps-tasks"})
    @Description("reward For Registration")
    public void rewardForRegistration(User user) {
        this.user = user;
        AchievementsTasksPage achievementsTasksPage = home.registerUser(user)
                .getAuthorizedHeader()
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Хлеб-соль")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_REGISTRATION()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_REGISTRATION()), "Хлеб-соль");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_REGISTRATION()));
    }

    @Test(dataProvider = "userProvider", groups = {"first-steps-tasks"}
            , dependsOnMethods = "rewardForRegistration")
    @Description("reward For Confirmation Of Email")
    public void rewardForConfirmationOfEmail(User user) {
        home.logInUser(user)
                .clickUserName()
                .clickConfirmEmail()
                .goTo(sshManager.getLinkForConfirmationEmail(user));
        AchievementsTasksPage achievementsTasksPage = headerAuthorizedUser.waitForNotificationWithSpecialTitleClosingUnnecessary("Пляшите, Вам письмо")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_EMAIL_CONFIRMATION()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_EMAIL_CONFIRMATION()), "Пляшите, Вам письмо");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_EMAIL_CONFIRMATION()));
    }

    @Test(dataProvider = "userProvider", groups = {"first-steps-tasks"}
            , dependsOnMethods = "rewardForRegistration")
    @Description("reward For Confirmation Of Phone")
    public void rewardForConfirmationOfPhone(User user) {
        String phone = RandomGenerate.randomStringOfDigits(12);
        home.logInUser(user)
                .clickUserName()
                .setToPhoneField(phone)
                .clickReceiveSmsCode()
                .setToSmsCodeField(sshManager.getSmsCode(user))
                .clickConfirmSmsCode();

        AchievementsTasksPage achievementsTasksPage = headerAuthorizedUser.waitForNotificationWithSpecialTitleClosingUnnecessary("На проводе")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PHONE_CONFIRMATION()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PHONE_CONFIRMATION()), "На проводе");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PHONE_CONFIRMATION()));
    }

    @Test(dataProvider = "userProvider", groups = {"first-steps-tasks"}
            , dependsOnMethods = {"rewardForRegistration", "rewardForConfirmationOfEmail", "rewardForConfirmationOfPhone"})
    @Description("reward For Filling All Personal Info")
    public void rewardForFillingAllPersonalInfo(User user) {
        String name = RandomGenerate.randomString(5, 30);
        home.logInUser(user)
                .clickUserName()
                .setToNameField("")
                .successfulSaveChanges()
                .closeConfirmPopUp()
                .setToNameField(name)
                .successfulSaveChanges();

        AchievementsTasksPage achievementsTasksPage = headerAuthorizedUser.waitForNotificationWithSpecialTitleClosingUnnecessary("По всей форме")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_FILLING_PERSONAL_INFO()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_FILLING_PERSONAL_INFO()), "По всей форме");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_FILLING_PERSONAL_INFO()));
    }

    @Test(dataProvider = "userProvider", groups = {"first-steps-tasks"}
            , dependsOnMethods = {"rewardForRegistration", "rewardForConfirmationOfEmail", "rewardForConfirmationOfPhone", "rewardForFillingAllPersonalInfo"})
    @Description("reward For Refilling Account And Receiving Bonus")
    public void rewardForRefillingAccountAndReceivingBonus(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 1, 50000);
        home.logInUser(user)
                .clickUserName()
                .clickBonuses()
                .activateFirstBonus();

        AchievementsTasksPage achievementsTasksPage = headerAuthorizedUser.waitForNotificationWithSpecialTitleClosingUnnecessary("С почином!")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_REFILLING_ACCOUNT()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_REFILLING_ACCOUNT()), "С почином!");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_REFILLING_ACCOUNT()));
    }

    @Test(dataProvider = "userProvider", groups = {"first-steps-tasks"}
            , dependsOnMethods = {"rewardForRegistration", "rewardForConfirmationOfEmail", "rewardForConfirmationOfPhone"
            , "rewardForFillingAllPersonalInfo", "rewardForRefillingAccountAndReceivingBonus"})
    @Description("get The Gift For First Steps")
    public void getTheGiftForFirstSteps(User user) throws ParseException {
        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .clickAchievements()
                .clickTasksTab()
                .clickGetGiftForFirstSteps();
        assertTrue(achievementsTasksPage.getPROMO_CODE_FOR_FIRST_STEPS().isPresent());
    }
}
