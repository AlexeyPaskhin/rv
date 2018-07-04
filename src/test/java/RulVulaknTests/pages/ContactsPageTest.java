package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import com.listeners.RussianVulcanListener;
import com.pages.landing.social.SocialFrame;
import com.popups.RedHelperFrame;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class ContactsPageTest extends BaseTestPage {

    @Test(groups = {"regression"})
    @Description("open RedHelper via contacts panel")
    public void openRedHelper() {
        RedHelperFrame redHelperFrame = home.getHeader()
                .clickContactsLink()
                .clickOnlineConsult()
                .switchToRedHElperFrame();
        assertTrue(redHelperFrame.isRedHelperFrameOpened());
    }

    @Test(dataProvider = "authorizationUserForFB", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("go To Our Fb Group via contacts panel")
    public void goToOurFbGroup(User user) {
        SocialFrame socialFrame = home.getHeader()
                .clickContactsLink()
                .clickFbGroup()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickLogIn();
        assertEquals(socialFrame.getURL(), socialFrame.fbGroupURL);
    }

    @Test(groups = {"regression"})
    @Description("go To Our Twitter Group via contacts panel")
    public void goToOurTwitterGroup(User user) {
        SocialFrame socialFrame = home.getHeader()
                .clickContactsLink()
                .clickTwitterGroup();
        assertEquals(socialFrame.getURL(), socialFrame.fbGroupURL);
    }
}
