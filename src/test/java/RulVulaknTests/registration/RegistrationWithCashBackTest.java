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
 * Registration with '10% cash back' gift
 * + from landings
 * + from registration pop-up
 */

@Listeners({RussianVulcanListener.class})
public class RegistrationWithCashBackTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationWithoutGiftsTest.class);

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    @Description("Registration with '10% cash back' gifts from button 'Register' in header - RUB")
    public void registrationFromHeaderRubCashBack(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTRATION BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    @Description("Registration with '10% cash back' gifts from button 'Register' in header - USD")
    public void registrationFromHeaderUsdCashBack(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyUSD()
                .clickRegisterButton()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTRATION BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"fb"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from 'Register' pop-up - via Facebook")
    public void mainPageRegisterFBCashBack(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @Description("Registration with '10% cash back' gifts from lending pages 1, 2, 4, 5, 14")
    public void landingComplexRegisterCashBack(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk", "D"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 1, 2, 4, 5, 14 - via VK.com")
    public void landingComplexRegisterVKCashBack(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 1, 2, 4, 5, 14 - via Facebook.com")
    public void landingComplexRegisterFBCashBack(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 1, 2, 4, 5, 14 - via OK.ru")
    public void landingComplexRegisterOKCashBack(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton().switchToRegistration().
                clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 1, 2, 4, 5, 14 - via Mail.ru")
    public void landingComplexRegisterMailRUCashBack(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 1, 2, 4, 5, 14 - via Yandex.ru")
    public void landingComplexRegisterYACashBack(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @Description("Registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13")
    public void landingFormRegisterCashBack(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via VK.com")
    public void landingFormRegisterVKCashBack(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Facebook.com")
    public void landingFormRegisterFBCashBack(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via OK.ru")
    public void landingFormRegisterOKCashBack(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Mail.ru")
    public void landingFormRegisterMailRUCashBack(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Yandex.ru")
    public void landingFormRegisterYACashBack(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
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
                .clickRegisterButtonToHome();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
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
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
    @LandingPage(pageNo = {"7"})
    @Description("Registration with '10% cash back' gifts from Landing page 7")
    public void landingChooseRegisterCashBack(User user, String page) {
        new LandingWithBonus()
                .clickCashBack()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
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
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
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
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"register", "social", "vk"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from 'Registration' pop-up - via VK.com")
    public void mainPageRegisterVKCashBack(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"register", "social", "mailru"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from 'Registration' pop-up - via Mail.ru")
    public void mainPageRegisterMailRuCashBack(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"register", "social", "ok"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from 'Registration' pop-up - via OK.ru")
    public void mainPageRegisterOkCashBack(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"register", "social", "ya"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from 'Registration' pop-up - via Yandex.com")
    public void mainPageRegisterYaCashBack(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .checkCashBackGift()
                .clickButtonSaveGift();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAutorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }
}
