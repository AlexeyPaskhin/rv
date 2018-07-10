package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.pages.lotteries.LotteriesTest;
import com.Elements.Element;
import com.listeners.RussianVulcanListener;
import com.pages.HomePage;
import com.pages.LotteriesPage;
import com.pages.WinningsPage;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.utils.DriverManager.getDriver;
import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class WinningsPageTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(WinningsPageTest.class);

    @Test(groups = {"regression"})
    @Description("clicking Games Links")
    public void clickingGamesLinks() {
        WinningsPage winningsPage = new HomePage().clickWinningsBtn();
        List<Element> brokenElements = winningsPage.goToGamesLinks();
        if (brokenElements.size() != 0) {
            for (Element el : brokenElements) {
                logger.error("Link " + el.getBy() + " doesn't lead to appropriate game.");
                fail();
            }
        }
    }

    @Test(groups = {"regression"})
    @Description("clicking Games Images")
    public void clickingGamesImages() {
        WinningsPage winningsPage = new HomePage().clickWinningsBtn();
        List<Element> brokenElements = winningsPage.clickGamesImages();
        if (brokenElements.size() != 0) {
            for (Element el : brokenElements) {
                logger.error("Clicking image " + el.getBy() + " doesn't lead to appropriate game.");
                fail();
            }
        }
    }

    @Test(groups = {"regression"})
    @Description("clicking Play Buttons")
    public void clickingPlayButtons() {
        WinningsPage winningsPage = new HomePage().clickWinningsBtn();
        List<Element> brokenElements = winningsPage.clickPlayButtons();
        if (brokenElements.size() != 0) {
            for (Element el : brokenElements) {
                logger.error("Clicking button " + el.getBy() + " doesn't lead to appropriate game.");
                fail();
            }
        }

    }

}
