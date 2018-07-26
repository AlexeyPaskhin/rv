package RulVulaknTests.achievements.rewards;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.Elements.Element;
import com.pages.AchievementsPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class MoneyLovesAccountTest extends BaseTestPage {
    User user;

    @DataProvider
    private Object[][] userProvider() {
        Object[][] object = new Object[1][1];
        object[0][0] = user;
        return object;
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"depAchievements"})
    @Description("first Reward For Deposits - 'Неразменный рубль' - for 1 dep")
    public void firstRewardForDep(User user) throws ParseException {
        this.user = user;
        home.registerUser(user);
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 1);

        AchievementsPage achievementsPage = headerAuthorizedUser
                .waitForDepsAchievementNotificationClosingUnnecessary()
                .clickLinkInAchievementNotification();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(0)));
        for (int i = 1; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(0).getText(), "Неразменный рубль");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(0).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "firstRewardForDep")
    @Description("second Reward For Deposits - 'Ко-ко-кая копилка!' - for 5 deps")
    public void secondRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 4);
        home.logInUser(user);
        AchievementsPage achievementsPage = headerAuthorizedUser
                .waitForDepsAchievementNotificationClosingUnnecessary()
                .clickLinkInAchievementNotification();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(0)));
        assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(1)));
        for (int i = 2; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(1).getText(), "Ко-ко-кая копилка!");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(1).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "secondRewardForDep")
    @Description("third Reward For Deposits - 'Своя ноша не тянет' - for 10 deps")
    public void thirdRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 5);
        home.logInUser(user);
        AchievementsPage achievementsPage = headerAuthorizedUser
                .waitForDepsAchievementNotificationClosingUnnecessary()
                .clickLinkInAchievementNotification();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 3; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 3; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(2).getText(), "Своя ноша не тянет");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(2).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "thirdRewardForDep")
    @Description("fourth Reward For Deposits - 'Черпать, так черпать!' - for 25 deps")
    public void fourthRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 15);
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 4; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 4; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(3).getText(), "Черпать, так черпать!");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(3).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "fourthRewardForDep")
    @Description("fifth Reward For Deposits - 'Горшочек, вари!' - for 50 deps")
    public void fifthRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 25);
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 5; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 5; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(4).getText(), "Горшочек, вари!");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(4).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "fifthRewardForDep")
    @Description("sixth Reward For Deposits - 'Заначка' - for 100 deps")
    public void sixthRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 50);
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 6; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 6; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(5).getText(), "Заначка");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(5).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "sixthRewardForDep")
    @Description("seventh Reward For Deposits - 'Вклад на два ведра' - for 250 deps")
    public void seventhRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 150);
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 7; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 7; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(6).getText(), "Вклад на два ведра");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(6).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "seventhRewardForDep")
    @Description("eighth Reward For Deposits - 'Полным-полна коробочка' - for 500 deps")
    public void eighthRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250);
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 8; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 8; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(7).getText(), "Полным-полна коробочка");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(7).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "eighthRewardForDep")
    @Description("ninth Reward For Deposits - 'Грузите депозиты бочками' - for 750 deps")
    public void ninthRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250);
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 9; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 9; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(8).getText(), "Грузите депозиты бочками");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(8).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "ninthRewardForDep")
    @Description("tenth Reward For Deposits - 'Хозяин сокровищ' - for 1000 deps")
    public void tenthRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250);
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 10; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 10; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(9).getText(), "Хозяин сокровищ");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(9).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"depAchievements"}
            , dependsOnMethods = "tenthRewardForDep")
    @Description("eleventh Reward For Deposits - 'Главный казначей' - for 1250 deps")
    public void eleventhRewardForDep(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250);
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> depsAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements();

        for (int i = 0; i < 11; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(depsAchievements.get(i)));
        }
        for (int i = 11; i < depsAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(depsAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(10).getText(), "Главный казначей");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_DEPS_ITEM().getAllElements().get(10).isPresent());
    }

}
