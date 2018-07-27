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

    @BeforeClass
    public void createLottery() {
        sshManager.createActiveLottery();
        System.out.println();
    }

    @AfterClass
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
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 1);

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
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 24);
        home.logInUser(user);

        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> lotteryAchievements = achievementsPage.getIMAGE_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements();

        assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(0)));
        assertTrue(achievementsPage.achievementIsEnabled(lotteryAchievements.get(1)));
        for (int i = 2; i < lotteryAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(lotteryAchievements.get(i)));
        }
        assertEquals(achievementsPage.getNAME_OF_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(1).getText(), "Семь цветов везения");
        assertTrue(achievementsPage.getLABEL_NEW_ACHIEVEMENT_FOR_LOTTERIES_ITEM().getAllElements().get(1).isPresent());
    }

}
