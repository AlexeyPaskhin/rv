package RulVulaknTests.registration.mobile;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.pages.mobile.HomeMobilePage;
import com.pages.mobile.RegisterMobilePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegistrationNegativeMobileTest extends BaseTestPage {

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidRegister", "androidSmoke"})
    @Description("Registration negative case - enter invalid email.")
    public void tryRegisterWithInvalidEmail(User user) {
        RegisterMobilePage registerMobilePage = new HomeMobilePage()
                .clickRegister()
                .fillEmail("&*()&^")
                .fillPass(user.getPass())
                .agreeWithRules()
                .clickRegisterInInvalidForm();
        assertTrue(registerMobilePage.getINVALID_EMAIL_MESSAGE().isPresent());
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android"})
    @Description("Registration negative case - do not agree with rules.")
    public void tryRegisterWithoutRulesAgree(User user) {
        RegisterMobilePage registerMobilePage = new HomeMobilePage()
                .clickRegister()
                .fillEmail(user.getLogin())
                .fillPass(user.getPass())
                .clickRegisterInInvalidForm();
        assertTrue(registerMobilePage.getNOT_MARKED_AGREE_WITH_RULES().isPresent());
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android"})
    @Description("Registration negative case - do not fill email and password fields.")
    public void tryRegisterWithoutFilledEmailPasswordFields(User user) {
        RegisterMobilePage registerMobilePage = new HomeMobilePage()
                .clickRegister()
                .fillEmail("")
                .fillPass("")
                .agreeWithRules()
                .clickRegisterInInvalidForm();
        assertTrue(registerMobilePage.getINVALID_EMAIL_MESSAGE().isPresent());
        assertTrue(registerMobilePage.getINVALID_PASS_MESSAGE().isPresent());
    }

    @Test(dataProvider = "randomUserProviderWithoutAtInEmail", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android"})
    @Description("Registration negative case - enter email without '@'.")
    public void tryRegisterWithEmailWithoutAt(User user) {
        RegisterMobilePage registerMobilePage = new HomeMobilePage()
                .clickRegister()
                .fillEmail(user.getLogin())
                .fillPass(user.getPass())
                .agreeWithRules()
                .clickRegisterInInvalidForm();
        assertTrue(registerMobilePage.getINVALID_EMAIL_MESSAGE().isPresent());
    }

}

