package RulVulaknTests.registration.mobile;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.pages.landing.LandingChooseBonusWinthContinue;
import com.pages.landing.LandingWithBonus;
import com.pages.landing.LandingWithForm;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegistrationWithCashBackMobileTest extends BaseTestPage {

    private void checkHomeMobilePageInNewlyRegisteredStateFromLP(String pageNumber) {
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT ON PAGE " + pageNumber);
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED ON PAGE " + pageNumber);
        assertTrue(homeMobilePage.firstBonusPanelIsPresent(), "Bonus panel isn't displayed on page " + pageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidLanding", "androidRegister", "android"})
    @LandingPage(pageNo = {"11"})
    @Description("Registration with '10% cash back' gifts from Landing page 11")
    public void landingFormRegisterCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidVK"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 11 - via VK.com")
    public void landingFormRegisterVKCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 11 - via Facebook.com")
    public void landingFormRegisterFBCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 11 - via OK.ru")
    public void landingFormRegisterOKCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .setEmail(user.getLogin())
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidMR"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 11 - via Mail.ru")
    public void landingFormRegisterMailRUCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "androidSmoke", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 11 - via Yandex.ru")
    public void landingFormRegisterYACashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
       checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidLanding", "androidRegister", "android"})
    @LandingPage(pageNo = {"12"})
    @Description("Registration with '10% cash back' gifts from Landing page 12")
    public void landingChooseContRegisterCashBack(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickCashBack()
                .clickContinue()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "androidSmoke", "androidVK"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 12 - via VK.com")
    public void landingChooseContRegisterVKCashBack(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickCashBack()
                .clickContinue()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 12 - via Facebook.com")
    public void landingChooseContRegisterFBCashBack(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickCashBack()
                .clickContinue()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 12 - via OK.ru")
    public void landingChooseContRegisterOKCashBack(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickCashBack()
                .clickContinue()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidMR"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 12 - via Mail.ru")
    public void landingChooseContRegisterMailRUCashBack(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickCashBack()
                .clickContinue()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 12 - via Yandex.com")
    public void landingChooseContRegisterYACashBack(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickCashBack()
                .clickContinue()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
     checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidLanding", "androidRegister", "android"})
    @LandingPage(pageNo = {"7"})
    @Description("Registration with '10% cash back' gifts from Landing page 7")
    public void landingChooseRegisterCashBack(User user, String page) {
        new LandingWithBonus()
                .clickCashBack()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidVK"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 7 - via VK.com")
    public void landingChooseRegisterVKCashBack(User user, String page) {
        new LandingWithBonus()
                .clickCashBack()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 7 - via FaceBook.com")
    public void landingChooseRegisterFBCashBack(User user, String page) {
        new LandingWithBonus()
                .clickCashBack()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 7 - via OK.ru")
    public void landingChooseRegisterOKCashBack(User user, String page) {
        new LandingWithBonus()
                .clickCashBack()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidMR"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 7 - via Mail.ru")
    public void landingChooseRegisterMailRUCashBack(User user, String page) {
        new LandingWithBonus()
                .clickCashBack()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing page 7 - via Yandex.ru")
    public void landingChooseRegisterYACashBack(User user, String page) {
        new LandingWithBonus()
                .clickCashBack()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
      checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

}
