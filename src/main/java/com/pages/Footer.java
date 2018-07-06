package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.Panel;
import com.pages.landing.social.*;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * The footer of our site, it's accessible from every page
 */
@Getter
public class Footer extends AbstractPage {
    private Panel FOOTER = new Panel(By.xpath("//div[@class='bottom-content']"));
    private Button FB_GROUP_BUTTON = FOOTER.getSubButtonByXpath("//a[@title='Казино Русский Вулкан в Facebook']");
    private Button TWITTER_GROUP_BUTTON = FOOTER.getSubButtonByXpath("//a[@title='Казино Русский Вулкан в Twitter']");
    private Button OK_GROUP_BUTTON = FOOTER.getSubButtonByXpath("//a[@title='Казино Русский Вулкан в Одноклассниках']");
    private Button VK_GROUP_BUTTON = FOOTER.getSubButtonByXpath("//a[@title='Казино Русский Вулкан в VK']");
    private Button YOUTUBE_GROUP_BUTTON = FOOTER.getSubButtonByXpath("//a[@title='Казино Русский Вулкан на Youtube']");
    private Button GOOGLE_GROUP_BUTTON = FOOTER.getSubButtonByXpath("//a[@title='Казино Русский Вулкан на Google+']");
    private Button INSTAGRAM_GROUP_BUTTON = FOOTER.getSubButtonByXpath("//a[@title='Казино Русский Вулкан в Instagram']");

    private Button VISA_SEO_BUTTON = FOOTER.getSubButtonByXpath("//a[@class='visa']");
    private Button MASTERCARD_BUTTON = FOOTER.getSubButtonByXpath("//a[@class='mastercard']");
    private Button MAESTRO_BUTTON = FOOTER.getSubButtonByXpath("//a[@class='maestro']");
    private Button QIWI_SEO_BUTTON = FOOTER.getSubButtonByXpath("//a[@class='qiwi']");
    private Button YANDEX_DENGI_SEO_BUTTON = FOOTER.getSubButtonByXpath("//a[@class='yam']");
    private Button WEBMONEY_SEO_BUTTON = FOOTER.getSubButtonByXpath("//a[@class='wm']");
    private Button MONETA_SEO_BUTTON = FOOTER.getSubButtonByXpath("//a[@class='moneta']");

    private Button RULES_LINK = FOOTER.getSubButtonByXpath("//span[text()='Правила']/..");
    private Button PAYOUTS_LINK = FOOTER.getSubButtonByXpath("//span[text()='Выплата выигрышей']/..");
    private Button PRIVACY_POLICY_LINK = FOOTER.getSubButtonByXpath("//span[text()='Конфиденциальность']/..");
    private Button BONUSES_LINK = FOOTER.getSubButtonByXpath("//span[text()='Бонусы']/..");
    private Button FAQ_LINK = FOOTER.getSubButtonByXpath("//span[text()='FAQ']/..");
    private Button SITEMAP_LINK = FOOTER.getSubButtonByXpath("//span[text()='Карта сайта']/..");
    private Button FOR_PARTNERS_LINK = FOOTER.getSubButtonByXpath("//span[text()='Партнерам']/..");
    private Button WINNINGS_LINK = FOOTER.getSubButtonByXpath("//span[text()='Выигрыши']/..");
    private Button CONTACTS_LINK = FOOTER.getSubButtonByXpath("//span[text()='Контакты']/..");

    private Button DMCA_LINK = FOOTER.getSubButtonByXpath("//a[@class='dmca-badge']");

    private Button LAST_PUBLICATION_ITEM = FOOTER.getSubButtonByXpath("//ul[@class='publications-bottom__container']");


    @Step
    public FBregisterPage clickFbGroup() {
        FB_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new FBregisterPage();
    }

    @Step
    public TwitterGroupPage clickTwitterGroup() {
        TWITTER_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new TwitterGroupPage();
    }

    @Step
    public OKRegisterPage clickOkGroup() {
        OK_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new OKRegisterPage();
    }

    @Step
    public VkRegisterPage clickVkGroup() {
        VK_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new VkRegisterPage();
    }

    @Step
    public YoutubeGroupPage clickYoutubeGroup() {
        YOUTUBE_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new YoutubeGroupPage();
    }

    @Step
    public GoogleGroupPage clickGoogleGroup() {
        GOOGLE_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new GoogleGroupPage();
    }

    @Step
    public InstagramGroupPage clickInstagramGroup() {
        INSTAGRAM_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new InstagramGroupPage();
    }

    @Step
    public VisaPage clickVisa() {
        VISA_SEO_BUTTON.click();
        return new VisaPage();
    }

    @Step
    public MastercardPage clickMastercardFromHome() {
        MASTERCARD_BUTTON.click();
        switchToSocialFrame();
        return new MastercardPage();
    }

    @Step
    public MastercardSeoPage clickMastercardNOTFromHome() {
        MASTERCARD_BUTTON.click();
        return new MastercardSeoPage();
    }

    @Step
    public MaestroPage clickMaestroPageFromHome() {
        MAESTRO_BUTTON.click();
        switchToSocialFrame();
        return new MaestroPage();
    }

    @Step
    public QiwiPage clickQiwi() {
        QIWI_SEO_BUTTON.click();
        return new QiwiPage();
    }

    @Step
    public YandexDengiPage clickYandexDengi() {
        YANDEX_DENGI_SEO_BUTTON.click();
        return new YandexDengiPage();
    }

    @Step
    public Webmoneypage clickWebmoney() {
        WEBMONEY_SEO_BUTTON.click();
        return new Webmoneypage();
    }

    @Step
    public MonetaPage clickMoneta() {
        MONETA_SEO_BUTTON.click();
        return new MonetaPage();
    }

    @Step
    public RulesPage clickRules() {
        RULES_LINK.click();
        return new RulesPage();
    }

    @Step
    public PayoutsPage clickPayouts() {
        PAYOUTS_LINK.click();
        return new PayoutsPage();
    }

    @Step
    public PrivacyPolicyPage clickPrivacyPolicy() {
        PRIVACY_POLICY_LINK.click();
        return new PrivacyPolicyPage();
    }

    @Step
    public BonusPage clickBonuses() {
        BONUSES_LINK.click();
        return new BonusPage();
    }

    @Step
    public FaqPage clickFaq() {
        FAQ_LINK.click();
        return new FaqPage();
    }

    @Step
    public SitemapPage clickSitemap() {
        SITEMAP_LINK.click();
        return new SitemapPage();
    }

    @Step
    public ForPartnersPage clickForPartners() {
        FOR_PARTNERS_LINK.click();
        switchToSocialFrame();
        return new ForPartnersPage();
    }

    @Step
    public WinningsPage clickWinnings() {
        WINNINGS_LINK.click();
        return new WinningsPage();
    }

    @Step
    public ContactsPage clickContacts() {
        CONTACTS_LINK.click();
        return new ContactsPage();
    }

    @Step
    public DmcaPage clickDMCA() {
        DMCA_LINK.click();
        return new DmcaPage();
    }

    @Step
    public List<Element> checkPublicationLinks() {
        List<Element> brokenLinks = new ArrayList<>();
        for (Element link : LAST_PUBLICATION_ITEM.getSubElementsByXpath("/li/a")) {
            link.click();
            if (!getTitle().equals(link.getText())) {
                brokenLinks.add(link);
            }
            goBack();
        }
        return brokenLinks;
    }

}
