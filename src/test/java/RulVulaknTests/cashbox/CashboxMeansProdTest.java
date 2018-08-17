package RulVulaknTests.cashbox;

import RulVulaknTests.BaseTestPage;
import com.utils.Card;
import com.utils.User;
import io.qameta.allure.Description;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

/**
 * these tests are executed with prepared test user on prod with pre-filled data in each payment method
 */

public class CashboxMeansProdTest extends BaseTestPage {

    @Test(dataProvider = "prodUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"prodSmoke"}, alwaysRun = true)
    @Description("open Deposit Page Visa Or Master Card On Prod")
    public void openDepositPageVisaOrMasterCardOnProd(User user, Card card) {
        home.logInUser(user)
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardStoredCVV(card.getCvv())
                .clickOnConfirmButton()
                .clickProceedButton()
                .switchToSocialFrame();
        try {
            home.waitForPageTitleToBe("Verified by Visa");
        } catch (TimeoutException e) {

            e.printStackTrace();
            fail();
        }
    }

    @Test(dataProvider = "prodUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"prodSmoke"}, alwaysRun = true)
    @Description("open Deposit Page Qiwi On Prod")
    public void openDepositPageQiwiOnProd(User user, Card card) {
        home.logInUser(user)
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickQiwiPaymentMethod()
                .clickOnConfirmButton()
                .switchToSocialFrame();
        try {
            home.waitForPageTitleToBe("QIWI");
        } catch (TimeoutException e) {

            e.printStackTrace();
            fail();
        }
    }

    @Test(dataProvider = "prodUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"prodSmoke"}, alwaysRun = true)
    @Description("open Deposit Page Yandex On Prod")
    public void openDepositPageYandexOnProd(User user, Card card) {
        home.logInUser(user)
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickYandexPaymentMethod()
                .clickOnConfirmButton()
                .switchToSocialFrame();
        try {
            home.waitForPageTitleToBe("Yandex.Money");
        } catch (TimeoutException e) {

            e.printStackTrace();
            fail();
        }
    }

    @Test(dataProvider = "prodUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"prodSmoke"}, alwaysRun = true)
    @Description("open Deposit Page Webmoney On Prod")
    public void openDepositPageWebmoneyOnProd(User user, Card card) {
        home.logInUser(user)
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickWebmoneyPaymentMethod()
                .clickOnConfirmButton()
                .switchToSocialFrame();
        try {
            home.waitForPageTitleToBe("Merchant WebMoney Transfer");
        } catch (TimeoutException e) {

            e.printStackTrace();
            fail();
        }
    }

    @Test(dataProvider = "prodUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"prodSmoke"}, alwaysRun = true)
    @Description("open Deposit Page Monetaru On Prod")
    public void openDepositPageMonetaruOnProd(User user, Card card) {
        home.logInUser(user)
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickMonetaruPaymentMethod()
                .clickOnConfirmButton()
                .switchToSocialFrame();
        try {
            home.waitForPageTitleToBe("Payment service provider PayAnyWay - online payment solutions. Internet acquiring.");
        } catch (TimeoutException e) {

            e.printStackTrace();
            fail();
        }
    }

    @Test(dataProvider = "prodUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"prodSmoke"}, alwaysRun = true)
    @Description("open Deposit Page AlphaClick On Prod")
    public void openDepositPageAlphaClickOnProd(User user, Card card) {
        home.logInUser(user)
                .pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickAlphaClickPaymentMethod()
                .clickOnConfirmButton()
                .switchToSocialFrame();
        try {
            home.waitForPageTitleToBe("Yandex.Money");
        } catch (TimeoutException e) {

            e.printStackTrace();
            fail();
        }
    }

}
