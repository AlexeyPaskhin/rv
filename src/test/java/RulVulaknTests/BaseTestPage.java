package RulVulaknTests;

import com.PreContidions.LandingPage;
import com.pages.HomePage;
import com.utils.CustomDataProvider;
import com.utils.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static com.utils.DriverManager.*;

public class BaseTestPage {
   private final static Logger logger = LogManager.getLogger(BaseTestPage.class);
    public CustomDataProvider customDataProvider;
   public HomePage home;
    @BeforeSuite(alwaysRun = true)
    public void setupHelpers() {
        customDataProvider = new CustomDataProvider();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method, Object[] o) {

        if(o[0] instanceof User){
            User us = (User)o[0];
           logger.info("User LogIn :"+us.getLogin()+" With leght: "+us.getLogin().length()+ " Password is : "+us.getPass());
        }
        setupDriver(customDataProvider.getBrowser());


        if (method.isAnnotationPresent(LandingPage.class)) {

            String pageNumber = o[1].toString();



            getDriver().get(customDataProvider.getBasicURL() + "lp/" +pageNumber);
        } else {
            getDriver().get(customDataProvider.getBasicURL());
        }
        home = new HomePage();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        getDriver().manage().deleteAllCookies();
        getDriver().close();

        if(!customDataProvider.getBrowser().equalsIgnoreCase("firefox")) {
            getDriver().quit();
        }
    }

}
