package RulVulaknTests;

import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.pages.HomePage;
import com.utils.*;
import jdk.nashorn.internal.ir.ObjectNode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.SessionNotCreatedException;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static com.utils.DriverManager.*;

public class BaseTestPage {
    private final static Logger logger = LogManager.getLogger(BaseTestPage.class);
    public CustomDataProvider customDataProvider;
    public HomePage home;
    SSHManager manager = null;

    @BeforeSuite(alwaysRun = true)
    public void setupHelpers() {
        customDataProvider = new CustomDataProvider();
        try {
            manager = new SSHManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method, Object[] o) {

        if (method.isAnnotationPresent(RemoveUser.class)) {
            if (o[0] instanceof User) {
                User us = (User) o[0];
                String oldName = us.getLogin();
                String newName = "autotest+" + RandomGenerate.randomString(3, 10) + "@playtini.ua";
                    manager.updateUserForSocial(oldName,newName);
            }
        }
        if (o[0] instanceof User) {
            User us = (User) o[0];
            logger.info("User LogIn :" + us.getLogin() + " With length: " + us.getLogin().length() + " Password is : " + us.getPass());
        }
        try {
            setupDriver(customDataProvider.getBrowser());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        if (method.isAnnotationPresent(LandingPage.class)) {

            String pageNumber = o[1].toString();


            getDriver().get(customDataProvider.getBasicURL() + "lp/" + pageNumber);
        } else {
            getDriver().get(customDataProvider.getBasicURL());
        }
        home = new HomePage();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Object[] o) {
        if (o[0] instanceof User) {
            User us = (User) o[0];
            manager.getUserID(us.getLogin());
        }

        getDriver().manage().deleteAllCookies();
        getDriver().close();

        if(DriverManager.BROWSER.equalsIgnoreCase("firefox")) {
try {
    getDriver().quit();
}
catch (SessionNotCreatedException e){}
        }




        if (!DriverManager.BROWSER.equalsIgnoreCase("firefox")) {

            getDriver().quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void releaseResources() {
        manager.disconnectFromConsole();
    }

}
