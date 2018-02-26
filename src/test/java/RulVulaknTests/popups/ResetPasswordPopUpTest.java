package RulVulaknTests.popups;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.popups.ResetPasswordPopUp;
import com.utils.CustomDataProvider;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Reset password pop-up
 * + send reset password request from header (un-authorized user)
 * + close Reset password pop-up
 * + enter invalid emai - vvedite nastoyashij e-mail - pole ne dolxhno bytj pustym
 * + send reset password request from Log-In pop-up ("Vhod")
 */
@Listeners({RussianVulcanListener.class})
public class ResetPasswordPopUpTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);
    CustomDataProvider dataProvider = new CustomDataProvider();

    @Test(groups = {"resetpass"})
    @Description("Send reset password request from link in Header for un-authorized user")
    public void resetPasswordFromHeaderForUnAuthorizedUser() {
        new HeaderNotAutorizedUser()
                .clickResetPasswordLink()
                .fillEmailField(dataProvider.getPassRecoveryEmail())
                .pressButtonVosstanovit()
                .closePopUpZayavkaPriniata();
        try {
            Assert.assertTrue(home.isHomePageOpenedForNotAuthorized());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(groups = {"resetpass", "negative"})
    @Description("Check validation Error message 'Enter real e-mail' in field 'Enter e-mail' - Reset password pop-up")
    public void checkValidationErrorMessageInFieldEmail() {
        new HeaderNotAutorizedUser()
                .clickResetPasswordLink()
                .fillEmailField("sdasdasdasd")
                .pressButtonVosstanovit();
        try {
            ResetPasswordPopUp resetPasswordPopUp = new ResetPasswordPopUp();
            Assert.assertEquals(resetPasswordPopUp.emailFieldErrorMessage(), "Введите настоящий e-mail");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(groups = {"resetpass", "negative"})
    @Description("Check validation Error message 'Field should not be empty' in field 'Enter e-mail' - Reset password pop-up")
    public void checkEmptyEmailFieldErrorMessage() {
        new HeaderNotAutorizedUser()
                .clickResetPasswordLink()
                .fillEmailField("")
                .pressButtonVosstanovit();
        try {
            ResetPasswordPopUp resetPasswordPopUp = new ResetPasswordPopUp();
            Assert.assertEquals(resetPasswordPopUp.emailFieldErrorMessage(), "Поле не должно быть пустым");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    // TODO: 2018-02-20 Can't find solution how to check step when user try to recover password more than 3 times one-by-one
//    @Test(groups = {"resetpass", "negative"})
//    @Description("Try to send recovery password request more then 3 times")
    public void sendRecoveryPassRequestFourTimes() {
        new HomePage().getNotAuthorizedHeader()
                .clickResetPasswordLink()
                .fillEmailField(dataProvider.getPassRecoveryEmail())
                .pressButtonVosstanovit()
                .closePopUpZayavkaPriniata()
                .waitForPageToLoad();
        try {
            ResetPasswordPopUp resetPasswordPopUp = new ResetPasswordPopUp();
            Assert.assertEquals(resetPasswordPopUp.emailFieldErrorMessage(), "Превышен лимит запросов. Попробуйте, пожалуйста, позже.");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}
