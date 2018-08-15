package RulVulaknTests.achievements.tasks;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.pages.AchievementsTasksPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TimeIsMoneyTest extends BaseTestPage {
    private User user;

    @DataProvider
    private Object[][] userProvider() {
        Object[][] object = new Object[1][1];
        object[0][0] = user;
        return object;
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class,
            groups = {"rewardsForQuantityOfBetsPerTime"})
    @Description("first Reward For Quantity Of Bets Per 24 Hours")
    public void firstRewardForQuantityOfBetsPer24Hours(User user) throws IOException, ParseException {
        this.user = user;
        home.registerUser(user);

        redisManager.setQuantityOfPlayedRoundsForAnHourInLast24HoursForPlayer(sshManager.getUserID(user.getLogin()), "4999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = headerAuthorizedUser.waitForNotificationWithSpecialTitleClosingUnnecessary("От рассвета до заката")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5000_ROUNDS_PER_24_HOURS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5000_ROUNDS_PER_24_HOURS()), "От рассвета до заката");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5000_ROUNDS_PER_24_HOURS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBetsPerTime"}
            ,dependsOnMethods = "firstRewardForQuantityOfBetsPer24Hours")
    @Description("second Reward For Quantity Of Bets Per 24 Hours")
    public void secondRewardForQuantityOfBetsPer24Hours(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForAnHourInLast24HoursForPlayer(sshManager.getUserID(user.getLogin()), "9999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Сколько Вам отсыпать?")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_10000_ROUNDS_PER_24_HOURS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_10000_ROUNDS_PER_24_HOURS()), "Сколько Вам отсыпать?");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_10000_ROUNDS_PER_24_HOURS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBetsPerTime"}
            ,dependsOnMethods = "secondRewardForQuantityOfBetsPer24Hours")
    @Description("third Reward For Quantity Of Bets Per 24 Hours")
    public void thirdRewardForQuantityOfBetsPer24Hours(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForAnHourInLast48HoursForPlayer(sshManager.getUserID(user.getLogin()), "14999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Победа в кармане")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_15000_ROUNDS_PER_48_HOURS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_15000_ROUNDS_PER_48_HOURS()), "Победа в кармане");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_15000_ROUNDS_PER_48_HOURS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBetsPerTime"}
            ,dependsOnMethods = "thirdRewardForQuantityOfBetsPer24Hours")
    @Description("fourth Reward For Quantity Of Bets Per 24 Hours")
    public void fourthRewardForQuantityOfBetsPer24Hours(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForAnHourInLast48HoursForPlayer(sshManager.getUserID(user.getLogin()), "19999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Накукуй на джекпот")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20000_ROUNDS_PER_48_HOURS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20000_ROUNDS_PER_48_HOURS()), "Накукуй на джекпот");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20000_ROUNDS_PER_48_HOURS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBetsPerTime"}
            ,dependsOnMethods = "fourthRewardForQuantityOfBetsPer24Hours")
    @Description("fifth Reward For Quantity Of Bets Per 24 Hours")
    public void fifthRewardForQuantityOfBetsPer24Hours(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForAnHourInLast48HoursForPlayer(sshManager.getUserID(user.getLogin()), "24999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Часы стоят – игра идёт!")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_25000_ROUNDS_PER_48_HOURS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_25000_ROUNDS_PER_48_HOURS()), "Часы стоят – игра идёт!");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_25000_ROUNDS_PER_48_HOURS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBetsPerTime"}
            ,dependsOnMethods = "fifthRewardForQuantityOfBetsPer24Hours")
    @Description("get The Gift For The Time Is Money Tasks")
    public void getTheGiftForTheTimeIsMoneyTasks(User user) {
        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .clickAchievements()
                .clickTasksTab()
                .clickGetGiftForTheTimeIsMoneyTasks();
        assertTrue(achievementsTasksPage.getPROMO_CODE_FOR_THE_TIME_IS_MONEY().isPresent());
    }

}
