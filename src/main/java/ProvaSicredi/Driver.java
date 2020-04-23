package ProvaSicredi;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Driver {
    public static WebDriver iniciarWebDriver() {

        String driverPath = System.getProperty("user.dir") + "/src/test/resources/chromedriver1.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return new ChromeDriver(capabilities);
    }
}
