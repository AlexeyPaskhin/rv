package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.InputBox;
import com.Elements.Panel;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

@Getter
public class GamesPage extends AbstractPage {
    public Panel POPULAR_GAMES = new Panel(By.xpath("//div[@data-tab-id='popular']/div[@class='games-block']"));
    public Panel NEW_GAMES = new Panel(By.xpath("//div[@data-tab-id='new']/div[@class='games-block']"));
    public Panel GAMINATOR_GAMES = new Panel(By.xpath("//div[@data-tab-id='Gaminator']/div[@class='games-block']"));
    public Panel IGROSOFT_GAMES = new Panel(By.xpath("//div[@data-tab-id='Igrosoft']/div[@class='games-block']"));
    public Panel TABLES_GAMES = new Panel(By.xpath("//div[@data-tab-id='stoly']/div[@class='games-block']"));
    private final Panel SLOTS_GAMES = new Panel(By.xpath("//div[@data-tab-id='other']/div[@class='games-block']"));
    private final Button POPULAR_GAME = POPULAR_GAMES.getButtonByXpath("//a[contains(@class,'item item-popular')]");

    private final Button FIRST_GAME = POPULAR_GAMES.getButtonByXpath("//a[@href='/games/15-golden-eggs']");
    private Button POPULAR_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#popular']"));
    private Button NEW_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#new']"));
    private Button GAMINATOR_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#Gaminator']"));
    private Button IGROSOFT_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#Igrosoft']"));
    private Button TABLES_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#stoly']"));
    private Button PRODUCERS_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//label[@class='games-filter__item-opener']"));

    public Element GAME_VISIBLE_ITEM = new Element(By.xpath("//div[@style='display: block;']//a[@data-search-keywords]"));
    public Element GAME_ANY_ITEM = new Element(By.xpath("//a[@data-search-keywords]"));  //even not displayed currently item
    private InputBox SEARCH_BOX = new InputBox(By.xpath("//input[@name='q']"));
    private Button FIND_BUTTON = new Button(By.xpath("//button[@class='find']"));
    public Button POPULAR_GAMES_AT_FAILED_SEARCH_BLOCK = new Button(By.xpath("//span[text()='Популярные игры']/.."));
    public Button ALL_GAMES_AT_FAILED_SEARCH_BLOCK = new Button(By.xpath("//span[text()='Все игры']/.."));

    public Panel PRODUCERS_PANEL = new Panel(By.xpath("//ul[@class='games-filter__submenu-container']"));
    public Button ARISTOCRAT_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Aristocrat']"));
    public Button BELATRA_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Belatra']"));
    public Button BOOONGO_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Booongo']"));
    public Button GAMINATOR_PROD_FILTER_BUTTON = new Button(By.xpath("//li[@class='games-filter__submenu-item']/a[@href='/games#Gaminator']"));
    public Button GLOBOTECH_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=GloboTech']"));
    public Button IGROSOFT_PROD_FILTER_BUTTON = new Button(By.xpath("//li[@class='games-filter__submenu-item']/a[@href='/games#Igrosoft']"));
    public Button MEGAJACK_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Megajack']"));
    public Button NETENT_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=NetEnt']"));
    public Button PLAYSON_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Playson']"));
    public Button PLAYTECH_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Playtech']"));
    public Button OTHERS_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=drugie']"));

    private Panel MY_GAMES;
    // private final Panel TEXT_BLOCK= new Panel(By.xpath("//div[@data-tab-id='popular']/div[@class='games-block']"));

    @Step
    public GamesPage doSearch(String keyword) {
        SEARCH_BOX.cleaIn();
        SEARCH_BOX.fillIn(keyword);
        FIND_BUTTON.click();
        return this;
    }

    @Step
    public Boolean gaminatorGamesTabIsSelected() {
        return GAMINATOR_GAMES.isVisible();
    }

    @Step
    public List<Button> getAllPopularGames() {
        return POPULAR_GAME.getAllElements();
    }

    @Step
    public boolean PopularGamesExsits() {
//        POPULAR_GAMES.waitForElementToBePresent(3);
        return POPULAR_GAMES.isPresent();
    }

    @Step
    public boolean NewGamesExists() {
        NEW_GAMES.waitForElementToBePresent(3);
        return NEW_GAMES.isPresent();
    }

    @Step
    public boolean GaminatorGamesExists() {
        GAMINATOR_GAMES.waitForElementToBePresent(3);
        return GAMINATOR_GAMES.isPresent();
    }

    @Step
    public boolean IgrosoftGamesExists() {
        IGROSOFT_GAMES.waitForElementToBePresent(3);
        return IGROSOFT_GAMES.isPresent();
    }

    @Step
    public boolean TablesGamesExists() {
        TABLES_GAMES.waitForElementToBePresent(3);
        return TABLES_GAMES.isPresent();
    }

    @Step
    public boolean SlotGamesExists() {
        SLOTS_GAMES.waitForElementToBePresent(3);
        return SLOTS_GAMES.isPresent();
    }

    @Step
    public GamesPage clickPopularGamesAtFailedSearchBlock() {
        POPULAR_GAMES_AT_FAILED_SEARCH_BLOCK.click();
        return this;
    }

    @Step
    public GamesPage clickAllGamesAtFailedSearchBlock() {
        ALL_GAMES_AT_FAILED_SEARCH_BLOCK.click();
        return this;
    }

    @Step
    public GamesPage clickPopularGamesFilter() {
        POPULAR_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickNewGamesFilter() {
        NEW_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickGaminatorGamesFilter() {
        GAMINATOR_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickIgrosoftGamesFilter() {
        IGROSOFT_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickTablesGamesFilter() {
        TABLES_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickPRoducersFilter() {
        PRODUCERS_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickAristocratProducer() {
        ARISTOCRAT_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickBelatraProducer() {
        BELATRA_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickBooongoProducer() {
        BOOONGO_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickGaminatorProducer() {
        GAMINATOR_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickGloboTechProducer() {
        GLOBOTECH_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickIgrosoftProducer() {
        IGROSOFT_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickMegajackProducer() {
        MEGAJACK_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickNetEntProducer() {
        NETENT_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickPlaysonProducer() {
        PLAYSON_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickPlaytechProducer() {
        PLAYTECH_PROD_FILTER_BUTTON.click();
        return this;
    }

    public GamesPage clickOthersProducer() {
        OTHERS_PROD_FILTER_BUTTON.click();
        return this;
    }
}
