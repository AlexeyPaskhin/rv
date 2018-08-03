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
import java.util.HashSet;
import java.util.Set;

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
    @Description("first Reward For Bets In Consecutive Days")
    public void firstRewardForQuantityOfBets(User user) throws IOException, ParseException {
        this.user = user;
        home.registerUser(user);

        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "19");

        HashMap<String, String> idsOfCreatedEnries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEnries.get("betId"), idsOfCreatedEnries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = headerAuthorizedUser.waitForNotificationWithSpecialTitleClosingUnnecessary("Полный атас")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20_ROUNDS()), "Полный атас");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_20_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "firstRewardForQuantityOfBets")
    @Description("second Reward For Bets In Consecutive Days")
    public void secondRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "249");

        HashMap<String, String> idsOfCreatedEnries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEnries.get("betId"), idsOfCreatedEnries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Нерукотворный памятник")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250_ROUNDS()), "Нерукотворный памятник");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_250_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "secondRewardForQuantityOfBets")
    @Description("third Reward For Bets In Consecutive Days")
    public void thirdRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "499");

        HashMap<String, String> idsOfCreatedEnries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEnries.get("betId"), idsOfCreatedEnries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Урал покорён")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_500_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_500_ROUNDS()), "Урал покорён");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_500_ROUNDS()));
    }

    @Test(dataProvider = "userProvider", groups = {"rewardsForQuantityOfBets"}
    ,dependsOnMethods = "thirdRewardForQuantityOfBets")
    @Description("fourth Reward For Bets In Consecutive Days")
    public void fourthRewardForQuantityOfBets(User user) throws IOException, ParseException {
        redisManager.setQuantityOfPlayedRoundsForPlayer(sshManager.getUserID(user.getLogin()), "999");

        HashMap<String, String> idsOfCreatedEnries = sshManager.createRoundDataForUserInDB(user, "88_wild_dragon", "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEnries.get("betId"), idsOfCreatedEnries.get("winId"));

        AchievementsTasksPage achievementsTasksPage = home.logInUser(user)
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Не расстрелять, а наградить!")
                .clickLinkInAchievementForTaskNotification();
        assertTrue(achievementsTasksPage.achievementIsReceived(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_1000_ROUNDS()));
        assertEquals(achievementsTasksPage.getNameOfAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_1000_ROUNDS()), "Не расстрелять, а наградить!");
        assertTrue(achievementsTasksPage.labelNewIsPresentOnAchievement(achievementsTasksPage.getIMAGE_ACHIEVEMENT_FOR_PLAYING_1000_ROUNDS()));
    }
}
