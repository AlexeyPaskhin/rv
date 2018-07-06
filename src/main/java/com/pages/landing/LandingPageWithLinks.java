package com.pages.landing;

import com.Elements.Button;
import com.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static com.utils.DriverManager.getDriver;

public class LandingPageWithLinks extends AbstractPage {
    public static final String rulesLinkLocator = "//a[@href='/rules']";
    public static final String closePopUpButtonLocator = "//a[@href='#']";

    Button GAMES = new Button(By.xpath("//a[@href='/games']"));
    Button GAMINATORS = new Button(By.xpath("//a[@href='/games#Gaminator']"));
    Button LOTTERIES = new Button(By.xpath("//a[@href='/lotteries']"));
//    Button TOURNAMENTS = new Button(By.xpath("//a[@href='/tournaments']"));
    Button BONUSES = new Button(By.xpath("//a[@href='/bonus']"));
//    Button NEWS = new Button(By.xpath("//a[@href='/news']"));
    Button VIP_CLUB = new Button(By.xpath("//a[@href='/vip']"));
    Button CONTACTS = new Button(By.xpath("//a[@href='/contacts']"));
    Button LOGO = new Button(By.xpath("//a[@href='/']"));
    WebElement CLOSE_POP_UP_BUTTON;
    WebElement RULES_LINK;
    private Button REGISTER_BUTTON = new Button(By.xpath("//a[@href='/users/register']"));




    @Step
    public GamesPage clickGames() {
        GAMES.click();
        return new GamesPage();
    }

    @Step
    public GamesPage clickGaminators() {
        GAMINATORS.click();
        return new GamesPage();
    }

    @Step
    public LotteriesPage clickLotteries() {
        LOTTERIES.click();
        return new LotteriesPage();
    }

    @Step
    public BonusPage clickBonuses() {
        BONUSES.click();
        return new BonusPage();
    }

    @Step
    public VipPage clickVipClub() {
        VIP_CLUB.click();
        return new VipPage();
    }

    @Step
    public ContactsPage clickContacts() {
        CONTACTS.click();
        return new ContactsPage();
    }

    @Step
    public HomePage clickLogo() {
        LOGO.click();
        return new HomePage();
    }

    @Step
    public HomePage closePopUp() {
        CLOSE_POP_UP_BUTTON = getAllVisibleElements(closePopUpButtonLocator).get(0);
        CLOSE_POP_UP_BUTTON.click();
        return new HomePage();
    }

    @Step
    public RulesPage clickRulesLinkAndSwitchToItsNewPage() {
        RULES_LINK = getAllVisibleElements(rulesLinkLocator).get(0);
        Set<String> oldWindowHandles = getDriver().getWindowHandles();
        RULES_LINK.click();
        switchToNewlyOpenedWindow(oldWindowHandles);
        return new RulesPage();
    }

    @Step
    public LandingPageWithLinks clickRegisterButton() {
        REGISTER_BUTTON.click();
        waitForElementToBeVisible("//div[@class='popup landing']");
        return this;
    }
}
