package RulVulaknTests.achievements.rewards;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import com.Elements.Element;
import com.pages.AchievementsPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class MoneyLovesAccountTest extends BaseTestPage {

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"ageAchievements"})
    @Description("There is no Reward For this Registration Time")
    public void boundaryRegistrationTimeWithoutExperienceAchievement(User user) {
        sshManager.removeAllDepsAchievements(user);
//        sshManager.setRegistrationDate(today.minusMonths(6).plusDays(1), user);
        sshManager.makeRewards();
        AchievementsPage achievementsPage = home.logInUser(user)
                .clickAchievements();
        List<Element> ageAchievements = achievementsPage.getACHIEVEMENT_IMAGE_FOR_AGE_ITEM().getAllElements();

        for (int i = 0; i < ageAchievements.size(); i++) {
            assertTrue(achievementsPage.achievementIsDisabled(ageAchievements.get(i)));
        }
    }

}
