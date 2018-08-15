package RulVulaknTests.achievements.rewards;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.Elements.Element;
import com.pages.AchievementsPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class FortuneLotteryAchievementsTest extends BaseTestPage {
    private User user;

    @BeforeClass(alwaysRun = true)
    public void createLottery() {
        sshManager.createActiveLottery();
    }

    @AfterClass(alwaysRun = true)
    public void removeLottery() {
        sshManager.removeAutotestLottery();
    }

    @DataProvider
    private Object[][] userProvider() {
        Object[][] object = new Object[1][1];
        object[0][0] = user;
        return object;
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"lotteriesAchievements"})
    @Description("first Reward For Received Lottery Tickets - 'Докатиться до призов' - for 1 ticket")
    public void firstRewardForReceivedLotteryTickets(User user) throws ParseException {
        this.user = user;
        home.registerUser(user);
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 1, 1);

        AchievementsPage achievementsPage = headerAuthorizedUser
                .waitForNotificationWithSpecialTitleClosingUnnecessary("Докатиться до призов")
                .clickLinkInAchievementNotification();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(0)));
        for (int i = 1; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(0).getText(), "Докатиться до призов");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(0).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "firstRewardForReceivedLotteryTickets")
    @Description("second Reward For Received Lottery Tickets - 'Семь цветов везения' - for 25 tickets")
    public void secondRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 24, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();
//when we wait for notification the test takes 8-9 minutes
        assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(0)));
        assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(1)));
        for (int i = 2; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(1).getText(), "Семь цветов везения");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(1).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "secondRewardForReceivedLotteryTickets")
    @Description("third Reward For Received Lottery Tickets - 'Не простые, а золотые!' - for 50 tickets")
    public void thirdRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 25, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 3; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 3; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(2).getText(), "Не простые, а золотые!");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(2).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "thirdRewardForReceivedLotteryTickets")
    @Description("fourth Reward For Received Lottery Tickets - 'Везёт, как на Купала' - for 100 tickets")
    public void fourthRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 50, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 4; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 4; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(3).getText(), "Везёт, как на Купала");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(3).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "fourthRewardForReceivedLotteryTickets")
    @Description("fifth Reward For Received Lottery Tickets - 'Поймать удачу за хвост' - for 250 tickets")
    public void fifthRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 150, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 5; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 5; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(4).getText(), "Поймать удачу за хвост");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(4).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "fifthRewardForReceivedLotteryTickets")
    @Description("sixth Reward For Received Lottery Tickets - 'Фарт из-под копыт' - for 500 tickets")
    public void sixthRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 6; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 6; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(5).getText(), "Фарт из-под копыт");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(5).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "sixthRewardForReceivedLotteryTickets")
    @Description("seventh Reward For Received Lottery Tickets - 'Ядра – чистый изумруд' - for 750 tickets")
    public void seventhRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 7; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 7; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(6).getText(), "Ядра – чистый изумруд");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(6).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "seventhRewardForReceivedLotteryTickets")
    @Description("eighth Reward For Received Lottery Tickets - 'Меткий выстрел' - for 1000 tickets")
    public void eighthRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 8; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 8; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(7).getText(), "Меткий выстрел");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(7).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "eighthRewardForReceivedLotteryTickets")
    @Description("ninth Reward For Received Lottery Tickets - 'Скатертью билеты' - for 1250 tickets")
    public void ninthRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 9; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 9; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(8).getText(), "Скатертью билеты");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(8).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "ninthRewardForReceivedLotteryTickets")
    @Description("tenth Reward For Received Lottery Tickets - 'На крыльях победы' - for 1500 tickets")
    public void tenthRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 10; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 10; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(9).getText(), "На крыльях победы");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(9).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "tenthRewardForReceivedLotteryTickets")
    @Description("eleventh Reward For Received Lottery Tickets - 'По Вашему хотению' - for 1750 tickets")
    public void eleventhRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (int i = 0; i < 11; i++) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(i)));
        }
        for (int i = 11; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(10).getText(), "По Вашему хотению");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(10).isPresent());
    }

    @Test(dataProvider = "userProvider", groups = {"lotteriesAchievements"}
            , dependsOnMethods = "eleventhRewardForReceivedLotteryTickets")
    @Description("twelfth Reward For Received Lottery Tickets - 'Рыба моей мечты' - for 2000 tickets")
    public void twelfthRewardForReceivedLotteryTickets(User user) throws ParseException {
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 250, 1);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        for (Element lotteryAchievement : lotteryAchievements) {
            assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievement));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(11).getText(), "Рыба моей мечты");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(11).isPresent());
    }

}
