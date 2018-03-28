package RulVulaknTests.popups;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import RulVulaknTests.authorization.AuthorizationTest;
import com.listeners.RussianVulcanListener;
import com.pages.HomePage;
import com.popups.RedHelperFrame;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Testing Red Helper (chatting service)
 */

@Listeners({RussianVulcanListener.class})
public class RedHelperTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(AuthorizationTest.class);

    @Test(groups = {"redhelper"})
    @Description("Test for checking is RedHelper pop-up is opened on Home Page")
    public void checkRedHelperPopUpIsOpened() {
        new HomePage()
                .openRedHelperFrame()
                .switchToRedHElperFrame();
        try {
            RedHelperFrame redHelperFrame = new RedHelperFrame();
            Assert.assertTrue(redHelperFrame.isRedHelperFrameOpened(), "RED HELPER FRAME NOT VISIBLE");
        } catch (Exception e) {
            logger.error("ERROR WITH RED HELPER");
            logger.error(e);
            Assert.fail();
        }
    }
}
