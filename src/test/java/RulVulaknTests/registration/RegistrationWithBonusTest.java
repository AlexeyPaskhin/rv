package RulVulaknTests.registration;

import RulVulaknTests.BaseTestPage;
import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.landing.LandingChooseBonusWinthContinue;
import com.pages.landing.LandingWithBonus;
import com.pages.landing.LandingWithButton;
import com.pages.landing.LandingWithForm;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Registration with 'Welcome Bonus' gift
 * + from landings
 * + from registration pop-up
 */

@Listeners({RussianVulcanListener.class})
public class RegistrationWithBonusTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationWithoutGiftsTest.class);

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    @Description("Registration with 'Welcome Bonus' gifts from button 'Register' in header - RUB")
    public void registrationFromHeaderRubBonus(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTRATION BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    @Description("Registration with 'Welcome Bonus' gifts from button 'Register' in header - USD")
    public void registrationFromHeaderUsdBonus(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyUSD()
                .clickRegisterButton()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTRATION BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"register","fb"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Register' pop-up - via Facebook")
    public void mainPageRegisterFBBonus(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @Description("Registration with 'Welcome Bonus' gifts from lending pages 1, 2, 4, 5, 14")
    public void landingComplexRegisterBonus(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk", "D"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 1, 2, 4, 5, 14 - via OK.ru")
    public void landingComplexRegisterOKBonus(User user, String page) {
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
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @Description("Registration with 'Welcome Bonus' gifts from Landing pages 3, 6, 9, 10, 11, 13")
    public void landingFormRegisterBonus(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via VK.com")
    public void landingFormRegisterVKBonus(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Facebook.com")
    public void landingFormRegisterFBBonus(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via OK.ru")
    public void landingFormRegisterOKBonus(User user, String page) {
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
                .pressPlayWithBonus();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Mail.ru")
    public void landingFormRegisterMailRUBonus(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Yandex.ru")
    public void landingFormRegisterYABonus(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
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
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
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
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
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
                .pressPlayWithBonus();;
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();;
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
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
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();;
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"register", "social", "vk"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Registration' pop-up - via VK.com")
    public void mainPageRegisterVKBonus(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"register", "social", "mailru"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Registration' pop-up - via Mail.ru")
    public void mainPageRegisterMailRuBonus(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();

        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"register", "social", "ok"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Registration' pop-up - via OK.ru")
    public void mainPageRegisterOkBonus(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"register", "social", "ya"})
    @RemoveUser
    @Description("Social registration with 'Welcome Bonus' gifts from 'Registration' pop-up - via Yandex.com")
    public void mainPageRegisterYaBonus(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();;
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }
}
