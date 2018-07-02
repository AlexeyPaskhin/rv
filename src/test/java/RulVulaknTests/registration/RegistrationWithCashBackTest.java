package RulVulaknTests.registration;

import RulVulaknTests.BaseTestPage;
import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.listeners.RussianVulcanListener;
import com.pages.landing.LandingChooseBonusWinthContinue;
import com.pages.landing.LandingWithBonus;
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
 * + from landings (if user choose '10% Cashback' bonus - he should choose bonus after registration)
 */

@Listeners({RussianVulcanListener.class})
public class RegistrationWithCashBackTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationWithoutGiftsTest.class);

    // TODO: 2018-05-07 Add cheking CASH BACK logic to LP

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
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
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 11 - via VK.com")
    public void landingFormRegisterVKCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
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
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Facebook.com")
    public void landingFormRegisterFBCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
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
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via OK.ru")
    public void landingFormRegisterOKCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
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
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Mail.ru")
    public void landingFormRegisterMailRUCashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
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
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"11"})
    @RemoveUser
    @Description("Social registration with '10% cash back' gifts from Landing pages 3, 6, 9, 10, 11, 13 - via Yandex.ru")
    public void landingFormRegisterYACashBack(User user, String page) {
        new LandingWithForm()
                .clickCashBackLP11()
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
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickRegisterButtonToHome()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickRegisterButtonToHome()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
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
                .clickCompleteRegister()
                .getWelcomeBonusGiftPopup()
                .pressPlayWithBonus();
        try {
            Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
            Assert.assertTrue(headerAuthorizedUser.giftIconIsPresent(), "GIFT ICON IS NOT PRESENT");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }
}
