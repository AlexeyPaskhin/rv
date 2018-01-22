package RulVulaknTests.cashbox;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.utils.Card;
import com.utils.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by ai on 2018-01-18.
 */

@Listeners({RussianVulcanListener.class})
public class CashboxTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    public void makeCustomDepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .swithToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum("6000")
                .clickOnConfirmButton()
                .swtichToParent();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }


    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    public void make500DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .swithToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn500RubButton()
                .clickOnConfirmButton()
                .swtichToParent();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    public void make1000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .swithToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn1000RubButton()
                .clickOnConfirmButton()
                .swtichToParent();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    public void make3000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .swithToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn3000RubButton()
                .clickOnConfirmButton()
                .swtichToParent();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    public void make10000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .swithToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn10000RubButton()
                .clickOnConfirmButton()
                .swtichToParent();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    public void make30000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .swithToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn30000RubButton()
                .clickOnConfirmButton()
                .swtichToParent();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}