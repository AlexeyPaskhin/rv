package RulVulaknTests.registration;

import RulVulaknTests.BaseTestPage;
import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.landing.*;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Registration without gifts
 * + from landings
 * + from registration pop-up
 */

@Listeners({RussianVulcanListener.class})
public class RegistrationWithoutGiftsTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationWithoutGiftsTest.class);

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"plainRegAuth"})
    @Description("Registration without gifts from button 'Register' in header - RUB")
    public void registrationFromHeaderRub(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .clickWithdrawFromGift();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTRATION BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"plainRegAuth"})
    @Description("Registration without gifts from button 'Register' in header - USD")
    public void registrationFromHeaderUsd(User user) {
        new HeaderNotAutorizedUser().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyUSD()
                .clickRegisterButton()
                .clickWithdrawFromGift();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTRATION BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"fb"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk", "D"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "plainRegAuth"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "plainRegAuth"})
    @LandingPage(pageNo = {"12"})
    @Description("Registration without gifts from Landing page 12")
    public void landingChooseContRegister(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickGiveUpAGift()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via VK.com")
    public void landingChooseContRegisterVK(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via Facebook.com")
    public void landingChooseContRegisterFB(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via OK.ru")
    public void landingChooseContRegisterOK(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via Mail.ru")
    public void landingChooseContRegisterMailRU(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 12 - via Yandex.com")
    public void landingChooseContRegisterYA(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "plainRegAuth"})
    @LandingPage(pageNo = {"7"})
    @Description("Registration without gifts from Landing page 7")
    public void landingChooseRegister(User user, String page) {
        new LandingWithBonus()
                .clickGiveUpAGift()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via VK.com")
    public void landingChooseRegisterVK(User user, String page) {
        new LandingWithBonus()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via FaceBook.com")
    public void landingChooseRegisterFB(User user, String page) {
        new LandingWithBonus()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via OK.ru")
    public void landingChooseRegisterOK(User user, String page) {
        new LandingWithBonus()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via Mail.ru")
    public void landingChooseRegisterMailRU(User user, String page) {
        new LandingWithBonus()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    @Description("Social registration without gifts from Landing page 7 - via Yandex.ru")
    public void landingChooseRegisterYA(User user, String page) {
        new LandingWithBonus()
                .clickGiveUpAGift()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"register", "social", "vk"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"register", "social", "mailru"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"register", "social", "ok"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"register", "social", "ya"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertFalse(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

}
