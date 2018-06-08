package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderAutorizedUser;
import com.pages.HomePage;
import com.pages.ProfilePage;
import com.pages.VipPage;
import com.popups.cashBoxFrames.CashBoxDepositFrame;
import com.utils.RandomGenerate;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class ProfilePageTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);
    ProfilePage profilePage;

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("Is User's name clickable for authorized user and linked to Profile page")
    public void isUserNameIconPresentAndClickableForAuthorizedUser(User user) {
        new HomePage()
                .logInUser(user)
                .clickUserName()
                .waitForPageToLoad();
        try {
            profilePage = new ProfilePage();
            assertTrue(profilePage.isProfilePageOpened());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("cancel Of Changing Password")
    public void cancelOfChangingPassword(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickChangePass()
                .clickCancelChangePass();
        assertTrue(profilePage.CHANGE_PASS_BUTTON.isPresent() && profilePage.CHANGE_PASS_BUTTON.isVisible());
        assertFalse(profilePage.OLD_PASS_INPUT.isPresent() && profilePage.OLD_PASS_INPUT.isVisible());
        assertFalse(profilePage.NEW_PASS_INPUT.isPresent() && profilePage.NEW_PASS_INPUT.isVisible());
        assertFalse(profilePage.NEW_PASS_REPEAT_INPUT.isPresent() && profilePage.NEW_PASS_REPEAT_INPUT.isVisible());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("successful Changing Password")
    public void successfulChangingPassword(User user) {
        String newPass = user.getPass() + "a";
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickChangePass()
                .setToOldPassField(user.getPass())
                .setToNewPassField(newPass)
                .setToConfirmPassField(newPass)
                .successfulSaveChanges();
        assertTrue(profilePage.CLOSE_POPUP_SUCCESS_CHANGES_BUTTON.isPresent() &&
                profilePage.CLOSE_POPUP_SUCCESS_CHANGES_BUTTON.isVisible());
        try {
            //check that new pass is valid
            profilePage.closeConfirmPopUp();
            new HeaderAutorizedUser()
                    .clickExit()
                    .logInUser(user.getLogin(), newPass);
            assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE IS NOT PRESENT");
            assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");

            //post-conditions - return back old pass
            new HeaderAutorizedUser()
                    .clickUserName()
                    .successfulChangePass(newPass, user.getPass());
        } catch (Exception e) {
            e.printStackTrace();
            fail("SOMETHING WRONG WITH TURNING BACK OLD PASS, DO IT MANUALLY!!!");
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("changing Password With Wrong Old Pass")
    public void changingPasswordWithWrongOldPass(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .failedChangePass(user.getPass() + "kek", "111111a");
        assertTrue(profilePage.WRONG_PASS_VALIDATION_MESSAGE.isPresent() &&
                profilePage.WRONG_PASS_VALIDATION_MESSAGE.isVisible());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("changing Password With Different New Passwords")
    public void changingPasswordWithDifferentNewPasswords(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickChangePass()
                .setToOldPassField(user.getPass())
                .setToNewPassField("111111a")
                .setToConfirmPassField("saglnagnjri")
                .failedSaveChanges();
        assertTrue(profilePage.NOT_EQUAL_PASS_VALIDATION_MESSAGE.isPresent() &&
                profilePage.NOT_EQUAL_PASS_VALIDATION_MESSAGE.isVisible());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("confirm Email")
    public void confirmEmail(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickConfirmEmail();
        assertTrue(profilePage.EMAIL_SENT_INSCRIPTION.isPresent() &&
                profilePage.EMAIL_SENT_INSCRIPTION.isVisible());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("opening Cash Box")
    public void openingCashBox(User user) {
        new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickRechargeButton()
                .switchToCashBoxDepositFrame();
        assertEquals(new CashBoxDepositFrame().checkPaymentsMethodInDepositFrame().size(), 3,
                "BASIC PAYMENT METHODS ARE ABSENT AFTER OPENING CASH BOX FROM PROFILE");
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("click Receive Sms Code With Empty Phone")
    public void clickReceiveSmsCodeWithEmptyPhone(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToPhoneField("")
                .clickReceiveCode();
        assertTrue(profilePage.INVALID_PHONE_VALIDATION_MESSAGE.isPresent() &&
                profilePage.INVALID_PHONE_VALIDATION_MESSAGE.isVisible());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("click Receive Sms Code With Invalid Phone")
    public void clickReceiveSmsCodeWithInvalidPhone(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToPhoneField("+3806358719")
                .clickReceiveCode();
        assertTrue(profilePage.INVALID_PHONE_VALIDATION_MESSAGE.isPresent() &&
                profilePage.INVALID_PHONE_VALIDATION_MESSAGE.isVisible());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("click Receive Sms Code With Correct Phone")
    public void clickReceiveSmsCodeWithCorrectPhone(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToPhoneField("+380235871912")
                .clickReceiveCode();
        assertFalse(profilePage.INVALID_PHONE_VALIDATION_MESSAGE.isPresent() &&
                profilePage.INVALID_PHONE_VALIDATION_MESSAGE.isVisible());
        assertTrue(profilePage.CONFIRM_SMS_CODE_BUTTON.isPresent() &&
                profilePage.CONFIRM_SMS_CODE_BUTTON.isVisible());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("saving Entered Phone")
    public void savingEnteredPhone(User user) {
        String phone = "380235871912";
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToPhoneField("")
                .successfulSaveChanges()
                .closeConfirmPopUp()
                .setToPhoneField(phone)
                .successfulSaveChanges();
                profilePage.refreshPage();
        assertEquals(profilePage.PHONE_INPUT.getValue(), phone);
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("saving Entered Name")
    public void savingEnteredName(User user) {
        String name = RandomGenerate.randomString(5, 30);
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToNameField("")
                .successfulSaveChanges()
                .closeConfirmPopUp()
                .setToNameField(name)
                .successfulSaveChanges();
                profilePage.refreshPage();
        assertEquals(profilePage.FULL_NAME_INPUT.getValue(), name);
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "profile"})
    @Description("clicking Link Vip Club Details")
    public void clickingLinkVipClubDetails(User user) {
        VipPage vipPage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickVipClubDetailsLink();
        assertTrue(vipPage.isVipPageLoaded());
    }

}
