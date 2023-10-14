import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;


public class Appium04 {

        @Test
        public void test() throws MalformedURLException {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            String filePath= System.getProperty("user.dir");

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
            capabilities.setCapability("chromedriverExecutableDir", filePath + "/src/driver/chromedriver");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"10000");

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // web hybrid chrome test
            driver.get("https://www.facebook.com");
            System.out.println(driver.getContext() + " app acildigindaki tur");

            // burada uygulamanin hangi turlerinin oldugunu gormek icin getContextHandles() kullaniyoruz
            Set<String> butunTurler = driver.getContextHandles();

            for (String tur : butunTurler){   // native ve webview
                System.out.println(tur);

                if(tur.contains("WEBVIEW_chrome")){
                    driver.context(tur);
                }
            }
            System.out.println(driver.getContext() + "app sonraki durum");

            By facebookLogo = By.cssSelector("img[class='img']");
            wait.until(ExpectedConditions.presenceOfElementLocated(facebookLogo));
            Assert.assertTrue(driver.findElement(facebookLogo).isDisplayed());

            System.out.println("ana sayfadayiz");

            By email = By.cssSelector("input[id='m_login_email']");
            wait.until(ExpectedConditions.presenceOfElementLocated(email));
            driver.findElement(email).sendKeys("test@gmail.com");

            By password = By.cssSelector("input[id='m_login_password']");
            wait.until(ExpectedConditions.presenceOfElementLocated(password));
            driver.findElement(email).sendKeys("678234786234678Gc.");

            By login = By.cssSelector("button[value='Log In']");
            wait.until(ExpectedConditions.presenceOfElementLocated(login));
            driver.findElement(login).click();
    }
}
