package RulVulaknTests.registration.mobile;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.pages.landing.LandingChooseBonusWinthContinue;
import com.pages.landing.LandingWithBonus;
import com.pages.landing.LandingWithButton;
import com.pages.landing.LandingWithForm;
import com.pages.mobile.HomeMobilePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegistrationWithBonusMobileTest extends BaseTestPage {

    private void checkHomeMobilePageInNewlyRegisteredState() {
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
        assertTrue(homeMobilePage.firstBonusPanelIsPresent(), "Bonus panel isn't displayed");
    }

    private void checkHomeMobilePageInNewlyRegisteredStateFromLP(String pageNumber) {
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT ON PAGE " + pageNumber);
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED ON PAGE " + pageNumber);
        assertTrue(homeMobilePage.firstBonusPanelIsPresent(), "Bonus panel isn't displayed on page " + pageNumber);
    }

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
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidFB"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Register' pop-up - via Facebook")
    public void mainPageRegisterFBBonus(User user) {
        new HomeMobilePage()
                .clickRegister()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidVK"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Register' pop-up - via VK.com")
    public void mainPageRegisterVKBonus(User user) {
        new HomeMobilePage()
                .clickRegister()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForMailRUAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidMR"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Register' pop-up - via Mail.ru")
    public void mainPageRegisterMailRuBonus(User user) {
        new HomeMobilePage()
                .clickRegister()
                .clickMR()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidOK"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Register' pop-up - via OK.ru")
    public void mainPageRegisterOkBonus(User user) {
        new HomeMobilePage()
                .clickRegister()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .setEmail(user.getLogin())
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidYA"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Register' pop-up - via Yandex.com")
    public void mainPageRegisterYaBonus(User user) {
        new HomeMobilePage()
                .clickRegister()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegisterMobile()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredState();
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @Description("Registration with 'Welcome Bonus' gifts from landing pages 1, 2, 4, 5, 14")
    public void landingComplexRegisterBonus(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidVK"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 1, 2, 4, 5, 14 - via VK.com")
    public void landingComplexRegisterVKBonus(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
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

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidFB"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 1, 2, 4, 5, 14 - via Facebook.com")
    public void landingComplexRegisterFBBonus(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
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

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidOK"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 1, 2, 4, 5, 14 - via OK.ru")
    public void landingComplexRegisterOKBonus(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton().switchToRegistration().
                clickOK()
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
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 1, 2, 4, 5, 14 - via Mail.ru")
    public void landingComplexRegisterMailRUBonus(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
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

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 1, 2, 4, 5, 14 - via Yandex.ru")
    public void landingComplexRegisterYABonus(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
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
    @LandingPage(pageNo = {"11"})
    @Description("Registration with 'Bonus' gifts from Landing page 11")
    public void landingFormRegisterBonus(User user, String page) {
        new LandingWithForm()
                .clickBonusLP11()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidVK"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 11 - via VK.com")
    public void landingFormRegisterVKBonus(User user, String page) {
        new LandingWithForm()
                .clickBonusLP11()
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

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidFB"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 11 - via Facebook.com")
    public void landingFormRegisterFBBonus(User user, String page) {
        new LandingWithForm()
                .clickBonusLP11()
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

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidOK"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 11 - via OK.ru")
    public void landingFormRegisterOKBonus(User user, String page) {
        new LandingWithForm()
                .clickBonusLP11()
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
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 11 - via Mail.ru")
    public void landingFormRegisterMailRUBonus(User user, String page) {
        new LandingWithForm()
                .clickBonusLP11()
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

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 11 - via Yandex.ru")
    public void landingFormRegisterYABonus(User user, String page) {
        new LandingWithForm()
                .clickBonusLP11()
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
    @Description("Registration with 'Welcome Bonus' gifts from Landing page 12")
    public void landingChooseContRegisterBonus(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickBonus()
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

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidVK"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 12 - via VK.com")
    public void landingChooseContRegisterVKBonus(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickBonus()
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

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidFB"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 12 - via Facebook.com")
    public void landingChooseContRegisterFBBonus(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickBonus()
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

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidOK"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 12 - via OK.ru")
    public void landingChooseContRegisterOKBonus(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickBonus()
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
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 12 - via Mail.ru")
    public void landingChooseContRegisterMailRUBonus(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickBonus()
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
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 12 - via Yandex.com")
    public void landingChooseContRegisterYABonus(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickBonus()
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
    @Description("Registration with 'Welcome Bonus' gifts from Landing page 7")
    public void landingChooseRegisterBonus(User user, String page) {
        new LandingWithBonus()
                .clickBonus()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidVK"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 7 - via VK.com")
    public void landingChooseRegisterVKBonus(User user, String page) {
        new LandingWithBonus()
                .clickBonus()
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

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidFB"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 7 - via FaceBook.com")
    public void landingChooseRegisterFBBonus(User user, String page) {
        new LandingWithBonus()
                .clickBonus()
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

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidOK"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 7 - via OK.ru")
    public void landingChooseRegisterOKBonus(User user, String page) {
        new LandingWithBonus()
                .clickBonus()
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
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 7 - via Mail.ru")
    public void landingChooseRegisterMailRUBonus(User user, String page) {
        new LandingWithBonus()
                .clickBonus()
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
    @Description("Social registration with 'Welcome Bonus' gifts from Landing page 7 - via Yandex.ru")
    public void landingChooseRegisterYABonus(User user, String page) {
        new LandingWithBonus()
                .clickBonus()
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
    @LandingPage(pageNo = {"3", "13", "6", "10", "9"})
    @Description("Registration without gifts from Landing pages 3, 6, 9, 10, 13")
    public void landingFormRegister(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .pressPlayWithBonus();
        checkHomeMobilePageInNewlyRegisteredStateFromLP(page);
    }

    @Test(dataProvider = "createUserForVKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidVK"})
    @LandingPage(pageNo = {"3", "13", "6", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 13 - via VK.com")
    public void landingFormRegisterVK(User user, String page) {
        new LandingWithForm()
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

    @Test(dataProvider = "createUserForFBAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidFB"})
    @LandingPage(pageNo = {"3", "13", "6", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 13 - via Facebook.com")
    public void landingFormRegisterFB(User user, String page) {
        new LandingWithForm()
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

    @Test(dataProvider = "createUserForOKAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidOK"})
    @LandingPage(pageNo = {"3", "13", "6", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 13 - via OK.ru")
    public void landingFormRegisterOK(User user, String page) {
        new LandingWithForm()
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
    @LandingPage(pageNo = {"3", "13", "6", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 13 - via Mail.ru")
    public void landingFormRegisterMailRU(User user, String page) {
        new LandingWithForm()
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

    @Test(dataProvider = "createUserForYAAndroid", dataProviderClass = RegisterData.class, groups = {"androidRegister", "android", "androidLanding", "androidYA"})
    @LandingPage(pageNo = {"3", "13", "6", "10", "9"})
    @RemoveUser
    @Description("Social registration without gifts from Landing pages 3, 6, 9, 10, 13 - via Yandex.ru")
    public void landingFormRegisterYA(User user, String page) {
        new LandingWithForm()
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

}
