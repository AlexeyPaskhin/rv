package RulVulaknTests.registration;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({RussianVulcanListener.class})
public class RegistrationNegativeCasesTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(RegistrationWithoutGiftsTest.class);

    @Test(dataProvider = "randomUserProvider", dataProviderClass = RegisterData.class, groups = {"register"})
    @Description("Registration negative case - ")
    public void registrationFromHeaderRubBonus(User user) {
        new HeaderNotAutorizedUser().clickRegister()

              ;
        try {

        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}
