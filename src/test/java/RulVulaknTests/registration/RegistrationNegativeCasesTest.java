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
 */

@Listeners({RussianVulcanListener.class})
public class RegistrationNegativeCasesTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationWithoutGiftsTest.class);

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
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
            Assert.assertTrue(fastRegisterPopup.isEnterValidEmailMessagePresenr(), "NO ERROR MESSAGES WHEN USER ENTER INVALID EMAIL");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    @Description("Registration negative case - do not agree with rules.")
    public void tryRegisterWithoutRulesAgree(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .selectCurrencyRUB()
                .clickRegisterButtonAndDoNothing();
        try {
            FastRegisterPopup fastRegisterPopup = new FastRegisterPopup();
            Assert.assertTrue(fastRegisterPopup.isAgreeWithRulesValidationMessagePresenr(), "NO ERROR MESSAGES WHEN USER DO NOT AGREE WITH RULES");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    @Description("Registration negative case - do not fill email and password fields.")
    public void registration(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin("")
                .typePass("")
                .selectCurrencyRUB()
                .agreeWithRules()
                .clickRegisterButtonAndDoNothing();
        try {
            FastRegisterPopup fastRegisterPopup = new FastRegisterPopup();
            Assert.assertTrue(fastRegisterPopup.isEmailFilled(), "NO ERROR MESSAGE WHEN USER DO NOT ENTER LOGIN");
            Assert.assertTrue(fastRegisterPopup.isPasswordFilled(), "NO ERROR MESSAGE WHEN USER DO NOT ENTER PASSWORD");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    // TODO: 2018-01-27 Add case of registration 'Enter email without @' - Error message 'Введите валидный e-mail'
    // Cant create user with email without '@'

    // TODO: 2018-01-27 Add negative registration test cases on landings

}

