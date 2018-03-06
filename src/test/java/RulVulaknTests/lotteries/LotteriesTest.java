package RulVulaknTests.lotteries;

import RulVulaknTests.BaseTestPage;
import com.pages.HomePage;
import com.pages.LotteriesPage;
import org.testng.annotations.Test;

public class LotteriesTest extends BaseTestPage {

    @Test
    public void CurrentLotteryButton(){
     LotteriesPage lotteries = new HomePage().getHeader().clickLotteriesLink();
     String firstlotteryURL= lotteries.getLotteryByIdendex(0).getLotteryLink();
        System.out.println(firstlotteryURL);
    }
}
