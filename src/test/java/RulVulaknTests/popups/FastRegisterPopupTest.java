package RulVulaknTests.popups;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationTest;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.RulesPage;
import com.popups.LogInPopUp;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class FastRegisterPopupTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(AuthorizationTest.class);
    RulesPage rules;
    LogInPopUp authPopup;

    @Test(groups = {"regression"})
    @Description("Test for checking rules and conditionals link in Fast Register pop-up")
    public void checkIsRulesAndConditionsLInkWorks() {
        new HeaderNotAutorizedUser()
                .clickRegister()
                .checkRulesAndConditionsLink()
                .switchToNewTab();
        try {
            rules = new RulesPage();
            assertTrue(rules.isRulesPageLoaded(), "The rules page isn't opened");
        } catch (Exception e) {
            logger.error("ERROR WITH FAST REGISTER POP-UP");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(groups = {"regression"})
    @Description("Test for checking is button Close works")
    public void checkIsCloseButtonWorks() {
        new HeaderNotAutorizedUser()
                .clickRegister()
                .closeFastRegisterPopUp();
        try {
            assertEquals(home.getTitle(), "Казино Вулкан: официальный сайт Русского Вулкана – казино онлайн");
        } catch (Exception e) {
            logger.error("ERROR WITH FAST REGISTER POP-UP");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(groups = {"regression"})
    @Description("Test for checking is 'Vhod v kazino' link is works")
    public void checkIsAuthLinkWorks() {
        new HeaderNotAutorizedUser()
                .clickRegister()
                .clickAuthLink();
        try {
            authPopup = new LogInPopUp();
            Assert.assertTrue(authPopup.isLoginPopUpOpened(), "AUTH POP-UP DOES NOT OPENED");
        } catch (Exception e) {
            logger.error("ERROR WITH FAST REGISTER POP-UP");
            logger.error(e);
            Assert.fail();
        }
    }
}
