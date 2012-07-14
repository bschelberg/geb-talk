import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.RemoteWebDriver
import java.util.logging.Level
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities

driver = {
    RemoteWebDriver driver = new FirefoxDriver()

    driver.setLogLevel(Level.WARNING)

    driver
}

environments {
    'chrome' {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("chrome.binary", "/usr/bin/chromium");
            new ChromeDriver(capabilities)
        }
    }
}