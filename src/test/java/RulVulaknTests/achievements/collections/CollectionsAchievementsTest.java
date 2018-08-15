package RulVulaknTests.achievements.collections;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.Elements.Element;
import com.pages.AchievementsPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CollectionsAchievementsTest extends BaseTestPage {

    @Test(dataProvider = "userAndGamesForCollectionsProvider", dataProviderClass = UserAndGamesForCollections.class, groups = {"collections"})
    @Description("first Reward For Deposits - 'Неразменный рубль' - for 1 dep")
    public void rewardFor200Wins(String titleForFrontEndSelector, String titleForRedis, User user) throws ParseException, IOException {
        home.registerUser(user);
        redisManager.setQuantityOfTotalWinsForPlayerForExactGame(sshManager.getUserID(user.getLogin()), "199", titleForRedis);

        HashMap<String, String> idsOfCreatedEntries = sshManager.createRoundDataForUserInDB(user, titleForRedis, "100", "100");
        restManager.makeCustomGameRoundsForUser(sshManager.getUserID(user.getLogin()), 1, idsOfCreatedEntries.get("betId"), idsOfCreatedEntries.get("winId"));

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
}
