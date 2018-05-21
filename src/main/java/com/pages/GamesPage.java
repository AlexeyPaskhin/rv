package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.Panel;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

@Getter
public class GamesPage extends AbstractPage {
    private final Panel POPULAR_GAMES = new Panel(By.xpath("//div[@data-tab-id='popular']/div[@class='games-block']"));
    private final Panel NEW_GAMES = new Panel(By.xpath("//div[@data-tab-id='new']/div[@class='games-block']"));
    private final Panel GAMINATOR_GAMES = new Panel(By.xpath("//div[@data-tab-id='Gaminator']/div[@class='games-block']"));
    private final Panel IGROSOFT_GAMES = new Panel(By.xpath("//div[@data-tab-id='Igrosoft']/div[@class='games-block']"));
    private final Panel TABLES_GAMES = new Panel(By.xpath("//div[@data-tab-id='stoly']/div[@class='games-block']"));
    private final Panel SLOTS_GAMES = new Panel(By.xpath("//div[@data-tab-id='other']/div[@class='games-block']"));
    private final Button POPULAR_GAME = POPULAR_GAMES.getButtonByXpath("//a[contains(@class,'item item-popular')]");

    private final Button FIRST_GAME = POPULAR_GAMES.getButtonByXpath("//a[@href='/games/15-golden-eggs']");
//    private final Button POPULAR_FILTER_BUTTON;
//    private final Button NEW_FILTER_BUTTON;
//    private final Button GAMINATOR_FILTER_BUTTON;
//    private final Button IGROSOFT_FILTER_BUTTON;
//    private final Button TABLES_FILTER_BUTTON;

    private Panel MY_GAMES;
    // private final Panel TEXT_BLOCK= new Panel(By.xpath("//div[@data-tab-id='popular']/div[@class='games-block']"));

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
}
