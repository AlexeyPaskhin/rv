package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.InputBox;
import com.Elements.Panel;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.utils.RandomGenerate;
import io.qameta.allure.Step;
import lombok.Getter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

@Getter
public class GamesPage extends AbstractPage {
    private final static Logger logger = LogManager.getLogger(GamesPage.class);

    private Panel POPULAR_GAMES = new Panel(By.xpath("//div[@data-tab-id='popular']/div[@class='games-block']"));
    private Panel NEW_GAMES = new Panel(By.xpath("//div[@data-tab-id='new']/div[@class='games-block']"));
    private Panel GAMINATOR_GAMES = new Panel(By.xpath("//div[@data-tab-id='Gaminator']/div[@class='games-block']"));
    private Panel IGROSOFT_GAMES = new Panel(By.xpath("//div[@data-tab-id='Igrosoft']/div[@class='games-block']"));
    private Panel TABLES_GAMES = new Panel(By.xpath("//div[@data-tab-id='stoly']/div[@class='games-block']"));
    private final Panel SLOTS_GAMES = new Panel(By.xpath("//div[@data-tab-id='other']/div[@class='games-block']"));
    private final Button POPULAR_GAME = POPULAR_GAMES.getButtonByXpath("//a[contains(@class,'item item-popular')]");

    private final Button FIRST_GAME = POPULAR_GAMES.getButtonByXpath("//a[@href='/games/15-golden-eggs']");
    private Button POPULAR_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#popular']"));
    private Button NEW_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#new']"));
    private Button GAMINATOR_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#Gaminator']"));
    private Button IGROSOFT_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#Igrosoft']"));
    private Button TABLES_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//a[@href='/games#stoly']"));
    private Button PRODUCERS_FILTER_BUTTON = new Button(By.xpath("//ul[@id='mainGamesFilter']//label[@class='games-filter__item-opener']"));

    private Element GAME_VISIBLE_ITEM = new Element(By.xpath("//div[@style='display: block;']//a[@data-search-keywords]"));
    private Element GAME_ANY_ITEM = new Element(By.xpath("//a[@data-search-keywords]"));  //even not displayed currently item
    private InputBox SEARCH_BOX = new InputBox(By.xpath("//input[@name='q']"));
    private Button FIND_BUTTON = new Button(By.xpath("//button[@class='find']"));
    private Button POPULAR_GAMES_AT_FAILED_SEARCH_BLOCK = new Button(By.xpath("//span[text()='Популярные игры']/.."));
    private Button ALL_GAMES_AT_FAILED_SEARCH_BLOCK = new Button(By.xpath("//span[text()='Все игры']/.."));

    private Panel PRODUCERS_PANEL = new Panel(By.xpath("//ul[@class='games-filter__submenu-container']"));
    private Button ARISTOCRAT_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Aristocrat']"));
    private Button BELATRA_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Belatra']"));
    private Button BOOONGO_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Booongo']"));
    private Button GAMINATOR_PROD_FILTER_BUTTON = new Button(By.xpath("//li[@class='games-filter__submenu-item']/a[@href='/games#Gaminator']"));
    private Button GLOBOTECH_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=GloboTech']"));
    private Button IGROSOFT_PROD_FILTER_BUTTON = new Button(By.xpath("//li[@class='games-filter__submenu-item']/a[@href='/games#Igrosoft']"));
    private Button MEGAJACK_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Megajack']"));
    private Button NETENT_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=NetEnt']"));
    private Button PLAYSON_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Playson']"));
    private Button PLAYTECH_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=Playtech']"));
    private Button OTHERS_PROD_FILTER_BUTTON = new Button(By.xpath("//a[@href='/games#search=drugie']"));

    private Panel MY_GAMES;
    // private final Panel TEXT_BLOCK= new Panel(By.xpath("//div[@data-tab-id='popular']/div[@class='games-block']"));

    /**
     * The method returns a multimap of entries - game id and key word, on which the search was failed
     */
    @Step
    public Multimap<String, String> checkGamesSearch(int quantityOfGames) {
        Multimap<String, String> failedSearchPairs = ArrayListMultimap.create();
        List<Element> gameItems = getGAME_ANY_ITEM().getAllElements();
        for (int i = 0; i < quantityOfGames; i++) {  //we perform testing for particular quantity of random games
            Element victimGame = gameItems.get(RandomGenerate.generateRandomIntWithinRange(1, gameItems.size() + 1));
            String keywords = victimGame.getAttribute("data-search-keywords");
            String gameId = victimGame.getAttribute("data-game-id");
            String[] splitKeywords = keywords.split("\\W+");
            for (String word :
                    splitKeywords) {
                doSearch(word+"ccc");
                if(!new Element(By.xpath("//a[@data-game-id='" + gameId + "']")).atLeastOneElementIsDisplayed()) {//some games are duplicated so we identify them by gameId
                    failedSearchPairs.put(word, gameId);
                }
            }
            logger.info("--------------------------------------------------------");
        }
        return failedSearchPairs;
    }

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

    @Step
    public GamesPage clickAristocratProducer() {
        ARISTOCRAT_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickBelatraProducer() {
        BELATRA_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickBooongoProducer() {
        BOOONGO_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickGaminatorProducer() {
        GAMINATOR_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickGloboTechProducer() {
        GLOBOTECH_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickIgrosoftProducer() {
        IGROSOFT_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickMegajackProducer() {
        MEGAJACK_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickNetEntProducer() {
        NETENT_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickPlaysonProducer() {
        PLAYSON_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickPlaytechProducer() {
        PLAYTECH_PROD_FILTER_BUTTON.click();
        return this;
    }

    @Step
    public GamesPage clickOthersProducer() {
        OTHERS_PROD_FILTER_BUTTON.click();
        return this;
    }
}
