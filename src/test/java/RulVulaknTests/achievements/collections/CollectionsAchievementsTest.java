package RulVulaknTests.achievements.collections;

import RulVulaknTests.BaseTestPage;
import com.pages.AchievementsCollectionsPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.testng.Assert.*;


public class CollectionsAchievementsTest extends BaseTestPage {

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For Wining 3 Times In A Row")
    public void rewardForWining3TimesInARow(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 3,  //mind quantity of rounds here
                idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(7));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(7));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For Wining 5 Times In A Row")
    public void rewardForWining5TimesInARow(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 5,  //mind quantity of rounds here
                idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(8));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(8));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For Wining 7 Times In A Row")
    public void rewardForWining7TimesInARow(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 7,  //mind quantity of rounds here
                idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(9));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(9));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For 200 Wins in particular game")
    public void rewardFor200Wins(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        redisManager.setQuantityOfTotalWinsForPlayerForExactGame(sshManager.getUserID(user.getLogin()), "199", titleForRedis);

        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(1));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(1));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For 500 Wins in particular game")
    public void rewardFor500Wins(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        redisManager.setQuantityOfTotalWinsForPlayerForExactGame(sshManager.getUserID(user.getLogin()), "499", titleForRedis);

        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(2));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(2));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For 1000 Wins in particular game")
    public void rewardFor1000Wins(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        redisManager.setQuantityOfTotalWinsForPlayerForExactGame(sshManager.getUserID(user.getLogin()), "999", titleForRedis);

        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(3));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(3));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For Win 30 Times More Than Bet")
    public void rewardForWin30TimesMoreThanBet(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "3000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(4));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(4));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For Win 50 Times More Than Bet")
    public void rewardForWin50TimesMoreThanBet(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "5000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(5));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(5));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For Win 100 Times More Than Bet")
    public void rewardForWin100TimesMoreThanBet(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws ParseException, IOException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "10000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(6));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(6));
    }

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("reward For Collect All Achievements In A Group")
    public void rewardForCollectAllAchievementsInAGroup(String titleForFrontEndSelector, String titleForRedis, String gameSidInDb, String gameProvider, User user) throws IOException, ParseException {
        if (sshManager.getUserID(user.getLogin()).equals("")) {
            home.registerUser(user);
        } else {
            home.logInUser(user);
        }
        redisManager.setQuantityOfTotalWinsForPlayerForExactGame(sshManager.getUserID(user.getLogin()), "999", titleForRedis);

        HashMap<String, String> idsOfCreatedInDbEntries = sshManager.createRoundDataForUserInDB(user, gameSidInDb, "100", "10000");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 7,  //mind quantity of rounds here
                idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);
//for triggering last reward
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1,  //mind quantity of rounds here
                idsOfCreatedInDbEntries.get("betId"), idsOfCreatedInDbEntries.get("winId"), gameProvider);

        AchievementsCollectionsPage collectionsPage = headerAuthorizedUser
                .clickAchievements()
                .clickCollectionsTab()
                .clickNeededGame(titleForFrontEndSelector);
        assertTrue(collectionsPage.achievementIsActiveByNumber(10));
        assertTrue(collectionsPage.labelNewOnAchievementByNumberIsPresent(10));
        collectionsPage.clickGetPromoCode();
        assertTrue(collectionsPage.getPROMO_CODE().isPresent());
    }

}
