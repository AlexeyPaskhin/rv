package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.cashbox.CashboxTest;
import RulVulaknTests.registration.RegisterData;
import com.listeners.RussianVulcanListener;
import com.pages.BonusesPage;
import com.pages.HomePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({RussianVulcanListener.class})
public class BonusesPageTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);
    BonusesPage bonusesPage;

    // TODO: 2018-02-20 Check Bonuses page here
    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"regression"})
    @Description("Is Gift icon clickable for authorized user and linked to Bonuses page")
    public void isGiftIconClickable(User user) {
        new HomePage().getNotAuthorizedHeader()
                .clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyUSD()
                .clickRegisterButton()
                .check100PercentGift()
                .clickButtonSaveGift()
                .getAuthorizedHeader()
                .clickGiftIcon()
                .waitForPageToLoad();
        try {
            bonusesPage = new BonusesPage();
            Assert.assertTrue(bonusesPage.isBonusesPageOpened());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}
