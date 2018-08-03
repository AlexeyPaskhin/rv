package RulVulaknTests.achievements.tasks;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.pages.AchievementsTasksPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.joda.time.LocalDate;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class NotADayWithoutASlotTest extends BaseTestPage {
    private LocalDate now = LocalDate.now();
    private User user;

    @DataProvider
    private Object[][] userProvider() {
        Object[][] object = new Object[1][1];
        object[0][0] = user;
        return object;
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class,
            groups = {"betsInConsecutiveDays"})
    @Description("first Reward For Bets In Consecutive Days")
    public void firstRewardForBetsInConsecutiveDays(User user) throws IOException, ParseException {
        this.user = user;
        home.registerUser(user);

        Set<String> datesOfGaming = new HashSet<>();
        datesOfGaming.add(now.minusDays(1).toString());
        redisManager.addGameEventForDates(sshManager.getUserID(user.getLogin()), datesOfGaming);

        HashMap<String, String> idsOfCreatedEnries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "3000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEnries.get("betId"), idsOfCreatedEnries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = headerAuthorizedUser.waitForNotificationWithSpecialTitleClosingUnnecessary("Активная игра")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_2_DAYS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_2_DAYS()), "Активная игра");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_2_DAYS()));
    }

    @Test(dataProvider = "userProvider", groups = {"betsInConsecutiveDays"}
    ,dependsOnMethods = "firstRewardForBetsInConsecutiveDays")
    @Description("second Reward For Bets In Consecutive Days")
    public void secondRewardForBetsInConsecutiveDays(User user) throws IOException, ParseException {
        Set<String> datesOfGaming = new HashSet<>();
        datesOfGaming.add(now.minusDays(2).toString());
        redisManager.addGameEventForDates(sshManager.getUserID(user.getLogin()), datesOfGaming);

        HashMap<String, String> idsOfCreatedEnries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "3000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEnries.get("betId"), idsOfCreatedEnries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Да Вы композитор!")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_3_DAYS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_3_DAYS()), "Да Вы композитор!");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_3_DAYS()));
    }

    @Test(dataProvider = "userProvider", groups = {"betsInConsecutiveDays"}
    ,dependsOnMethods = "secondRewardForBetsInConsecutiveDays")
    @Description("third Reward For Bets In Consecutive Days")
    public void thirdRewardForBetsInConsecutiveDays(User user) throws IOException, ParseException {
        Set<String> datesOfGaming = new HashSet<>();
        datesOfGaming.add(now.minusDays(3).toString());
        redisManager.addGameEventForDates(sshManager.getUserID(user.getLogin()), datesOfGaming);

        HashMap<String, String> idsOfCreatedEnries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "3000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEnries.get("betId"), idsOfCreatedEnries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Любитель риска")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_4_DAYS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_4_DAYS()), "Любитель риска");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_4_DAYS()));
    }

    @Test(dataProvider = "userProvider", groups = {"betsInConsecutiveDays"}
    ,dependsOnMethods = "thirdRewardForBetsInConsecutiveDays")
    @Description("fourth Reward For Bets In Consecutive Days")
    public void fourthRewardForBetsInConsecutiveDays(User user) throws IOException, ParseException {
        Set<String> datesOfGaming = new HashSet<>();
        datesOfGaming.add(now.minusDays(4).toString());
        redisManager.addGameEventForDates(sshManager.getUserID(user.getLogin()), datesOfGaming);

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "3000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Затяжная партия")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5_DAYS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5_DAYS()), "Затяжная партия");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5_DAYS()));
    }

    @Test(dataProvider = "userProvider", groups = {"betsInConsecutiveDays"}
    ,dependsOnMethods = "fourthRewardForBetsInConsecutiveDays")
    @Description("fifth Reward For Bets In Consecutive Days")
    public void fifthRewardForBetsInConsecutiveDays(User user) throws IOException, ParseException {
        Set<String> datesOfGaming = new HashSet<>();
        datesOfGaming.add(now.minusDays(5).toString());
        redisManager.addGameEventForDates(sshManager.getUserID(user.getLogin()), datesOfGaming);

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "3000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Опытный слотонавт")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_6_DAYS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_6_DAYS()), "Опытный слотонавт");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_6_DAYS()));
    }

    @Test(dataProvider = "userProvider", groups = {"betsInConsecutiveDays"}
    ,dependsOnMethods = "fifthRewardForBetsInConsecutiveDays")
    @Description("get The Gift For Not A Day Without A Slot")
    public void getTheGiftForNotADayWithoutASlot(User user) {
        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .clickAchievements()
                .clickTasksTab()
                .clickGetGiftForNotADayWithoutASlot();
        assertTrue(achievementsTasksPage.getPROMO_CODE_FOR_NOT_A_DAY_WITHOUT_A_SLOT().isPresent());
    }

}
