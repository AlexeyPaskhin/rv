package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import com.Elements.Element;
import com.listeners.RussianVulcanListener;
import com.pages.*;
import com.pages.landing.social.*;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class FooterTest extends BaseTestPage {

    @Test(dataProvider = "authorizationUserForFB", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("go To Our Fb Group via footer")
    public void goToOurFbGroup(User user) {
        SocialFrame socialFrame = home.getFooter()
                .clickFbGroup()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickLogIn();
        assertEquals(socialFrame.getURL(), customDataProvider.getFbGroupURL());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Twitter Group via footer")
    public void goToOurTwitterGroup() {
        TwitterGroupPage twitterGroupPage = home.getFooter()
                .clickTwitterGroup();
        assertEquals(twitterGroupPage.getURL(), customDataProvider.getTwitterGroupURL());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Ok Group via footer")
    public void goToOurOkGroup() {
        OKRegisterPage okRegisterPage = home.getFooter()
                .clickOkGroup();
        assertEquals(okRegisterPage.getURL(), customDataProvider.getOkGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Vk Group via footer")
    public void goToOurVkGroup() {
        VkRegisterPage vkRegisterPage = home.getFooter()
                .clickVkGroup();
        assertEquals(vkRegisterPage.getURL(), customDataProvider.getVkGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Youtube Group via footer")
    public void goToOurYoutubeGroup() {
        YoutubeGroupPage youtubeGroupPage = home.getFooter()
                .clickYoutubeGroup();
        assertEquals(youtubeGroupPage.getURL(), customDataProvider.getYoutubeGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Google Group via footer")
    public void goToOurGoogleGroup() {
        GoogleGroupPage googleGroupPage = home.getFooter()
                .clickGoogleGroup();
        assertEquals(googleGroupPage.getURL(), customDataProvider.getGoogleGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Instagram Group via footer")
    public void goToOurInstagramGroup() {
        InstagramGroupPage instagramGroupPage = home.getFooter()
                .clickInstagramGroup();
        assertEquals(instagramGroupPage.getURL(), customDataProvider.getInstagramGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our visa page via footer")
    public void goToVisaPage() {
        VisaPage visaPage = home.getFooter()
                .clickVisa();
        assertEquals(visaPage.getURL(), customDataProvider.getBasicURL() + "visa");
    }

    @Test(groups = {"regression"})
    @Description("go To Mastercard page via footer at home page")
    public void goToMastercardPageFromHome() {
        MastercardPage mastercardPage = home.getFooter()
                .clickMastercardFromHome();
        assertTrue(mastercardPage.getURL().contains("https://www.mastercard."));
    }

    @Test(groups = {"regression"})
    @Description("go To Mastercard page via footer NOT from home page")
    public void goToMastercardPageNOTFromHome() {
        MastercardSeoPage mastercardSeoPage = home.getHeader()
                .clickContactsLink()
                .getFooter()
                .clickMastercardNOTFromHome();
        assertEquals(mastercardSeoPage.getURL(), customDataProvider.getBasicURL() + "mastercard");
    }

    @Test(groups = {"regression"})
    @Description("go To Mastercard page via footer at home page")
    public void goToMaestroFromHome() {
        MaestroPage mestroPage = home.getFooter()
                .clickMaestroPageFromHome();
        assertTrue(mestroPage.getURL().contains("http://www.maestrocard.com"));
    }

    @Test(groups = {"regression"})
    @Description("go To Qiwi page via footer")
    public void goToQiwiPage() {
        QiwiPage qiwiPage = home.getFooter()
                .clickQiwi();
        assertEquals(qiwiPage.getURL(), customDataProvider.getBasicURL() + "qiwi");
    }

    @Test(groups = {"regression"})
    @Description("go To Yandex-dengi page via footer")
    public void goToYandexDengiPage() {
        YandexDengiPage yandexDengiPage = home.getFooter()
                .clickYandexDengi();
        assertEquals(yandexDengiPage.getURL(), customDataProvider.getBasicURL() + "yandex-dengi");
    }

    @Test(groups = {"regression"})
    @Description("go To Webmoney page via footer")
    public void goToWebmoneyPage() {
        Webmoneypage webmoneypage = home.getFooter()
                .clickWebmoney();
        assertEquals(webmoneypage.getURL(), customDataProvider.getBasicURL() + "webmoney");
    }

    @Test(groups = {"regression"})
    @Description("go To Moneta-ru page via footer")
    public void goToMonetaPage() {
        MonetaPage monetaPage = home.getFooter()
                .clickMoneta();
        assertEquals(monetaPage.getURL(), customDataProvider.getBasicURL() + "moneta-ru");
    }

    @Test(groups = {"regression"})
    @Description("go To Rules page via footer")
    public void goToRulesPage() {
        RulesPage rulesPage = home.getFooter()
                .clickRules();
        assertTrue(rulesPage.isRulesPageLoaded());
    }

    @Test(groups = {"regression"})
    @Description("go To Payouts page via footer")
    public void goToPayoutsPage() {
        PayoutsPage payoutsPage = home.getFooter()
                .clickPayouts();
        assertTrue(payoutsPage.isLoaded());
    }

    @Test(groups = {"regression"})
    @Description("go To Privacy Policy page via footer")
    public void goToPrivacyPolicyPage() {
        PrivacyPolicyPage privacyPolicyPage = home.getFooter()
                .clickPrivacyPolicy();
        assertTrue(privacyPolicyPage.isLoaded());
    }

    @Test(groups = {"regression"})
    @Description("go To Bonuses page via footer")
    public void goToBonusesPage() {
        BonusPage bonusPage = home.getFooter()
                .clickBonuses();
        assertTrue(bonusPage.isOpened());
    }

    @Test(groups = {"regression"})
    @Description("go To FAQ page via footer")
    public void goToFaqPage() {
        FaqPage faqPage = home.getFooter()
                .clickFaq();
        assertTrue(faqPage.isLoaded());
    }

    @Test(groups = {"regression"})
    @Description("go To sitemap page via footer")
    public void goToSitemapPage() {
        SitemapPage sitemapPage = home.getFooter()
                .clickSitemap();
        assertTrue(sitemapPage.isLoaded());
    }

    @Test(groups = {"regression"})
    @Description("go To For-partners page via footer")
    public void goToForPartnersPage() {
        ForPartnersPage forPartnersPage = home.getFooter()
                .clickForPartners();
        assertTrue(forPartnersPage.isLoaded());
    }

    @Test(groups = {"regression"})
    @Description("go To Winnings page via footer")
    public void goToWinningsPage() {
        WinningsPage winningsPage = home.getFooter()
                .clickWinnings();
        assertTrue(winningsPage.isLoaded());
    }

    @Test(groups = {"regression"})
    @Description("go To Contacts page via footer")
    public void goToContactsPage() {
        ContactsPage contactsPage = home.getFooter()
                .clickContacts();
        assertTrue(contactsPage.feedBackBlockIsDisplayed());
    }

    @Test(groups = {"regression"})
    @Description("go To DMCA page via footer")
    public void goToDMCAPage() {
        DmcaPage dmcaPage = home.getFooter()
                .clickDMCA();
        assertTrue(dmcaPage.isLoaded());
    }

    @Test(groups = {"regression"})
    @Description("go To Last Publications Pages")
    public void goToLastPublicationsPages() {
        List<Element> brokenPublications = home.getFooter()
                .checkPublicationLinks();
        if (brokenPublications.size() > 0) {
            StringBuilder failMessage = new StringBuilder();
            for (Element el : brokenPublications) {
                failMessage.append("Publication ").append(el.getBy()).append(" is broken. \n");
            }
            fail(String.valueOf(failMessage));
        }
    }

}
