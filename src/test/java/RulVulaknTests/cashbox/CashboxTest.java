package RulVulaknTests.cashbox;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.AbstractPage;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.popups.cashBoxFrames.CashBoxDepositFrame;
import com.utils.Card;
import com.utils.RandomGenerate;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by ai on 2018-01-18.
 */

@Listeners({RussianVulcanListener.class})
public class CashboxTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Random user deposit on random sum, card payment method.")
    public void makeCustomDepositRandomUser(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(300000) + 1);
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum(randomDeposit)
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();

        headerAutorizedUser.waitForBalanceChange(headerAutorizedUser.getUserBalance());
        try {
            Assert.assertTrue(headerAutorizedUser.getUserBalance() == Double.parseDouble(randomDeposit), "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }


    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Random user deposit on 500 rub, card payment method.")
    public void make500DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn500RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();

        headerAutorizedUser.waitForBalanceChange(headerAutorizedUser.getUserBalance());
        try {
            Assert.assertTrue(headerAutorizedUser.getUserBalance() == 500D, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Random user deposit on 1000 rub, card payment method.")
    public void make1000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn1000RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();

        headerAutorizedUser.waitForBalanceChange(headerAutorizedUser.getUserBalance());
        try {
            Assert.assertTrue(headerAutorizedUser.getUserBalance() == 1000, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Random user deposit on 3000 rub, card payment method.")
    public void make3000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn3000RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();

        headerAutorizedUser.waitForBalanceChange(headerAutorizedUser.getUserBalance());
        try {
            Assert.assertTrue(headerAutorizedUser.getUserBalance() == 3000, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Random user deposit on 10000 rub, card payment method.")
    public void make10000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn10000RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();

        headerAutorizedUser.waitForBalanceChange(headerAutorizedUser.getUserBalance());
        try {
            Assert.assertTrue(headerAutorizedUser.getUserBalance() == 10000, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Random user deposit on 30000 rub, card payment method.")
    public void make30000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn30000RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();

        headerAutorizedUser.waitForBalanceChange(headerAutorizedUser.getUserBalance());
        try {
            Assert.assertTrue(headerAutorizedUser.getUserBalance() == 30000, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Negative case. Random user deposit on 0 rub, card payment method.")
    public void makeZeroDepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum("0");

        try {
            Assert.assertFalse(new CashBoxDepositFrame().checkAvailableConfirmButton(), "INCORRECT DEPOSIT VALUE");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Negative case. Random user deposit on 300001 rub(more than allow), card payment method.")
    public void makeBigDepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum("300001");

        try {
            Assert.assertFalse(new CashBoxDepositFrame().checkAvailableConfirmButton(), "INCORRECT DEPOSIT VALUE");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Negative case. Random user deposit - type random string in cashbox, card payment method.")
    public void makeBlaBlaDepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum(RandomGenerate.randomString(6));

        try {
            Assert.assertFalse(new CashBoxDepositFrame().checkAvailableConfirmButton(), "INCORRECT DEPOSIT VALUE");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Auth User make deposit from remembered card.")
    public void makeRememberedCardDepositUser(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(300000) + 1);
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardStoredCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum(randomDeposit)
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();

        double balanceBefore = headerAutorizedUser.getUserBalance();
        headerAutorizedUser.waitForBalanceChange(headerAutorizedUser.getUserBalance());
        try {
            Assert.assertTrue(headerAutorizedUser.getUserBalance() == balanceBefore  + Double.parseDouble(randomDeposit), "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Check QIWI, YANDEX, VISA/MasterCard payment methods is available in cashbox")
    public void checkBasicPaymentMethodsAreAvaileble(User user, Card card) {
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .checkPaymentsMethodInFrame();

        try {
            Assert.assertTrue(new CashBoxDepositFrame().checkPaymentsMethodInFrame().size() == 3, "BASIC PAYMENT METHODS ARE ABSENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    @Description("Check if payment card is remembered in Cashbox, when Random user make random deposit.")
    public void checkDepositCardRandomUserIsSaved(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(300000) + 1);
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum(randomDeposit)
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();
        headerAutorizedUser.waitForBalanceChange(headerAutorizedUser.getUserBalance());
        headerAutorizedUser.refreshPage();
        new HomePage()
                .clickHeadCashBox()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .checkDepositCardIsSaved();

        try {
            Assert.assertTrue(new CashBoxDepositFrame().checkDepositCardIsSaved(), "FIRST PAYMENT DON'T PASS");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}