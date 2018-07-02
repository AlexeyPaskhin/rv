package RulVulaknTests;

import com.PreContidions.LandingPage;
import com.PreContidions.RemoveUser;
import com.pages.HeaderAuthorizedUser;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.utils.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static com.utils.DriverManager.*;

public class BaseTestPage {
    private final static Logger logger = LogManager.getLogger(BaseTestPage.class);
    public CustomDataProvider customDataProvider;
    public HomePage home;
    public SSHManager manager = null;
    public HeaderNotAutorizedUser headerNotAutorizedUser;
    public HeaderAuthorizedUser headerAuthorizedUser;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        try {
            manager = new SSHManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method, Object[] o) {
        boolean isLotteryEnabled = false;

        customDataProvider = new CustomDataProvider();

        // if "RemoveUser" annotation is present we rename current user with random string
        if (method.isAnnotationPresent(RemoveUser.class)) {
            if (o[0] instanceof User) {
                User us = (User) o[0];
                String oldName = us.getLogin();
                String newName = "autotest+" + RandomGenerate.randomString(20) + "@playtini.ua";
                manager.updateUserForSocial(oldName, newName);
            }
        }
        // if test get user from data provider we log user login and pass
        if (o.length > 0) {
            if (o[0] instanceof User) {
                User us = (User) o[0];
                logger.info("User LogIn :" + us.getLogin() + " With length: " + us.getLogin().length() + " Password is : " + us.getPass());
            }
        }
        try {
//            WebDriver driver = setupDriver(customDataProvider.getBrowser());

//            we take a browser name from already specified maven variable OR (else) from the 'config.properties' file
            driver = System.getProperty("browser") !=null && !System.getProperty("browser").isEmpty()
                    ? setupDriver(System.getProperty("browser"))
                    : setupDriver(customDataProvider.getBrowser());
            attachDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // if landing page annotation is present then open landing page (default 1) else open homepage
        if (method.isAnnotationPresent(LandingPage.class)) {
            String pageNumber = o[1].toString();
            getDriver().get(customDataProvider.getBasicURL() + "lp/" + pageNumber);
        } else {
            getDriver().get(customDataProvider.getBasicURL());
        }
        //TODO: implement cookie like browser from console ( if isLotteryEnabled =true then set cookies)
        Cookie ck = new Cookie("lottery_reminder_shown", "true");
        getDriver().manage().addCookie(ck);
        Cookie pushSubscribe = new Cookie("push-subscr-cooldown","false");
        getDriver().manage().addCookie(pushSubscribe);
        home = new HomePage();
        headerNotAutorizedUser = new HeaderNotAutorizedUser();
        headerAuthorizedUser = new HeaderAuthorizedUser();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method, Object[] o) {
        //Getting current user ID in database
        if (o.length > 0) {
            if (o[0] instanceof User && method.isAnnotationPresent(RemoveUser.class)) {
                User us = (User) o[0];
                manager.getUserID(us.getLogin());
            }
        }
        getDriver().manage().deleteAllCookies();
//        getDriver().close();

        if (DriverManager.BROWSER.equalsIgnoreCase("firefox")) {
            try {
                getDriver().quit();
            } catch (SessionNotCreatedException e) {
            }
        } else {
            getDriver().quit();
        }
    }

    @AfterClass(alwaysRun = true)
    public void releaseResources() {
        manager.disconnectFromConsole();
    }
}
