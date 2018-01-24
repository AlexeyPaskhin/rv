package RulVulaknTests.cashbox;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.utils.Card;
import com.utils.User;
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
            Assert.assertFalse(headerAutorizedUser.getUserBalance() != Double.parseDouble(randomDeposit), "USER BALANCE CHANGED INCORRECT");
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
            Assert.assertFalse(headerAutorizedUser.getUserBalance() != 500D, "USER BALANCE CHANGED INCORRECT");
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
            Assert.assertFalse(headerAutorizedUser.getUserBalance() != 1000, "USER BALANCE CHANGED INCORRECT");
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
            Assert.assertFalse(headerAutorizedUser.getUserBalance() != 3000, "USER BALANCE CHANGED INCORRECT");
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
            Assert.assertFalse(headerAutorizedUser.getUserBalance() != 10000, "USER BALANCE CHANGED INCORRECT");
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
            Assert.assertFalse(headerAutorizedUser.getUserBalance() != 30000, "USER BALANCE CHANGED INCORRECT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}