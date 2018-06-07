package RulVulaknTests.registration;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.popups.FastRegisterPopup;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Registration negative from pop-up 'Bistraya Registratsyja' test cases
 * + Enter invalid e-mail
 * + Do not agree with rules
 * + Do not enter email and password
 * + Enter e-mail without '@'
 * <p>
 * <p>
 * org.testng.Assert doesn't work stable at these tests :( so we use explicit waits for checking desired elements
 */

@Listeners({RussianVulcanListener.class})
public class RegistrationNegativeCasesTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationWithoutGiftsTest.class);

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register", "negative", "regression"}, priority = 1)
    @Description("Registration negative case - enter invalid email.")
    public void tryRegisterWithInvalidEmail(User user) {
        FastRegisterPopup fastRegisterPopup =
                new HeaderNotAutorizedUser().clickRegister()
                        .typeLogin(user.getLogin() + "&*()&^")
                        .typePass(user.getPass())
                        .selectCurrencyRUB()
                        .agreeWithRules()
                        .clickRegisterButtonAndDoNothing();
        try {
//            assertTrue(fastRegisterPopup.oneElementIsPresent(FastRegisterPopup.enterValidEmailErrorLocator));
            fastRegisterPopup.ENTER_VALID_EMAIL_ERROR.waitForElementToBeVisible(3);
            //            assertTrue(fastRegisterPopup.ENTER_VALID_EMAIL_ERROR.isDisplayed(),
            //                    "The text 'Введите корректный e-mail' isn't displayed after submitting invalid email");
        } catch (TimeoutException e) {
            logger.error(e);
            Assert.fail("The text 'Введите корректный e-mail' isn't displayed after submitting invalid email");
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register", "negative", "regression"}, priority = 2)
    @Description("Registration negative case - do not agree with rules.")
    public void tryRegisterWithoutRulesAgree(User user) {
        FastRegisterPopup fastRegisterPopup =
                new HeaderNotAutorizedUser().clickRegister()
                        .typeLogin(user.getLogin())
                        .typePass(user.getPass())
                        .selectCurrencyRUB()
                        .clickRegisterButtonAndDoNothing();
        try {
            fastRegisterPopup.AGREE_WITH_RULES_ERROR.waitForElementToBeVisible(3);
        } catch (TimeoutException e) {
            logger.error(e);
            Assert.fail("The text 'Вы должны согласиться с правилами и условиями' isn't displayed after" +
                    " submitting the reg form without checking the checkbox");
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register", "negative", "regression"}, priority = 3)
    @Description("Registration negative case - do not fill email and password fields.")
    public void tryRegisterWithoutFilledEmailPasswordFields(User user) {
        FastRegisterPopup fastRegisterPopup =
                new HeaderNotAutorizedUser().clickRegister()
                .typeLogin("")
                .typePass("")
                .selectCurrencyRUB()
                .agreeWithRules()
                .clickRegisterButtonAndDoNothing();
        try {
            fastRegisterPopup.EMPTY_EMAIL_FIELD_ERROR.waitForElementToBeVisible(3);
//            Assert.assertEquals(fastRegisterPopup.getPasswordFilledErrorMessageText(), "Поле не должно быть пустым");
        } catch (TimeoutException e) {
            logger.error(e);
            Assert.fail("An appropriate error message isn't shown");
        }
    }

    @Test(dataProvider = "randomUserProviderWithoutAtInEmail", dataProviderClass = RegisterData.class, groups = {"register", "negative", "regression"}, priority = 4)
    @Description("Registration negative case - enter email without '@'.")
    public void tryRegisterWithEmailWithoutAt(User user) {
        FastRegisterPopup fastRegisterPopup =
                new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .selectCurrencyRUB()
                .agreeWithRules()
                .clickRegisterButtonAndDoNothing();
        try {
            fastRegisterPopup.ENTER_REAL_EMAIL_ERROR.waitForElementToBeVisible(3);
        } catch (TimeoutException e) {
            logger.error(e);
            Assert.fail("An appropriate error message isn't shown");
        }
    }

    // TODO: 2018-01-27 Add negative registration test cases on landings
    // Registration algorithm the same on Main domain and on landings
    // We should not create the same negative test cases for Landings pages

}

