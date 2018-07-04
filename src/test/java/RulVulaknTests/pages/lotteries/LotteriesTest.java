package RulVulaknTests.pages.lotteries;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import RulVulaknTests.cashbox.CashboxTest;
import com.Elements.Element;
import com.pages.CurrentLotteryPage;
import com.pages.HomePage;
import com.pages.LotteriesPage;
import com.popups.FastRegisterPopup;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class LotteriesTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(LotteriesTest.class);

    @Test(groups = {"regression"})
    @Description("quantity Of Lotteries At The Page")
    public void quantityOfLotteriesAtThePage() {
        LotteriesPage lotteries = new HomePage().getHeader().clickLotteriesLink();
        assertEquals(lotteries.getLOTTERY_ITEM_DISPLAYED().getAllElements().size(), 10);
    }

    @Test(groups = {"regression"})
    @Description("paging Lotteries")
    public void pagingLotteries() {
        LotteriesPage lotteries = new HomePage().getHeader().clickLotteriesLink()
                .clickNextPage();
        for (int i = 0; i<10; i++) {
            assertFalse(lotteries.getLotteryByIndex(i).isPresent(),
                    "Lottery " + (i+1) + " isn't hided.");
        }
        for (int i = 10; i<20; i++) {
            assertTrue(lotteries.getLotteryByIndex(i).isPresent(),
                    "Lottery " + (i+1) + " isn't shown.");
        }
    }

    @Test(groups = {"regression"})
    @Description("participate In The Lottery Button. it present on the page when there is Not Auth")
    public void participateInTheLotteryButtonNotAuth() {
        FastRegisterPopup registerPopup = new HomePage().getHeader().clickLotteriesLink()
                .clickParticipateInTheLottery();
        assertTrue(registerPopup.getENTER_EMAIL_INPUT().isPresent(),
                "Register pop-up isn't opened from the Lotteries page");
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("current Lottery Button it present at the page when a user is authorized")
    public void currentLotteryButtonAuthPresent(User user) {
        CurrentLotteryPage currentLotteryPage = new HomePage().logInUser(user)
                .clickLotteriesLink()
                .clickCurrentLottery();
        assertTrue(currentLotteryPage.getGET_A_RAFFLE_TICKET().isPresent()
        || currentLotteryPage.getLOTTERY_IS_FINISHED_INFO().isPresent());
    }

    @Test(groups = {"regression"})
    @Description("state Of Banner Depending On Presence Of Active Lottery")
    public void stateOfBannerDependingOnPresenceOfActiveLottery() {
        LotteriesPage lotteriesPage = new HomePage().getHeader()
                .clickLotteriesLink();
        List<Element> notFinishedLotteries = lotteriesPage.getNOT_FINISHED_LOTTERY().getAllElements();
        List<Element> finishedLotteries = lotteriesPage.getFINISHED_LOTTERY().getAllElements();
        if (notFinishedLotteries.size() == 0 && finishedLotteries.size() == 10) {
            assertTrue(lotteriesPage.getDEFAULT_BANNER().isPresent());
            assertFalse(lotteriesPage.getBANNER_ACTIVE().isPresent());
        }
        else if (notFinishedLotteries.size() != 0) {
            assertFalse(lotteriesPage.getDEFAULT_BANNER().isPresent());
            assertTrue(lotteriesPage.getBANNER_ACTIVE().isPresent());
        }
    }

    @Test(groups = {"regression"})
    @Description("content Of A Lottery Block")
    public void contentOfALotteryBlock() {
        LotteriesPage lotteriesPage = new HomePage().getHeader()
                .clickLotteriesLink();
        for (Element lotteryBlock : lotteriesPage.getLOTTERY_ITEM_DISPLAYED().getAllElements()) {
            assertTrue(lotteriesPage.getPRIZE_FUND_TEXT().isPresent());
            assertTrue(lotteriesPage.getPRIZE_FUND_VALUE().isPresent());
            assertTrue(lotteriesPage.getSTART_DATE_TEXT().isPresent());
            assertTrue(lotteriesPage.getEND_DATE_TEXT().isPresent());
            assertTrue(lotteriesPage.getNOT_FINISHED_LOTTERY().isPresent() || lotteriesPage.getFINISHED_LOTTERY().isPresent());
            assertTrue(lotteriesPage.getRIBBON_FINISHED_LOTTERY().isPresent() || lotteriesPage.getRIBBON_NOT_FINISHED_LOTTERY().isPresent());
        }
    }

}
