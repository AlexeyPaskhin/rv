package RulVulaknTests.registration;

import RulVulaknTests.BaseTestPage;
import com.Elements.Button;
import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.listeners.RussianVulcanListener;
import com.pages.HomePage;
import com.pages.landing.LandingChooseBonusWinthContinue;
import com.pages.landing.LandingWithBonus;
import com.pages.landing.LandingWithButton;
import com.pages.landing.LandingWithForm;
import com.popups.LotteryPopup;
import com.utils.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

import static com.utils.DriverManager.getDriver;

@Listeners({RussianVulcanListener.class})
public class RegistrationTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationTest.class);

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    public void registrationFromHomePageRub(User user) {
        new HomePage().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTRATION BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    public void registrationFromHomePageUsd(User user) {
        new HomePage().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyUSD()
                .clickRegisterButton()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTRATION BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"fb"})
    @RemoveUser
    public void mainPageRegisterFB(User user) {
        new HomePage().clickRegister()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    public void landingComplexRegister(User user, String page) {
        LandingWithButton lp = new LandingWithButton();
        lp.clickRegisterButton()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk","D"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
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
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
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
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
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
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
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
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"1", "4", "14", "2", "5"})
    @RemoveUser
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
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    public void landingFormRegister(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToGift()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    public void landingFormRegisterVK(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    public void landingFormRegisterFB(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
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
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    public void landingFormRegisterMailRU(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"3", "13", "6", "11", "10", "9"})
    @RemoveUser
    public void landingFormRegisterYA(User user, String page) {
        new LandingWithForm()
                .switchToRegistration()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social"})
    @LandingPage(pageNo = {"12"})
    public void landingChooseContRegister(User user, String page) {
        new LandingChooseBonusWinthContinue()
                .clickCashBack()
                .clickContinue()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    public void landingChooseContRegisterVK(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    public void landingChooseContRegisterFB(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    public void landingChooseContRegisterOK(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    public void landingChooseContRegisterMailRU(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"12"})
    @RemoveUser
    public void landingChooseContRegisterYA(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing", "register"})
    @LandingPage(pageNo = {"7"})
    public void landingChooseRegister(User user, String page) {
        new LandingWithBonus()
                .clickCashBack()
                .switchToRegistration()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .clickRegisterButtonToHome();

        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "vk"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    public void landingChooseRegisterVK(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForFB", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "fb"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    public void landingChooseRegisterFB(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ok"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    public void landingChooseRegisterOK(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "mailru"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    public void landingChooseRegisterMailRU(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"landing", "register", "social", "ya"})
    @LandingPage(pageNo = {"7"})
    @RemoveUser
    public void landingChooseRegisterYA(User user, String page) {
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
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON PAGE " + page);
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, enabled = false)
    public void checkSikuli(User user) throws FindFailed {
        home.clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .selectCurrencyRUB()
                .agreeWithRules()
                .clickRegisterButton()
                .withdrawFromGift();
        getDriver().navigate().to("https://rc-stable.fe.rv.dev.77xy.net/games/singles-day");
        Button b = new Button(By.xpath("//div[@id='popup_out-of-money']//a[@href='/users/playMode/fun']"));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.click();
        Screen sc = new Screen();
        Pattern pt = new Pattern(System.getProperty("user.dir") + File.separator + "Screenshot_5.png");

        Pattern pt1 = new Pattern(System.getProperty("user.dir") + File.separator + "Screenshot_6.png");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sc.click(pt);
        sc.click(pt1);
        try {
            System.out.println("Нажали но походу нихуя не произошло");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "createUserForVK", dataProviderClass = RegisterData.class, groups = {"register", "social", "vk"})
    @RemoveUser
    public void mainPageRegisterVK(User user) {
        new HomePage().clickRegister()
                .clickVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForMailRU", dataProviderClass = RegisterData.class, groups = {"register", "social", "mailru"})
    @RemoveUser
    public void mainPageRegisterMailRu(User user) {
        new HomePage().clickRegister()
                .clickMailRu()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "createUserForOK", dataProviderClass = RegisterData.class, groups = {"register", "social", "ok"})
    @RemoveUser
    public void mainPageRegisterOk(User user) {
        new HomePage().clickRegister()
                .clickOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .setEmail(user.getLogin())
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test (dataProvider = "createUserForYA", dataProviderClass = RegisterData.class, groups = {"register", "social", "ya"})
    @RemoveUser
    public void mainPageRegisterYa(User user) {
        new HomePage().clickRegister()
                .clickYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister()
                .agreeWithRules()
                .clickCompleteRegister()
                .getGiftPopup()
                .withdrawFromGift();
        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }
}
