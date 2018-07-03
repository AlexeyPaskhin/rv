package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import com.Elements.Element;
import com.pages.HomePage;
import com.pages.LotteriesPage;
import com.pages.WinningsPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.utils.DriverManager.getDriver;
import static org.testng.Assert.*;

public class WinningsPageTest extends BaseTestPage {

    @Test(groups = {"regression"})
    @Description("clicking Games Links")
    public void clickingGamesLinks() {
        WinningsPage winningsPage = new HomePage().clickWinningsBtn();
        for (Element link : winningsPage.getLINK_GAME_TITLE().getAllElements()) {
            String gameTitle = link.getText();
            String[] splitKeywords = gameTitle.split("\\W+");  //we receive in some game titles special characters that doesn't match with page title so we delete them
            link.click();
            for (String keyWord : splitKeywords) {
                assertTrue(getDriver().getTitle().contains(keyWord), "Link " + link.getBy() + " doesn't lead to appropriate game.");
            }
            winningsPage.goBack();
        }
    }

    @Test(groups = {"regression"})
    @Description("clicking Games Images")
    public void clickingGamesImages() {
        WinningsPage winningsPage = new HomePage().clickWinningsBtn();
        for (Element image : winningsPage.getGAME_IMAGE().getAllElements()) {
            String gameTitle = image.getSubElementByXpath("/img").getAttribute("title");
            String[] splitKeywords = gameTitle.split("\\W+");  //we receive in some game titles special characters that doesn't match with page title so we delete them
            image.click();
            for (String keyWord : splitKeywords) {
                assertTrue(getDriver().getTitle().contains(keyWord), "Clicking image " + image.getBy() + " doesn't lead to appropriate game.");
            }
            winningsPage.goBack();
        }
    }

    @Test(groups = {"regression"})
    @Description("clicking Play Buttons")
    public void clickingPlayButtons() {
        WinningsPage winningsPage = new HomePage().clickWinningsBtn();
        for (Element button : winningsPage.getPLAY_GAME_BUTTON().getAllElements()) {
            String gameTitle = button.getSubElementByXpath("/../..//a").getText();
            String[] splitKeywords = gameTitle.split("\\W+");  //we receive in some game titles special characters that doesn't match with page title so we delete them
            button.click();
            for (String keyWord : splitKeywords) {
                assertTrue(getDriver().getTitle().contains(keyWord), "Clicking image " + button.getBy() + " doesn't lead to appropriate game.");
            }
            winningsPage.goBack();
        }
    }

}
