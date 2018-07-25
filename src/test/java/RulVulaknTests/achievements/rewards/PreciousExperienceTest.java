package RulVulaknTests.achievements.rewards;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import com.Elements.Element;
import com.pages.AchievementsPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


public class PreciousExperienceTest extends BaseTestPage {
    private LocalDate today = LocalDate.now();

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"ageAchievements"})
    @Description("There is no Reward For this Registration Time")
    public void boundaryRegistrationTimeWithoutExperienceAchievement(User user) {
        sshManager.removeAllAgeAchievements(user);
        sshManager.setRegistrationDate(today.minusMonths(6).plusDays(1), user);
        sshManager.makeRewards();
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> ageAchievements = achievementsPage.getACHIEVEMENT_IMAGE_FOR_AGE_ITEM().getAllElements();

        for (int i = 0; i < ageAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(ageAchievements.get(i)));
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"ageAchievements"}
            , dependsOnMethods = {"boundaryRegistrationTimeWithoutExperienceAchievement"})
    @Description("first Reward For Registration Time - 'Первобытный'")
    public void firstRewardForRegistrationTime(User user) {
        sshManager.removeAllAgeAchievements(user);
        sshManager.setRegistrationDate(today.minusMonths(6).minusDays(2), user);
        sshManager.makeRewards();
        AchievementsPage achievementsPage = home.logInUser(user)
                .waitForAchievementNotification()
                .clickLinkInAchievementNotification();
        List<Element> ageAchievements = achievementsPage.getACHIEVEMENT_IMAGE_FOR_AGE_ITEM().getAllElements();

        assertTrue(achievementsPage.achievementIsEnabled(ageAchievements.get(0)));
        for (int i = 1; i < ageAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(ageAchievements.get(i)));
        }
        assertEquals(achievementsPage.getACHIEVEMENT_NAME_FOR_AGE_ITEM().getAllElements().get(0).getText(), "Первобытный");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_AGE_ITEM().getAllElements().get(0).isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"ageAchievements"}
            , dependsOnMethods = {"firstRewardForRegistrationTime"})
    @Description("first Reward For Registration Time - 'Грамотный игрок'")
    public void secondRewardForRegistrationTime(User user) {
        sshManager.setRegistrationDate(today.minusMonths(12).minusDays(2), user);
        sshManager.makeRewards();
        AchievementsPage achievementsPage = home.logInUser(user)
                .waitForAchievementNotification()
                .clickLinkInAchievementNotification();
        List<Element> ageAchievements = achievementsPage.getACHIEVEMENT_IMAGE_FOR_AGE_ITEM().getAllElements();

        assertTrue(achievementsPage.achievementIsEnabled(ageAchievements.get(0)));
        assertTrue(achievementsPage.achievementIsEnabled(ageAchievements.get(1)));
        for (int i = 2; i < ageAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(ageAchievements.get(i)));
        }
        assertEquals(achievementsPage.getACHIEVEMENT_NAME_FOR_AGE_ITEM().getAllElements().get(1).getText(), "Грамотный игрок");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_AGE_ITEM().getAllElements().get(1).isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"ageAchievements"}
            , dependsOnMethods = {"secondRewardForRegistrationTime"}
    )
    @Description("first Reward For Registration Time - 'Царь-батюшка'")
    public void thirdRewardForRegistrationTime(User user) {
        sshManager.setRegistrationDate(today.minusMonths(24).minusDays(2), user);
        sshManager.makeRewards();
        AchievementsPage achievementsPage = home.logInUser(user)
                .waitForAchievementNotification()
                .clickLinkInAchievementNotification();
        List<Element> ageAchievements = achievementsPage.getACHIEVEMENT_IMAGE_FOR_AGE_ITEM().getAllElements();

        for (int i = 0; i < 3; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(ageAchievements.get(i)));
        }
        for (int i = 3; i < ageAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(ageAchievements.get(i)));
        }
        assertEquals(achievementsPage.getACHIEVEMENT_NAME_FOR_AGE_ITEM().getAllElements().get(2).getText(), "Царь-батюшка");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_AGE_ITEM().getAllElements().get(2).isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"ageAchievements"}
            , dependsOnMethods = {"thirdRewardForRegistrationTime"}
    )
    @Description("first Reward For Registration Time - 'Член Союза Старожилов'")
    public void fourthRewardForRegistrationTime(User user) {
        sshManager.setRegistrationDate(today.minusMonths(36).minusDays(2), user);
        sshManager.makeRewards();
        AchievementsPage achievementsPage = home.logInUser(user)
                .waitForAchievementNotification()
                .clickLinkInAchievementNotification();
        List<Element> ageAchievements = achievementsPage.getACHIEVEMENT_IMAGE_FOR_AGE_ITEM().getAllElements();

        for (int i = 0; i < 4; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(ageAchievements.get(i)));
        }
        for (int i = 4; i < ageAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(ageAchievements.get(i)));
        }
        assertEquals(achievementsPage.getACHIEVEMENT_NAME_FOR_AGE_ITEM().getAllElements().get(3).getText(), "Член Союза Старожилов");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_AGE_ITEM().getAllElements().get(3).isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"ageAchievements"}
            , dependsOnMethods = {"fourthRewardForRegistrationTime"}
    )
    @Description("first Reward For Registration Time - 'Патриот Вулкана'")
    public void fifthRewardForRegistrationTime(User user) {
        sshManager.setRegistrationDate(today.minusMonths(48).minusDays(2), user);
        sshManager.makeRewards();
        AchievementsPage achievementsPage = home.logInUser(user)
                .waitForAchievementNotification()
                .clickLinkInAchievementNotification();
        List<Element> ageAchievements = achievementsPage.getACHIEVEMENT_IMAGE_FOR_AGE_ITEM().getAllElements();

        for (int i = 0; i < 5; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(ageAchievements.get(i)));
        }
        for (int i = 5; i < ageAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(ageAchievements.get(i)));
        }
        assertEquals(achievementsPage.getACHIEVEMENT_NAME_FOR_AGE_ITEM().getAllElements().get(4).getText(), "Патриот Вулкана");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_AGE_ITEM().getAllElements().get(4).isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"ageAchievements"}
            , dependsOnMethods = {"fifthRewardForRegistrationTime"}
    )
    @Description("first Reward For Registration Time - 'Просто космос!'")
    public void sixthRewardForRegistrationTime(User user) {
        sshManager.setRegistrationDate(today.minusMonths(60).minusDays(2), user);
        sshManager.makeRewards();
        AchievementsPage achievementsPage = home.logInUser(user)
                .waitForAchievementNotification()
                .clickLinkInAchievementNotification();
        List<Element> ageAchievements = achievementsPage.getACHIEVEMENT_IMAGE_FOR_AGE_ITEM().getAllElements();

        for (int i = 0; i < 6; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(ageAchievements.get(i)));
        }
        assertEquals(achievementsPage.getACHIEVEMENT_NAME_FOR_AGE_ITEM().getAllElements().get(5).getText(), "Просто космос!");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_AGE_ITEM().getAllElements().get(5).isPresent());
    }

}
