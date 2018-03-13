package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.Panel;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

@Getter
public class GamesPage extends AbstractPage {
    private final Panel POPULAR_GAMES = new Panel(By.xpath("//div[@data-tab-id='popular']/div[@class='games-block']"));
    private final Panel NEW_GAMES = new Panel(By.xpath("//div[@data-tab-id='new']/div[@class='games-block']"));
    private final Panel GAMINATOR_GAMES = new Panel(By.xpath("//div[@data-tab-id='Gaminator']/div[@class='games-block']"));
    private final Panel IGROSOFT_GAMES = new Panel(By.xpath("//div[@data-tab-id='Igrosoft']/div[@class='games-block']"));
    private final Panel TABLES_GAMES = new Panel(By.xpath("//div[@data-tab-id='Столы']/div[@class='games-block']"));
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



    public List<Button> getAllPopularGames(){
        return POPULAR_GAME.getAllElements();
    }

    public boolean PopularGamesExsits() {
        return POPULAR_GAMES.isPresent();
    }

    public boolean NewGamesExists() {
        return NEW_GAMES.isPresent();
    }

    public boolean GaminatorGamesExists() {
        return GAMINATOR_GAMES.isPresent();
    }

    public boolean IgrosoftGamesExists() {
        return IGROSOFT_GAMES.isPresent();
    }

    public boolean TablesGamesExists() {
        return TABLES_GAMES.isPresent();
    }

    public boolean SlotGamesExists() {
        return SLOTS_GAMES.isPresent();
    }

}
