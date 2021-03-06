package RulVulaknTests.cashbox;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderAuthorizedUser;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.popups.cashBoxFrames.CashBoxDepositFrame;
import com.popups.cashBoxFrames.CashBoxWithdrawalFrame;
import com.popups.CashBoxPopup;
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

import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class CashboxTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user deposit on random sum, card payment method.")
    public void makeCustomDepositRandomUser(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(300000) + 1);
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
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
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        try {
            assertTrue(headerAuthorizedUser.getUserBalance() == Double.parseDouble(randomDeposit), "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }


    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user deposit on 500 rub, card payment method.")
    public void make500DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn500RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        try {
            assertTrue(headerAuthorizedUser.getUserBalance() == 500D, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user deposit on 1000 rub, card payment method.")
    public void make1000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn1000RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        try {
            assertTrue(headerAuthorizedUser.getUserBalance() == 1000, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user deposit on 3000 rub, card payment method.")
    public void make3000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn3000RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        try {
            assertTrue(headerAuthorizedUser.getUserBalance() == 3000, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user deposit on 10000 rub, card payment method.")
    public void make10000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn10000RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        try {
            assertTrue(headerAuthorizedUser.getUserBalance() == 10000, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user deposit on 30000 rub, card payment method.")
    public void make30000DepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn30000RubButton()
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        try {
            assertTrue(headerAuthorizedUser.getUserBalance() == 30000, "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Negative case. Random user deposit on 0 rub, card payment method.")
    public void makeZeroDepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
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

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Negative case. Random user deposit on 300001 rub(more than allow), card payment method.")
    public void makeBigDepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
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

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Negative case. Random user deposit - type random string in cashbox, card payment method.")
    public void makeBlaBlaDepositRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
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

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Auth User make deposit from remembered card.")
    public void makeRememberedCardDepositUser(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(300000) + 1);
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardStoredCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum(randomDeposit)
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();
        double balanceBefore = headerAuthorizedUser.getUserBalance();
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        try {
            assertTrue(headerAuthorizedUser.getUserBalance() == balanceBefore + Double.parseDouble(randomDeposit), "USER BALANCE NOT CHANGED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Check QIWI, YANDEX, VISA/MasterCard payment methods is available for deposit in cashbox")
    public void checkBasicPaymentMethodsAreAvailableForDeposit(User user, Card card) {
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame();
        try {
            assertTrue(new CashBoxDepositFrame().checkPaymentsMethodInDepositFrame().size() == 3, "BASIC PAYMENT METHODS ARE ABSENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Check if payment card is remembered in Cashbox, when Random user make random deposit.")
    public void checkDepositCardRandomUserIsSaved(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(300000) + 1);
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
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
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        headerAuthorizedUser.refreshPage();
        new HomePage()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .checkDepositCardIsSaved();
        try {
            assertTrue(new CashBoxDepositFrame().checkDepositCardIsSaved(), "FIRST PAYMENT DON'T PASS");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Check QIWI, YANDEX, VISA/MasterCard payment methods is available for withdrawal in cashbox")
    public void checkBasicPaymentMethodsAreAvailebleForWithdrawal(User user, Card card) {
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .checkPaymentsMethodInWithdrawalFrame();
        try {
            assertTrue(new CashBoxWithdrawalFrame().checkPaymentsMethodInWithdrawalFrame().size() == 3, "BASIC PAYMENT METHODS ARE ABSENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user deposit on random sum, card payment method. Then withdrawal this sum.")
    public void makeCustomWithdrawalRandomUser(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(13500) + 1500);
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
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
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        headerAuthorizedUser.refreshPage();

        new HeaderAuthorizedUser().pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .clickCardPaymentMethod()
                .typeCardWithdrawalSum(randomDeposit)
                .typePhoneNumberInCardDepositFrame("9101234567")
                .clickGetButton();
        try {
            assertTrue(new CashBoxWithdrawalFrame().successMessageIsPresent(), "WITHDRAWAL FAILED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Auth make withdrawal on random sum.")
    public void makeCustomWithdrawalAuthUser(User user, Card card) {
        String randomWithdrawal = Integer.toString(new Random().nextInt(13500) + 1500);
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .clickCardPaymentMethod()
                .typeCardWithdrawalSum(randomWithdrawal)
                .clickGetButton();
        try {
            assertTrue(new CashBoxWithdrawalFrame().successMessageIsPresent(), "WITHDRAWAL FAILED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user make withdrawal on sum, more then he have.")
    public void makeMoreThenDepositWithdrawalRandomUser(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(13499) + 1500);
        String biggerWithdrawal = Integer.toString(Integer.parseInt(randomDeposit) + 1);
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
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
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        headerAuthorizedUser.refreshPage();

        new HeaderAuthorizedUser().pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .clickCardPaymentMethod()
                .typeCardWithdrawalSum(biggerWithdrawal)
                .typePhoneNumberInCardDepositFrame("9101234567")
                .clickGetButton();

        try {
            assertTrue(new CashBoxWithdrawalFrame().notEnoughMessageIsPresent(), "WITHDRAWAL FAILED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Auth make withdrawal on more then allow sum.")
    public void makeMoreThenAllowWithdrawalAuthUser(User user, Card card) {
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .clickCardPaymentMethod()
                .typeCardWithdrawalSum("15001");
        try {
            Assert.assertFalse(new CashBoxWithdrawalFrame().getButtonIsActive(), "WITHDRAWAL PASS");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Auth make withdrawal on less then allow sum.")
    public void makeLessThenAllowWithdrawalAuthUser(User user, Card card) {
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .clickCardPaymentMethod()
                .typeCardWithdrawalSum("1499");
        try {
            Assert.assertFalse(new CashBoxWithdrawalFrame().getButtonIsActive(), "WITHDRAWAL PASS");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Auth make withdrawal on more then allow sum.")
    public void makeBlablaWithdrawalAuthUser(User user, Card card) {
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .clickCardPaymentMethod()
                .typeCardWithdrawalSum(RandomGenerate.randomString(5));
        try {
            Assert.assertFalse(new CashBoxWithdrawalFrame().getButtonIsActive(), "WITHDRAWAL PASS");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random open deposit frame from empty history payment tab")
    public void openDepositFrameFromHistoryPaymentTabRandomUser(User user, Card card) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .clickTabPaymentHistory()
                .clickOnMakeDepositFromHistoryTab();
        try {
            assertTrue(new CashBoxPopup().depositTabIsActive(), "HISTORY TAB NOT EMPTY");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Random user deposit on random sum, card payment method. Then withdrawal this sum.")
    public void cancelCustomWithdrawalRandomUser(User user, Card card) {
        String randomDeposit = Integer.toString(new Random().nextInt(13500) + 1500);
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift()
                .getAuthorizedHeader()
                .pressCashBoxButton()
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
        headerAuthorizedUser.waitForBalanceChange(headerAuthorizedUser.getUserBalance());
        headerAuthorizedUser.refreshPage();

        new HeaderAuthorizedUser().pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .clickCardPaymentMethod()
                .typeCardWithdrawalSum(randomDeposit)
                .typePhoneNumberInCardDepositFrame("9101234567")
                .clickGetButton()
                .switchToParent();

        headerAuthorizedUser.refreshPage();
        new HeaderAuthorizedUser().pressCashBoxButton()
                .clickTabPaymentHistory()
                .clickOnCancelWithdrawalFromHistoryTab();
        try {
            assertTrue(new CashBoxPopup().canceledWithdrawalStringPresent(), "WITHDRAWAL NOT CANCELED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "userAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"})
    @Description("Close Popup Test.")
    public void closeCashBoxPopUpAutUser(User user, Card card) {
        new HeaderNotAutorizedUser().typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .clickCloseCashboxPopup();
        try {
            assertTrue(new HeaderAuthorizedUser().userZoneIsPresent(), "POPUP NOT CLOSED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}