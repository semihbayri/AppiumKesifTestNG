import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium01 {

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("app installed");

        // uc izin mevcut ana sayfaya ilerlemek icin elementlere tikladik
        By continuebutton = By.id("com.android.permissioncontroller:id/continue_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(continuebutton));
        driver.findElement(continuebutton).click();

        By okButton = By.id("android:id/button1");
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();

        By secondOkButton = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
        wait.until(ExpectedConditions.presenceOfElementLocated(secondOkButton));
        driver.findElement(secondOkButton).click();

        By apiDemosButton = By.xpath("//android.widget.TextView[@text='API Demos']");
        wait.until(ExpectedConditions.presenceOfElementLocated(apiDemosButton));
        driver.findElement(apiDemosButton).click();

        By preferenceButton = By.xpath("//android.widget.TextView[@text='Preference']");
        wait.until(ExpectedConditions.presenceOfElementLocated(preferenceButton));
        driver.findElement(preferenceButton).click();

        By preferencedependenceis = By.xpath("//android.widget.TextView[@text='3. Preference dependencies']");
        wait.until(ExpectedConditions.presenceOfElementLocated(preferencedependenceis));
        driver.findElement(preferencedependenceis).click();

        By checkbox = By.id("android:id/checkbox");
        wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        driver.findElement(checkbox).click();

        By wifiSettingsButton = By.xpath("//android.widget.TextView[@text='WiFi settings']");
        wait.until(ExpectedConditions.presenceOfElementLocated(wifiSettingsButton));
        driver.findElement(wifiSettingsButton).click();

        By textArea = By.id("android:id/edit");
        wait.until(ExpectedConditions.presenceOfElementLocated(textArea));
        driver.findElement(textArea).sendKeys(" text appium ");

        By okButtontwo = By.id("android:id/button1");
        wait.until(ExpectedConditions.presenceOfElementLocated(okButtontwo));
        driver.findElement(okButtontwo).click();

        System.out.println("text is over");













    }
}
