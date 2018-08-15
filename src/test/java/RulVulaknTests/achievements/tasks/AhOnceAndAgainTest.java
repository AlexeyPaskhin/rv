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

public class AhOnceAndAgainTest extends BaseTestPage {
    private User user;

    @DataProvider
    private Object[][] userProvider() {
        Object[][] object = new Object[1][1];
        object[0][0] = user;
        return object;
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class,
            groups = {"rewardsForQuantityOfBets"})
    @Description("first Reward For Quantity Of Bets")
    public void firstRewardForQuantityOfBets(User user) throws IOException, ParseException {
        this.user = user;
        home.registerUser(user);

        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "19");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = headerAuthorizedUser.waitForNotificationWithSpecialTitleClosingUnnecessary("Полный атас")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20_ROUNDS()), "Полный атас");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "firstRewardForQuantityOfBets")
    @Description("second Reward For Quantity Of Bets")
    public void secondRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "249");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Нерукотворный памятник")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250_ROUNDS()), "Нерукотворный памятник");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "secondRewardForQuantityOfBets")
    @Description("third Reward For Quantity Of Bets")
    public void thirdRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "499");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Урал покорён")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_500_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_500_ROUNDS()), "Урал покорён");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_500_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "thirdRewardForQuantityOfBets")
    @Description("fourth Reward For Quantity Of Bets")
    public void fourthRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Не расстрелять, а наградить!")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_1000_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_1000_ROUNDS()), "Не расстрелять, а наградить!");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_1000_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "fourthRewardForQuantityOfBets")
    @Description("fifth Reward For Quantity Of Bets")
    public void fifthRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "2499");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Вождь одобряет")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_2500_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_2500_ROUNDS()), "Вождь одобряет");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_2500_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "fifthRewardForQuantityOfBets")
    @Description("sixth Reward For Quantity Of Bets")
    public void sixthRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "4999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Шайбу! Шайбу!")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5000_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5000_ROUNDS()), "Шайбу! Шайбу!");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_5000_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "sixthRewardForQuantityOfBets")
    @Description("seventh Reward For Quantity Of Bets")
    public void seventhRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "9999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Супер-игра!")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_10000_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_10000_ROUNDS()), "Супер-игра!");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_10000_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "seventhRewardForQuantityOfBets")
    @Description("eighth Reward For Quantity Of Bets")
    public void eighthRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "24999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Князь всея Вулкана")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_25000_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_25000_ROUNDS()), "Князь всея Вулкана");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_25000_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "eighthRewardForQuantityOfBets")
    @Description("ninth Reward For Quantity Of Bets")
    public void ninthRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "49999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Любимец клуба")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_50000_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_50000_ROUNDS()), "Любимец клуба");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_50000_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "ninthRewardForQuantityOfBets")
    @Description("tenth Reward For Quantity Of Bets")
    public void tenthRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "99999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Вверх, к звёздам!")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_100000_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_100000_ROUNDS()), "Вверх, к звёздам!");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_100000_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "tenthRewardForQuantityOfBets")
    @Description("eleventh Reward For Quantity Of Bets")
    public void eleventhRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "249999");

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Фаворит императрицы")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250000_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250000_ROUNDS()), "Фаворит императрицы");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250000_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
            ,dependsOnMethods = "eleventhRewardForQuantityOfBets")
    @Description("get The Gift For The Ah Once And Again Tasks")
    public void getTheGiftForTheAhOnceAndAgainTasks(User user) {
        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .clickAchievements()
                .clickTasksTab()
                .clickGetGiftForTheAhOnceAndAgainTasks();
        assertTrue(achievementsTasksPage.getPROMO_CODE_FOR_THE_AH_ONCE_AND_AGAIN().isPresent());
    }
}
