package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.landing.social.FBregisterPage;
import com.popups.LogInPopUp;
import com.popups.RedHelperFrame;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class ContactsPageTest extends BaseTestPage {

    @Test(groups = {"regression", "negative"})
    @Description("open RedHelper via contacts panel")
    public void openRedHelper() {
        RedHelperFrame redHelperFrame = home.getHeader()
                .clickContactsLink()
                .clickOnlineConsult()
                .switchToRedHElperFrame();
        assertTrue(redHelperFrame.isRedHelperFrameOpened());
    }

    @Test(groups = {"regression", "negative"})
    @Description("go To Our Fb Group via contacts panel")
    public void goToOurFbGroup() {
        FBregisterPage fBregisterPage = home.getHeader()
                .clickContactsLink()
                .clickFbGroup();
        System.out.println();
    }
}
