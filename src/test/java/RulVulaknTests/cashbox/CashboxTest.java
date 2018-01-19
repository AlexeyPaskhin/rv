package RulVulaknTests.cashbox;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.registration.RegisterData;
import com.listeners.RussianVulcanListener;
import com.pages.HomePage;
import com.utils.Card;
import com.utils.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by ai on 2018-01-18.
 */

@Listeners({RussianVulcanListener.class})
public class CashboxTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);

    @Test(dataProvider = "randomUserAuthProvider", dataProviderClass = CashboxData.class, groups = {"cashbox"} )
    public void makeDepositRandomUser(User user, Card card) {
        new HomePage().clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .withdrawFromGift()
                .clickHeadCashBox()
                .swithToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOn3000RubButton()
                .clickOnConfirmButton()
                .swtichToParent();

        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test
    public void fuck() {
        System.out.println("WORKED");
    }
}