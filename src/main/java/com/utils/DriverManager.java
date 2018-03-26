package com.utils;

import com.loggers.WebDriverEventHandler;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final String CHROME = "chrome";
    private static final String CHROME_DRIVER_PATH = "src\\main\\resources\\Browsers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "src\\main\\resources\\Browsers\\geckodriver.exe";
    private static final String OPERA_DRIVER_PATH = "src\\main\\resources\\Browsers\\operadriver.exe";
    private static final String EDGE_DRIVER_PATH = "src\\main\\resources\\Browsers\\MicrosoftWebDriver.exe";
    private static final String FIREFOX = "firefox";
    private static final String EDGE = "EDGE";
    private static final String OPERA = "opera";

    public static String BROWSER = System.getProperty("browser");  //maven config like -Dbrowser=chrome
    // thread safe webdriver to avoid problems with multithreading and parallel running
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();


    public static WebDriver setupDriver(String browser) throws MalformedURLException {
        WebDriverEventListener events = new WebDriverEventHandler();
        WebDriver driver = null;
        // if we can't read browser from console we use browser from config
        if (BROWSER == null) {
            BROWSER = browser;
        }
        //  URL url = new URL("http://172.17.0.2:4444/wd/hub");
        URL url = new URL("http://autotest.rvkernel.com:4444/wd/hub"); // path to Selenoid server

        if (browser.equalsIgnoreCase(CHROME)) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            DesiredCapabilities cap = DesiredCapabilities.chrome(); // browser capability
            cap.setBrowserName("chrome");
         //   cap.setVersion("63.0");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?
            //event firing driver is an implementation of WebDriverEventHandler from logger package
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events); // for remote Wed Driver add -> new RemoteWebDriver(url, cap))

        } else if (browser.equalsIgnoreCase(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            // firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--screenshot");

            driver = new EventFiringWebDriver(new FirefoxDriver(firefoxOptions)).register(events);

        } else if (browser.equalsIgnoreCase(EDGE)) {
            System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
            driver = new EventFiringWebDriver(new EdgeDriver()).register(events);

            //TODO implement EDGE
        } else if (browser.equalsIgnoreCase(OPERA)) {
            System.setProperty("webdriver.opera.driver", OPERA_DRIVER_PATH);
            OperaOptions oo = new OperaOptions();
            oo.addArguments("no-sandbox");
            // TODO: 2018-03-23  Add correct path here
            oo.setBinary("C:\\Users\\a.kvasko\\AppData\\Local\\Programs\\Opera\\49.0.2725.64\\opera.exe");
            driver = new EventFiringWebDriver(new OperaDriver(oo)).register(events);
        }
        // Hack before operadriver 2.33 will release
        if (!browser.equalsIgnoreCase(OPERA)) {
            if (driver != null) driver.manage().window().setSize(new Dimension(1920, 1080));
            //     driver.manage().window().maximize();
        }
        return driver;
    }

    public static void attachDriver(WebDriver driver) {
        webDriver.set(driver);
        setImplicity(10);
    }

    public static void setImplicity(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }
}
