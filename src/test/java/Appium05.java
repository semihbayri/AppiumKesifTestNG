import io.appium.java_client.AppiumBy;
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

public class Appium05 {
    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.sahibinden");
        capabilities.setCapability("appActivity","com.sahibinden.ui.supplementary.UrlForwardingActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"10000");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // ui scrollable test
        By acceptCookies = By.id("com.sahibinden:id/btn_accept_cookies");
        wait.until(ExpectedConditions.presenceOfElementLocated(acceptCookies));
        driver.findElement(acceptCookies).click();

        By emlakButton = By.xpath("//android.widget.TextView[@text='Emlak']");
        wait.until(ExpectedConditions.presenceOfElementLocated(emlakButton));
        driver.findElement(emlakButton).click();

        By guvenlikSistemleri = AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Güvenlik Sistemleri\"))");
        wait.until(ExpectedConditions.presenceOfElementLocated(guvenlikSistemleri));
        driver.findElement(guvenlikSistemleri).click();

    }
}
