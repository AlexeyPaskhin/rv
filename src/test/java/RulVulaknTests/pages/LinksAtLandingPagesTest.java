package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.PreContidions.LandingPage;
import com.listeners.RussianVulcanListener;
import com.pages.*;
import com.pages.landing.LandingChooseBonusWinthContinue;
import com.pages.landing.LandingPageWithLinks;
import com.pages.landing.LandingWithBonus;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Task PROD-6968
 */

@Listeners({RussianVulcanListener.class})
public class LinksAtLandingPagesTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(LinksAtLandingPagesTest.class);

    GamesPage gamesPage;
    LotteriesPage lotteriesPage;
    BonusPage bonusesPage;
    VipPage vipPage;
    ContactsPage contactsPage;
    RulesPage rulesPage;


    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"1", "2", "3", "4", "5", "6", "9"})
    @Description("go To Games Link From Landing Pages")
    public void goToGamesLinkFromLandingPages(User user, String landingPageNumber) {
        gamesPage = new LandingPageWithLinks()
                .clickGames();
        assertTrue(gamesPage.PopularGamesExsits(), "One from key elements of the games page isn't loaded " +
                "at the landing page " + landingPageNumber + ". So the page isn't loaded!");
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"1", "2", "3", "4", "5", "6", "9"})
    @Description("go To Gaminators Link From Landing Pages")
    public void goToGaminatorsLinkFromLandingPages(User user, String landingPageNumber) {
        gamesPage = new LandingPageWithLinks()
                .clickGaminators();
        assertTrue(gamesPage.gaminatorGamesTabIsSelected(), "The gaminators aren't opened!" +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"1", "2", "3", "4", "5", "6", "9"})
    @Description("go T oLotteries Link From Landing Pages")
    public void goToLotteriesLinkFromLandingPages(User user, String landingPageNumber) {
        lotteriesPage = new LandingPageWithLinks()
                .clickLotteries();
        assertTrue(lotteriesPage.lotteriesExists(), "The lotteries page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"1", "2", "3", "4", "5", "6", "9"})
    @Description("go To Bonuses Link From Landing Pages")
    public void goToBonusesLinkFromLandingPages(User user, String landingPageNumber) {
        bonusesPage = new LandingPageWithLinks()
                .clickBonuses();
        assertTrue(bonusesPage.isBonusesPageOpened(), "The bonuses page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"1", "2", "3", "4", "5", "6", "9"})
    @Description("go To Vip Club Link From Landing Pages")
    public void goToVipClubLinkFromLandingPages(User user, String landingPageNumber) {
        vipPage = new LandingPageWithLinks()
                .clickVipClub();
        assertTrue(vipPage.isVipPageLoaded(), "The vip-club page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"1", "2", "4", "5", "6", "9"})
    @Description("go To Contacts Link From Landing Pages")
    public void goToContactsLinkFromLandingPages(User user, String landingPageNumber) {
        contactsPage = new LandingPageWithLinks()
                .clickContacts();
        assertTrue(contactsPage.feedBackBlockIsDisplayed(), "The contacts page isn't opened " +
                "at the landing page " + landingPageNumber);
    }


    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"1", "2", "3", "4", "6", "9", "10", "11", "13", "14", "15"})
    @Description("go To Logo Link From Landing Pages")
    public void goToLogoLinkFromLandingPages(User user, String landingPageNumber) {
        home = new LandingPageWithLinks()
                .clickLogo();
//        assertEquals(home.getTitle(), "Казино Вулкан: официальный сайт Русского Вулкана – казино онлайн");
        assertTrue(home.isNomePageLoaded(), "The home page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"7", "8", "12"})
    @Description("go To Main Page Through Closing Pop Up At Landing Pages")
    public void goToMainPageThroughClosingPopUpAtLandingPages(User user, String landingPageNumber) {
        home = new LandingPageWithLinks()
                .closePopUp();
//        assertEquals(home.getTitle(), "Казино Вулкан: официальный сайт Русского Вулкана – казино онлайн");
        assertTrue(home.isNomePageLoaded(), "The home page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"3", "6", "8", "9", "10", "11", "13"})
    @Description("go To Rules Page Through Unhidden Link At Landing Pages")
    public void goToRulesPageThroughUnhiddenLinkAtLandingPages(User user, String landingPageNumber) {
        rulesPage = new LandingPageWithLinks()
                .clickRulesLinkAndSwitchToItsNewPage();
        assertTrue(rulesPage.isRulesPageLoaded(), "The rules page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"1", "2", "4", "5", "14"})
    @Description("go To Rules Page Through Hidden By Registration Button Link At Landing Pages")
    public void goToRulesPageThroughHiddenByRegistrationButtonLinkAtLandingPages(User user, String landingPageNumber) {
        rulesPage = new LandingPageWithLinks()
                .clickRegisterButton()
                .clickRulesLinkAndSwitchToItsNewPage();
        assertTrue(rulesPage.isRulesPageLoaded(), "The rules page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"7"})
    @Description("go To Rules Page Through Hidden By Choose Gift Button Link At 7 Landing Page")
    public void goToRulesPageThroughHiddenByChooseGiftButtonLinkAt7LandingPage(User user, String landingPageNumber) {
        new LandingWithBonus()
                .clickBonus()
                .switchToRegistration();
        rulesPage = new LandingPageWithLinks()
                .clickRulesLinkAndSwitchToItsNewPage();
        assertTrue(rulesPage.isRulesPageLoaded(), "The rules page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"landing"})
    @LandingPage(pageNo = {"12"})
    @Description("go ToRules Page Through Hidden By Choose Gift Button Link At 12 Landing Page")
    public void goToRulesPageThroughHiddenByChooseGiftButtonLinkAt12LandingPage(User user, String landingPageNumber) {
        new LandingChooseBonusWinthContinue()
                .clickBonus()
                .clickContinue()
                .switchToRegistration();
        rulesPage = new LandingPageWithLinks()
                .clickRulesLinkAndSwitchToItsNewPage();
        assertTrue(rulesPage.isRulesPageLoaded(), "The rules page isn't opened " +
                "at the landing page " + landingPageNumber);
    }

}
