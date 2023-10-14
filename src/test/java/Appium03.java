import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium03 {

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        // native chrome test
        By mail = By.id("com.android.chrome:id/signin_fre_dismiss_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(mail));
        driver.findElement(mail).click();

        By moreButton = By.id("com.android.chrome:id/more_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(moreButton));
        driver.findElement(moreButton).click();

        By gotItButton = By.id("com.android.chrome:id/ack_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(gotItButton));
        driver.findElement(gotItButton).click();


        driver.get("https://www.facebook.com");
        System.out.println(driver.getContext() + " app acildigindaki tur ");

       // By registration

    }
}