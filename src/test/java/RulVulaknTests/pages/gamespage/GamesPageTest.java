package RulVulaknTests.pages.gamespage;

import RulVulaknTests.BaseTestPage;
import com.Elements.Element;
import com.google.common.collect.Multimap;
import com.listeners.RussianVulcanListener;
import com.pages.GamesPage;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class GamesPageTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(GamesPageTest.class);


    @Test(groups = {"regression"})
    public void checkPopularGames() {
        GamesPage games = home.getHeader().clickGamesLink();
        assertThat(games.getAllPopularGames(), hasSize(20));
    }

    @Test(groups = "regression")
    @Description("successful Search Of A Game")
    public void successfulSearchOfAGame() {
        GamesPage gamesPage = home.getHeader().clickGamesLink();
        Multimap<String, String> failedSearchPairs = gamesPage.checkGamesSearch(3);
        if (!failedSearchPairs.isEmpty()) {
            for (Map.Entry<String, String> entry : failedSearchPairs.entries()) {
                logger.error("The search by keyword " + entry.getKey() + " was failed for the game " + entry.getValue());
            }
            fail();
        }
    }

    @Test(groups = "regression")
    @Description("incorrect Search Of Games")
    public void incorrectSearchOfGames() {
        home.getHeader().clickGamesLink()
                .doSearch("dddd");
        assertTrue(new Element(By.xpath("//p[text()='К сожалению, ничего не найдено']")).isPresent());
    }

    @Test(groups = "regression")
    @Description("popular Games Button At The Failed Search Block")
    public void popularGamesButtonAtTheFailedSearchBlock() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .doSearch("dddd")
                .clickPopularGamesAtFailedSearchBlock();
        List<Element> popularGames = gamesPage.getPOPULAR_GAMES().getSubElementsByXpath("//a");
        assertEquals(popularGames.size(), 20);
        for (Element el : popularGames) {
            assertTrue(el.isPresent(), "Element " + el.getBy() + " isn't selected as popular");
            assertTrue(el.getAttribute("class").contains("item-popular"),
                    "Element " + el.getBy() + " doesn't contain 'item-popular' text in his class!");
        }
    }

    @Test(groups = "regression")
    @Description("all Games Button At The Failed Search Block")
    public void allGamesButtonAtTheFailedSearchBlock() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .doSearch("dddd")
                .clickAllGamesAtFailedSearchBlock();
        assertTrue(gamesPage.PopularGamesExsits());
        assertTrue(gamesPage.NewGamesExists());
        assertTrue(gamesPage.GaminatorGamesExists());
        assertTrue(gamesPage.IgrosoftGamesExists());
        assertTrue(gamesPage.TablesGamesExists());
        assertTrue(gamesPage.SlotGamesExists());
    }

    @Test(groups = "regression")
    @Description("popular Games Filter")
    public void popularGamesFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPopularGamesFilter();
        List<Element> popularGames = gamesPage.getPOPULAR_GAMES().getSubElementsByXpath("//a");
        assertEquals(popularGames.size(), 20);
        for (Element el : popularGames) {
            assertTrue(el.isPresent(), "Element " + el.getBy() + " isn't selected as popular");
            assertTrue(el.getAttribute("class").contains("item-popular"),
                    "Element " + el.getBy() + " doesn't contain 'item-popular' text in his class!");
        }
    }

    @Test(groups = "regression")
    @Description("new Games Filter")
    public void newGamesFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickNewGamesFilter();
        List<Element> newGames = gamesPage.getNEW_GAMES().getSubElementsByXpath("//a");
        for (Element el : newGames) {
            assertTrue(el.isPresent(), "Element " + el.getBy() + " isn't selected as new");
            assertTrue(el.getAttribute("class").contains("item-new"));
            assertTrue(el.getSubElementByXpath("/i[@class='item-tart']").isPresent(),
                    "Element " + el.getBy() + " doesn't have label!");
        }
    }

    @Test(groups = "regression")
    @Description("gaminator Games Filter")
    public void gaminatorGamesFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickGaminatorGamesFilter();
        List<Element> gaminatorGames = gamesPage.getGAMINATOR_GAMES().getSubElementsByXpath("//a");
        for (Element el : gaminatorGames) {
            assertTrue(el.isPresent(), "Element " + el.getBy() + " isn't selected as gaminator");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("gaminator"),
                    "The game " + el.getBy() + " doesn't contain 'gaminator' keyword");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("гаминатор"),
                    "The game " + el.getBy() + " doesn't contain 'гаминатор' keyword");
        }
    }

    @Test(groups = "regression")
    @Description("igrosoft Games Filter")
    public void igrosoftGamesFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickIgrosoftGamesFilter();
        List<Element> igrosoftGames = gamesPage.getIGROSOFT_GAMES().getSubElementsByXpath("//a");
        for (Element el : igrosoftGames) {
            assertTrue(el.isPresent(), "Element " + el.getBy() + " isn't selected as igrosoft");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("igrosoft"),
                    "The game " + el.getBy() + " doesn't contain 'igrosoft' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("игрософт"),
                    "The game " + el.getBy() + " doesn't contain 'игрософт' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("table Games Filter")
    public void tableGamesFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickTablesGamesFilter();
        List<Element> tableGames = gamesPage.getTABLES_GAMES().getSubElementsByXpath("//a");
        for (Element el : tableGames) {
            assertTrue(el.isPresent(), "Element " + el.getBy() + " isn't selected as table game.");
        }
    }

    @Test(groups = "regression")
    @Description("opening Of Producers Panel")
    public void openingOfProducersPanel() {
        GamesPage gamesPage = home.getHeader().clickGamesLink();
        assertFalse(gamesPage.getPRODUCERS_PANEL().isPresent());
        gamesPage.clickPRoducersFilter();
        assertTrue(gamesPage.getPRODUCERS_PANEL().isPresent());
    }

    @Test(groups = "regression")
    @Description("aristocrat Producer Filter")
    public void aristocratProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickAristocratProducer();
        List<Element> aristocratGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : aristocratGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("aristocrat"),
                    "The game " + el.getBy() + " doesn't contain 'aristocrat' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("аристократ"),
                    "The game " + el.getBy() + " doesn't contain 'аристократ' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("belarta Producer Filter")
    public void belatraProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickBelatraProducer();
        List<Element> belatraGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : belatraGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("belatra"),
                    "The game " + el.getBy() + " doesn't contain 'belatra' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("белатра"),
                    "The game " + el.getBy() + " doesn't contain 'белатра' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("booongo Producer Filter")
    public void booongoProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickBooongoProducer();
        List<Element> booongoGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : booongoGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("booongo"),
                    "The game " + el.getBy() + " doesn't contain 'booongo' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("бунго"),
                    "The game " + el.getBy() + " doesn't contain 'бунго' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("gaminator Producer Filter")
    public void gaminatorProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickGaminatorProducer();
        List<Element> gaminatorGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : gaminatorGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("gaminator"),
                    "The game " + el.getBy() + " doesn't contain 'gaminator' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("гаминатор"),
                    "The game " + el.getBy() + " doesn't contain 'гаминатор' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("globoTech Producer Filter")
    public void globotechProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickGloboTechProducer();
        List<Element> globotechGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : globotechGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("globotech"),
                    "The game " + el.getBy() + " doesn't contain 'globotech' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("глоботех"),
                    "The game " + el.getBy() + " doesn't contain 'глоботех' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("igrosoft Producer Filter")
    public void igrosoftProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickIgrosoftProducer();
        List<Element> igrosoftGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : igrosoftGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("igrosoft"),
                    "The game " + el.getBy() + " doesn't contain 'igrosoft' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("игрософт"),
                    "The game " + el.getBy() + " doesn't contain 'игрософт' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("megajack Producer Filter")
    public void megajackProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickMegajackProducer();
        List<Element> megajackGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : megajackGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("megajack"),
                    "The game " + el.getBy() + " doesn't contain 'megajack' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("мегаджек"),
                    "The game " + el.getBy() + " doesn't contain 'мегаджек' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("netent Producer Filter")
    public void netentProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickNetEntProducer();
        List<Element> netentGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : netentGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("netent"),
                    "The game " + el.getBy() + " doesn't contain 'netent' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("нетент"),
                    "The game " + el.getBy() + " doesn't contain 'нетент' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("playson Producer Filter")
    public void playsonProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickPlaysonProducer();
        List<Element> playsonGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : playsonGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("playson"),
                    "The game " + el.getBy() + " doesn't contain 'playson' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("плэйсон"),
                    "The game " + el.getBy() + " doesn't contain 'плэйсон' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("playtech Producer Filter")
    public void playtechProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickPlaytechProducer();
        List<Element> playtechGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : playtechGames) {
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("playtech"),
                    "The game " + el.getBy() + " doesn't contain 'playtech' keyword.");
            assertTrue(el.getAttribute("data-search-keywords").toLowerCase().contains("плэйтек"),
                    "The game " + el.getBy() + " doesn't contain 'плэйтек' keyword.");
        }
    }

    @Test(groups = "regression")
    @Description("playtech Producer Filter")
    public void othersProducerFilter() {
        GamesPage gamesPage = home.getHeader().clickGamesLink()
                .clickPRoducersFilter()
                .clickOthersProducer();
        List<Element> othersGames = gamesPage.getGAME_VISIBLE_ITEM().getAllElements();
        for (Element el : othersGames) {
            assertFalse(el.getAttribute("data-search-keywords").toLowerCase().contains("playtech")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("playson")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("netent")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("megajack")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("igrosoft")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("globotech")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("gaminator")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("booongo")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("belatra")
                            || el.getAttribute("data-search-keywords").toLowerCase().contains("aristocrat")
                    , "The game of others producers" + el.getBy() + " contain a keyword of particular producer.");
        }
    }

}
