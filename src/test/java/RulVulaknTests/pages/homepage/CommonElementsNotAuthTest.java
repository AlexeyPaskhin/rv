package RulVulaknTests.pages.homepage;

import RulVulaknTests.BaseTestPage;
import com.Elements.Element;
import com.listeners.RussianVulcanListener;
import io.qameta.allure.Description;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class CommonElementsNotAuthTest extends BaseTestPage {

    @Test(groups = {"regression"})
    @Description("carousel For Not AuthUser")
    public void carouselForNotAuthUser() {
        assertTrue(home.CAROUSEL_NOT_AUTH.isPresent());
        try {
            home.CAROUSEL_NOT_AUTH.waitForAttributeToChange("style", 15);
        } catch (TimeoutException e) {
            fail("The carousel " + home.CAROUSEL_NOT_AUTH + " doesn't move");
        }
    }

    @Test(groups = {"regression"})
    @Description("winners Of Day Banner For Not AuthUser")
    public void winnersOfDayBannerNotAuthUser() {
        assertTrue(home.WINNERS_OF_DAY.isPresent());
        try {
            home.WINNERS_OF_DAY.waitForAttributeToChange("style", 15);
        } catch (TimeoutException e) {
            fail("The winners Of Day Banner " + home.WINNERS_OF_DAY + " doesn't move");
        }
    }

    @Test(groups = {"regression"})
    @Description("games At Home Page For Not AuthUser")
    public void gamesAtHomePageNotAuthUser() {
        assertEquals(home.GAME_ITEM.getAllElements().size(), 20, "Wrong quantity of games is loaded");
    }

    @Test(groups = {"regression"})
    @Description("all Games Button For Not AuthUser")
    public void allGamesButtonNotAuthUser() {
        home.clickAllGamesButton();
        assertTrue(home.GAME_ITEM.getAllElements().size() > 20,
                "New games are not loaded after clicking the button 'All games'");
    }

    @Test(groups = {"regression"})
    @Description("static Text For Not AuthUser")
    public void staticTextNotAuthUser() {
        assertTrue(new Element(By.xpath("//h1[text()='Русское Казино Вулкан: больше, чем автоматы, больше чем казино!']")).isPresent());
        assertTrue(new Element(By.xpath("//h2[text()='Игра в Вулкан на деньги - удовольствие гарантировано!']")).isPresent());
        assertTrue(new Element(By.xpath("//h3[text()='Слоты для каждого']")).isPresent());
        assertTrue(new Element(By.xpath("//h2[text()='Дополнительные преимущества РВ']")).isPresent());
        assertTrue(new Element(By.xpath("//h3[text()='Выигрыш принадлежит только Вам']")).isPresent());
        assertTrue(new Element(By.xpath("//h2[text()='Забота о посетителях']")).isPresent());
        assertTrue(new Element(By.xpath("//h3[text()='Уровни VIP: чем дольше, тем лучше']")).isPresent());
    }

}
