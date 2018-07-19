package RulVulaknTests.registration.mobile;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.pages.HeaderNotAutorizedUser;
import com.pages.landing.LandingChooseBonusWinthContinue;
import com.pages.landing.LandingWithBonus;
import com.pages.landing.LandingWithButton;
import com.pages.landing.LandingWithForm;
import com.pages.mobile.HomeMobilePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Registration without gifts
 * + from landings
 * + from registration pop-up
 */

public class RegistrationWithoutGiftsMobileTest extends BaseTestPage {

    private void checkHomeMobilePageInNewlyRegisteredState() {
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
        assertFalse(homeMobilePage.firstBonusPanelIsPresent(), "Bonus panel is displayed after refusal from bonuses");
    }

    private void checkHomeMobilePageInNewlyRegisteredStateFromLP(String pageNumber) {
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT ON PAGE " + pageNumber);
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED ON PAGE " + pageNumber);
        assertFalse(homeMobilePage.firstBonusPanelIsPresent(), "Bonus panel is displayed after refusal from bonuses on page " + pageNumber);
    }
    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidLanding", "androidRegister", "android"})
    @Description("Registration without gifts from button 'Register'")
    public void plainRegistrationWithoutBonus(User user) {
        new HomeMobilePage()
                .clickRegister()
                .fillEmail(user.getLogin())
                .fillPass(user.getPass())
                .agreeWithRules()
                .clickRegisterButton()
                .clickWithdrawFromGift();
      checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
    @RemoveUser
    @Description("Social registration without gifts from 'Register' pop-up - via Facebook")
    public void mainPageRegisterFB(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidLanding", "androidRegister", "android"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @Description("Registration without gifts from lending pages 1, 2, 4, 5, 14")
    public void landingComplexRegister(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .clickWithdrawFromGift();
      checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidVK"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 1, 2, 4, 5, 14 - via VK.com")
    public void landingComplexRegisterVK(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 1, 2, 4, 5, 14 - via Facebook.com")
    public void landingComplexRegisterFB(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 1, 2, 4, 5, 14 - via OK.ru")
    public void landingComplexRegisterOK(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton().switchToRegistration().
                clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidMR"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 1, 2, 4, 5, 14 - via Mail.ru")
    public void landingComplexRegisterMailRU(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 1, 2, 4, 5, 14 - via Yandex.ru")
    public void landingComplexRegisterYA(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidLanding", "androidRegister", "android"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @Description("Registration without gifts from Landing pages 3, 6, 9, 10, 11, 13")
    public void landingFormRegister(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .clickWithdrawFromGift();
            checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidVK"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 11, 13 - via VK.com")
    public void landingFormRegisterVK(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Facebook.com")
    public void landingFormRegisterFB(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 11, 13 - via OK.ru")
    public void landingFormRegisterOK(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidMR"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Mail.ru")
    public void landingFormRegisterMailRU(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Yandex.ru")
    public void landingFormRegisterYA(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidLanding", "androidRegister", "android"})
    @LandingPage(pageNo = {"12"})
    @Description("Registration without gifts from Landing page 12")
    public void landingChooseContRegister(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidVK"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via VK.com")
    public void landingChooseContRegisterVK(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
   @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via Facebook.com")
    public void landingChooseContRegisterFB(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via OK.ru")
    public void landingChooseContRegisterOK(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidMR"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via Mail.ru")
    public void landingChooseContRegisterMailRU(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via Yandex.com")
    public void landingChooseContRegisterYA(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidLanding", "androidRegister", "android"})
    @LandingPage(pageNo = {"7"})
    @Description("Registration without gifts from Landing page 7")
    public void landingChooseRegister(User user, String page) {
        new LandingWithBonus()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidVK"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via VK.com")
    public void landingChooseRegisterVK(User user, String page) {
        new LandingWithBonus()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via FaceBook.com")
    public void landingChooseRegisterFB(User user, String page) {
        new LandingWithBonus()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via OK.ru")
    public void landingChooseRegisterOK(User user, String page) {
        new LandingWithBonus()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidMR"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via Mail.ru")
    public void landingChooseRegisterMailRU(User user, String page) {
        new LandingWithBonus()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via Yandex.ru")
    public void landingChooseRegisterYA(User user, String page) {
        new LandingWithBonus()
                .clickWithDrawFromGift()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidVK"})
    @RemoveUser
    @Description("Social registration without gifts from 'Registration' pop-up - via VK.com")
    public void mainPageRegisterVK(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidMR"})
    @RemoveUser
    @Description("Social registration without gifts from 'Registration' pop-up - via Mail.ru")
    public void mainPageRegisterMailRu(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @RemoveUser
    @Description("Social registration without gifts from 'Registration' pop-up - via OK.ru")
    public void mainPageRegisterOk(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @RemoveUser
    @Description("Social registration without gifts from 'Registration' pop-up - via Yandex.com")
    public void mainPageRegisterYa(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .clickWithdrawFromGift();
        checkHomeMobilePageInNewlyRegisteredState();
    }
}
