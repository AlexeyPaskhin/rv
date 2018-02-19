package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

@Listeners({RussianVulcanListener.class})
public class HeaderTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);

    /**
     * Un-authorized user
     * + logo icon is visible
     * + after click on Logo page - opening Home Page
     */
    @Test
    @Description("After click on logo icon on HeaderTest for un-authorized user opened Home Page and Logo icon is visible")
    public void clickLogoToOpenHomePage() {
        new HeaderNotAutorizedUser()
                .clickLogoIcon()
                .homePageLoaded();
        try {
            Assert.assertEquals(home.getTitle(), "Казино Вулкан: официальный сайт Русского Вулкана – казино онлайн");
            Assert.assertTrue(headerNotAutorizedUser.isLogoIconVisible(), "Logo icon is NOT VISIBLE for un-authorized user");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }



}
