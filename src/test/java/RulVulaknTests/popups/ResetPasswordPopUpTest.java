package RulVulaknTests.popups;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.popups.ResetPasswordPopUp;
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

    @Test
    @Description("Send reset password request from link in Header for un-authorized user")
    public void resetPasswordFromHeaderForUnAuthorizedUser() {
        new HeaderNotAutorizedUser()
                .clickResetPasswordLink()
                .fillEmailField("yr+resetpass@playrini.ua")
                .pressButtonVosstanovit()
                .closePopUpZayavkaPriniata();
        try {
            Assert.assertTrue(home.isHomePageOpened());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test
    @Description("Close reset password pop-up by button 'Close'")
    public void closeResetPasswordPopUp() {
        new HeaderNotAutorizedUser()
                .clickResetPasswordLink()
                .pressButtonClosepopUp();
        try {
            Assert.assertTrue(home.isHomePageOpened());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test
    @Description("Check validation Error message 'Enter real e-mail' in field 'Enter e-mail' - Reset password pop-up")
    public void checkValidationErrorMessageInFieldEmail() {
        new HeaderNotAutorizedUser()
                .clickResetPasswordLink()
                .fillEmailField("sdasdasdasd")
                .pressButtonVosstanovit();
        try {
            ResetPasswordPopUp resetPasswordPopUp = new ResetPasswordPopUp();
            Assert.assertEquals(resetPasswordPopUp.enterValidEmailErrorMessage(), "Введите настоящий e-mail");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test
    @Description("Check validation Error message 'Field should not be empty' in field 'Enter e-mail' - Reset password pop-up")
    public void checkEmptyEmailFieldErrorMessage() {
        new HeaderNotAutorizedUser()
                .clickResetPasswordLink()
                .fillEmailField("")
                .pressButtonVosstanovit();
        try {
            ResetPasswordPopUp resetPasswordPopUp = new ResetPasswordPopUp();
            Assert.assertEquals(resetPasswordPopUp.enterValidEmailErrorMessage(), "Поле не должно быть пустым");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

}
