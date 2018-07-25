package com.utils;

import com.loggers.WebDriverEventHandler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import java.util.HashMap;
import java.util.Map;
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
    private static final String ANDROID4_CHROME = "android4Chrome";
    private static final String ANDROID5_CHROME = "android5Chrome";
    private static final String ANDROID6_CHROME = "android6Chrome";
    private static final String ANDROID7_CHROME = "android7Chrome";
    private static final String ANDROID8_CHROME = "android8Chrome";
    private static final String SAFARI = "safari";

    public static String BROWSER = System.getProperty("browser");  //maven config like -Dbrowser=chrome
    // thread safe webdriver to avoid problems with multithreading and parallel running
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();


    public static WebDriver setupDriver(String browser) throws MalformedURLException {
        WebDriverEventListener events = new WebDriverEventHandler();
        WebDriver driver;
        // if we can't read browser from console we use browser from config
        if (BROWSER == null) {
            BROWSER = browser;
        }
        //  URL url = new URL("http://172.17.0.2:4444/wd/hub");
        URL url = new URL("http://autotest.rvkernel.com:4444/wd/hub"); // path to Selenoid server

        if (browser.equalsIgnoreCase(CHROME)) {
//            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            WebDriverManager.chromedriver().setup();
            DesiredCapabilities cap = DesiredCapabilities.chrome(); // browser capability
            cap.setBrowserName("chrome");
            cap.setVersion("66.0");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?
            //event firing driver is an implementation of WebDriverEventHandler from logger package
            /* for local -> new ChromeDriver())
               for remote Wed Driver add -> new RemoteWebDriver(url, cap))                          */
//            driver = new EventFiringWebDriver( new ChromeDriver()).register(events);
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);

        } else if (browser.equalsIgnoreCase(FIREFOX)) {
//            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            DesiredCapabilities cap = DesiredCapabilities.firefox(); // browser capability
            cap.setBrowserName("firefox");
//            cap.setVersion("63.0");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?

            // firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--screenshot");

//            driver = new EventFiringWebDriver(new FirefoxDriver()).register(events);
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);

        } else if (browser.equalsIgnoreCase(EDGE)) {
//            System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
            WebDriverManager.edgedriver().setup();
            DesiredCapabilities cap = DesiredCapabilities.edge(); // browser capability
//            cap.setBrowserName("edge");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?

            driver = new EventFiringWebDriver(new EdgeDriver()).register(events);
//            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);

//            TODO implement EDGE
        } else if (browser.equalsIgnoreCase(OPERA)) {
//            System.setProperty("webdriver.opera.driver", OPERA_DRIVER_PATH);
            WebDriverManager.operadriver().setup();

            DesiredCapabilities cap = DesiredCapabilities.operaBlink(); // browser capability
            cap.setBrowserName("opera");
//            cap.setVersion("51.0");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?

            //use OperaOptions and set a path to opera launcher(not just driver!) at YOUR PK via it when start tests with local opera driver
            //use the capabilities and set a path to opera launcher when start tests with remote driver
            OperaOptions oo = new OperaOptions();
            Map<String, Object> hashmap = new HashMap<>();
            hashmap.put("binary", "/usr/bin/opera");
            oo.addArguments("no-sandbox");

            oo.setBinary("C:\\Program Files\\Opera\\53.0.2907.88\\opera.exe");
            cap.setCapability("operaOptions", hashmap);

//            driver = new EventFiringWebDriver(new OperaDriver(oo)).register(events);
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);
        } else if (browser.equalsIgnoreCase(ANDROID4_CHROME)) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", "chrome");
            cap.setCapability("version", "4.4");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);

        } else if (browser.equalsIgnoreCase(ANDROID5_CHROME)) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", "chrome");
            cap.setCapability("version", "5.0");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);

        } else if (browser.equalsIgnoreCase(ANDROID6_CHROME)) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", "chrome");
            cap.setCapability("version", "6.0");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);

        } else if (browser.equalsIgnoreCase(ANDROID7_CHROME)) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", "chrome");
            cap.setCapability("version", "7.0");
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);

        } else if (browser.equalsIgnoreCase(ANDROID8_CHROME)) {
            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setCapability("browserName", "chrome");
//            cap.setCapability("version", "8.1");
//            cap.setCapability("version", "8.0");

            cap.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
//            cap.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.BROWSER);
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            cap.setCapability("chromedriverExecutableDir", "C:\\Users\\a.paskhyn\\IdeaProjects\\autotest-rv\\src\\main\\resources\\browsers");
//            cap.setCapability("chromedriverExecutable", "C:\\Users\\a.paskhyn\\IdeaProjects\\autotest-rv\\src\\main\\resources\\browsers\\chromedriver_2_19.exe");
//            cap.setCapability("platformVersion", "8.1");
//            cap.setCapability("platformVersion", "7.0");
//            cap.setCapability("platformVersion", "6.0");
//            cap.setCapability("platformVersion", "5.1");
//            cap.setCapability("noReset", true);
            cap.setCapability("enableVNC", true); // Is Interactive mode work?
            cap.setCapability("enableVideo", true); // Is VIDEO recording work?
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-notifications");
//            cap.merge(options);
//            driver = new EventFiringWebDriver(new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap)).register(events);
            driver = new EventFiringWebDriver(new RemoteWebDriver(url, cap)).register(events);

        } else if (browser.equalsIgnoreCase(SAFARI)) {
            DesiredCapabilities caps = DesiredCapabilities.ipad();
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.SAFARI);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad Mini");
            caps.setCapability("platformVersion", "11.4");
            caps.setCapability("ignoreUnimportantViews", true);

            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } else {
            throw new IllegalArgumentException("Please specify correct browser name!!!");
        }
        // Hack before operadriver 2.33 will release
        if (!browser.contains("android") && !browser.equalsIgnoreCase(SAFARI)) {
            if (driver != null) {
                driver.manage().window().setSize(new Dimension(1920, 1080));
            }
            //     driver.manage().window().maximize();
        }
        return driver;
    }

    public static void attachDriver(WebDriver driver) {
        webDriver.set(driver);
        setImplicity(3);
    }

    public static void setImplicity(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }
}
