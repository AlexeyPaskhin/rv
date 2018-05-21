package RulVulaknTests.pages.lotteries;

import RulVulaknTests.BaseTestPage;
import com.pages.HomePage;
import com.pages.LotteriesPage;
import org.testng.annotations.Test;

public class LotteriesTest extends BaseTestPage {

    @Test(groups = {"regression"})
    public void CurrentLotteryButton() {
        LotteriesPage lotteries = new HomePage().getHeader().clickLotteriesLink();
        String firstlotteryURL = lotteries.getLotteryByIndex(0).getLotteryLink();
        System.out.println(firstlotteryURL);
    }
}
