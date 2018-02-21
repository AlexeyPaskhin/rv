package RulVulaknTests.popups;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;

@Listeners({RussianVulcanListener.class})
public class LogInPopUpTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);


}
