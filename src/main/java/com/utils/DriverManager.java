package com.utils;

import com.loggers.WebDriverEventHandler;
import org.openqa.selenium.Platform;
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
    private static WebDriver driver;
    public static String BROWSER = System.getProperty("browser");
    private static WebDriverEventListener events = new WebDriverEventHandler();

    public static WebDriver setupDriver(String browser) throws MalformedURLException {
        if (BROWSER == null) {
            BROWSER = browser;
        }
        URL url = new URL("http://autotest.rvkernel.com:4444/wd/hub");


//        server = new BrowserMobProxyServer();
//        server.start();
//        int port = server.getPort();
//        Proxy proxy = ClientUtil.createSeleniumProxy(server);
//        String PROXY = "193.124.182.229:3348";
//
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy(PROXY);
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability(CapabilityType.PROXY, proxy);

        if (browser.equalsIgnoreCase(CHROME)) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
             cap.setBrowserName("chrome");
           // cap.setPlatform(Platform.WINDOWS);
              cap.setVersion("63.0");


            //cap.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
            // chromeOptions.addArguments("--headless");

            driver = new EventFiringWebDriver(new RemoteWebDriver(url,cap)).register(events); // for remote Wed Driver add -> new RemoteWebDriver(url, cap))
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
            oo.setBinary("C:\\Users\\a.kvasko\\AppData\\Local\\Programs\\Opera\\49.0.2725.64\\opera.exe");
            driver = new EventFiringWebDriver(new OperaDriver(oo)).register(events);
        }
        // Hack before operadriver 2.33 will release
        if (!browser.equalsIgnoreCase(OPERA)) {
            driver.manage().window().maximize();
        }
        setImplicity(10);
        return driver;
    }

    public static void setImplicity(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver() {
        return driver;
    }
}
