package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderAuthorizedUser;
import com.pages.HomePage;
import com.pages.ProfilePage;
import com.pages.VipPage;
import com.popups.ChangesSavedConfirmPopUp;
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

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
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

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("cancel Of Changing Password")
    public void cancelOfChangingPassword(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickChangePass()
                .clickCancelChangePass();
        assertTrue(profilePage.getCHANGE_PASS_BUTTON().isPresent());
        assertFalse(profilePage.getOLD_PASS_INPUT().isPresent());
        assertFalse(profilePage.getNEW_PASS_INPUT().isPresent());
        assertFalse(profilePage.getNEW_PASS_REPEAT_INPUT().isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("successful Changing Password")
    public void successfulChangingPassword(User user) {
        String newPass = user.getPass() + "a";
        ChangesSavedConfirmPopUp confirmPopUp =
                new HomePage()
                        .logInUser(user)
                        .clickUserName()
                        .clickChangePass()
                        .setToOldPassField(user.getPass())
                        .setToNewPassField(newPass)
                        .setToConfirmPassField(newPass)
                        .successfulSaveChanges();

        assertTrue(confirmPopUp.CLOSE_POPUP_SUCCESS_CHANGES_BUTTON.isPresent());
        try {
            //check that new pass is valid
            confirmPopUp.closeConfirmPopUp();
            new HeaderAuthorizedUser()
                    .clickExit()
                    .logInUser(user.getLogin(), newPass);
            assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE IS NOT PRESENT");
            assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");

            //post-conditions - return back old pass
            new HeaderAuthorizedUser()
                    .clickUserName()
                    .successfulChangePass(newPass, user.getPass());
        } catch (Exception e) {
            e.printStackTrace();
             fail("SOMETHING WRONG WITH TURNING BACK OLD PASS, DO IT MANUALLY!!!");
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("changing Password With Wrong Old Pass")
    public void changingPasswordWithWrongOldPass(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .failedChangePass(user.getPass() + "kek", "111111a");
        assertTrue(profilePage.getWRONG_PASS_VALIDATION_MESSAGE().isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
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
        assertTrue(profilePage.getNOT_EQUAL_PASS_VALIDATION_MESSAGE().isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("confirm Email")
    public void confirmEmail(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickConfirmEmail();
        assertTrue(profilePage.getEMAIL_SENT_INSCRIPTION().isPresent());
    }

    //todo failing due to cashbox changes
    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
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

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("click Receive Sms Code With Empty Phone")
    public void clickReceiveSmsCodeWithEmptyPhone(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToPhoneField("")
                .clickReceiveSmsCode();
        assertTrue(profilePage.getINVALID_PHONE_VALIDATION_MESSAGE().isPresent());
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("click Receive Sms Code With Invalid Phone")
    public void clickReceiveSmsCodeWithInvalidPhone(User user) {
        profilePage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToPhoneField("+3806358719")
                .clickReceiveSmsCode();
        assertTrue(profilePage.getINVALID_PHONE_VALIDATION_MESSAGE().isPresent());
    }

//    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
//    @Description("click Receive Sms Code With Correct Phone")
//    public void clickReceiveSmsCodeWithCorrectPhone(User user) {
//        String phone = RandomGenerate.randomStringOfDigits(12);
//        profilePage = new HomePage()
//                .logInUser(user)
//                .clickUserName()
//                .setToPhoneField(phone)
//                .clickReceiveSmsCode();
//        assertFalse(profilePage.getINVALID_PHONE_VALIDATION_MESSAGE().isPresent());
//        assertTrue(profilePage.getCONFIRM_SMS_CODE_BUTTON().isPresent());
//    }
    //we have the rewardForConfirmationOfPhone test which includes logic of this commented test and even more

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("saving Entered Phone")
    public void savingEnteredPhone(User user) {
        String phone = RandomGenerate.randomStringOfDigits(12);
        new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToPhoneField("")
                .successfulSaveChanges()
                .closeConfirmPopUp()
                .setToPhoneField(phone)
                .successfulSaveChanges();
        profilePage = new ProfilePage();
        profilePage.refreshPage();
        assertEquals(profilePage.getPHONE_INPUT().getValue(), phone);
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("saving Entered Name")
    public void savingEnteredName(User user) {
        String name = RandomGenerate.randomString(5, 30);
        new HomePage()
                .logInUser(user)
                .clickUserName()
                .setToNameField("")
                .successfulSaveChanges()
                .closeConfirmPopUp()
                .setToNameField(name)
                .successfulSaveChanges();
        profilePage = new ProfilePage();
        profilePage.refreshPage();
        assertEquals(profilePage.getFULL_NAME_INPUT().getValue(), name);
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"profile"})
    @Description("clicking Link Vip Club Details")
    public void clickingLinkVipClubDetails(User user) {
        VipPage vipPage = new HomePage()
                .logInUser(user)
                .clickUserName()
                .clickVipClubDetailsLink();
        assertTrue(vipPage.isVipPageLoaded());
    }

}
