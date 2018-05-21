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

    Button GAMES = new Button(By.xpath("//a[@href='/games']"));
    Button gaminators = new Button(By.xpath("//a[@href='/games#Gaminator']"));
    Button LOTTERIES = new Button(By.xpath("//a[@href='/lotteries']"));
//    Button TOURNAMENTS = new Button(By.xpath("//a[@href='/tournaments']"));
    Button bonuses = new Button(By.xpath("//a[@href='/bonus']"));
//    Button NEWS = new Button(By.xpath("//a[@href='/news']"));
    Button VIP_CLUB = new Button(By.xpath("//a[@href='/vip']"));
    Button contacts = new Button(By.xpath("//a[@href='/contacts']"));
    Button logo = new Button(By.xpath("//a[@href='/']"));
    WebElement closePopUpButton;
    WebElement rulesLink;
    private Button REGISTER_BUTTON = new Button(By.xpath("//a[@href='/users/register']"));




    @Step
    public GamesPage clickGames() {
        GAMES.click();
        return new GamesPage();
    }

    @Step
    public GamesPage clickGaminators() {
        gaminators.click();
        return new GamesPage();
    }

    @Step
    public LotteriesPage clickLotteries() {
        LOTTERIES.click();
        return new LotteriesPage();
    }

    @Step
    public BonusPage clickBonuses() {
        bonuses.click();
        return new BonusPage();
    }

    @Step
    public VipPage clickVipClub() {
        VIP_CLUB.click();
        return new VipPage();
    }

    @Step
    public ContactsPage clickContacts() {
        contacts.click();
        return new ContactsPage();
    }

    @Step
    public HomePage clickLogo() {
        logo.click();
        return new HomePage();
    }

    @Step
    public HomePage closePopUp() {
        closePopUpButton = getAllVisibleElements("//a[@href='#']").get(0);
        closePopUpButton.click();
        return new HomePage();
    }

    @Step
    public RulesPage clickRulesLinkAndSwitchToItsNewPage() {
        rulesLink = getAllVisibleElements(rulesLinkLocator).get(0);
        Set<String> windowHandles = getDriver().getWindowHandles();
        rulesLink.click();
        switchToNewlyOpenedWindow(windowHandles);
        return new RulesPage();
    }

    @Step
    public LandingPageWithLinks clickRegisterButton() {
        REGISTER_BUTTON.click();
        waitForElementToBeVisible("//div[@class='popup landing']");
        return this;
    }
}
