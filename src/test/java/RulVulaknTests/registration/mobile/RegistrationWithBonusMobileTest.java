package RulVulaknTests.registration.mobile;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.PreContidions.RemoveUser;
import com.pages.HeaderNotAutorizedUser;
import com.pages.mobile.HomeMobilePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegistrationWithBonusMobileTest extends BaseTestPage {

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android"})
    @Description("Registration with 'Welcome Bonus' gifts from button 'Register'")
    public void plainRegistrationBonus(User user) {
        new HomeMobilePage()
                .clickRegister()
                .fillEmail(user.getLogin())
                .fillPass(user.getPass())
                .agreeWithRules()
                .clickRegisterButton()
                .pressPlayWithBonus();
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
        assertTrue(homeMobilePage.firstBonusPanelIsPresent(), "Bonus panel isn't displayed");
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFb"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Register' pop-up - via Facebook")
    public void mainPageRegisterFBBonus(User user) {
//        new HomeMobilePage()
//                .clickRegister()
//                .clickFB()
//                .setEmail(user.getLogin())
//                .setPassword(user.getPass())
//                .clickRegister()
//                .agreeWithRules()
//                .clickCompleteRegister()
//                .getWelcomeBonusGiftPopup()
//                .pressPlayWithBonus();

    }

}
