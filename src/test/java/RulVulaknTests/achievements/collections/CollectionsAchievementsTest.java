package RulVulaknTests.achievements.collections;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.Elements.Element;
import com.pages.AchievementsPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CollectionsAchievementsTest extends BaseTestPage {

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"depAchievements"})
    @Description("first Reward For Deposits - 'Неразменный рубль' - for 1 dep")
    public void firstRewardForDep(User user) throws ParseException {
//        this.user = user;
        home.registerUser(user);
        restManager.makeDepositNTimes(sshManager.getUserID(user.getLogin()), 1, 1);

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
