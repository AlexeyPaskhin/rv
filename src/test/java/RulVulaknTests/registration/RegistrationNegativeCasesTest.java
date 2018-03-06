package RulVulaknTests.registration;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.popups.FastRegisterPopup;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Registration negative from pop-up 'Bistraya Registratsyja' test cases
 * + Enter invalid e-mail
 * + Do not agree with rules
 * + Do not enter email and password
 * + Enter e-mail without '@'
 */

@Listeners({RussianVulcanListener.class})
public class RegistrationNegativeCasesTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationWithoutGiftsTest.class);

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register", "negative","regression"}, priority = 1)
    @Description("Registration negative case - enter invalid email.")
    public void tryRegisterWithInvalidEmail(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin() + "&*()&^")
                .typePass(user.getPass())
                .selectCurrencyRUB()
                .agreeWithRules()
                .clickRegisterButtonAndDoNothing();
        try {
            FastRegisterPopup fastRegisterPopup = new FastRegisterPopup();
            Assert.assertEquals(fastRegisterPopup.getValidEmailMessageText(), "Введите валидный e-mail");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register", "negative","regression"}, priority = 2)
    @Description("Registration negative case - do not agree with rules.")
    public void tryRegisterWithoutRulesAgree(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .selectCurrencyRUB()
                .clickRegisterButtonAndDoNothing();
        try {
            FastRegisterPopup fastRegisterPopup = new FastRegisterPopup();
            Assert.assertEquals(fastRegisterPopup.getAgreeWithRulesValidationMessageText(), "Вы должны согласиться с правилами и условиями");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register", "negative","regression"}, priority = 3)
    @Description("Registration negative case - do not fill email and password fields.")
    public void tryRegisterWithoutFilledEmailPasswordFields(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin("")
                .typePass("")
                .selectCurrencyRUB()
                .agreeWithRules()
                .clickRegisterButtonAndDoNothing();
        try {
            FastRegisterPopup fastRegisterPopup = new FastRegisterPopup();
            Assert.assertEquals(fastRegisterPopup.getEmailFieldEmptyErrorMessaheText(), "Поле не должно быть пустым");
//            Assert.assertEquals(fastRegisterPopup.getPasswordFilledErrorMessageText(), "Поле не должно быть пустым");
        } catch (Exception e) {

            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProviderWithoutAtInEmail", dataProviderClass = RegisterData.class, groups = {"register", "negative","regression"}, priority = 4)
    @Description("Registration negative case - enter email without '@'.")
    public void tryRegisterWithEmailWithoutAt(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .selectCurrencyRUB()
                .agreeWithRules()
                .clickRegisterButtonAndDoNothing();
        try {
            FastRegisterPopup fastRegisterPopup = new FastRegisterPopup();
            Assert.assertEquals(fastRegisterPopup.getRealEmailText(), "Введите настоящий e-mail");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    // TODO: 2018-01-27 Add negative registration test cases on landings
    // Registration algorithm the same on Main domain and on landings
    // We should not create the same negative test cases for Landings pages

}

