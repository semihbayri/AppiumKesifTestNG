import io.appium.java_client.AppiumBy;
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

public class Appium06 {
    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"10000");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("app installed");

        // Uc izin mevcut ana sayfaya ilerlemek icin elementlere tikladik
        By continuebutton = By.id("com.android.permissioncontroller:id/continue_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(continuebutton));
        driver.findElement(continuebutton).click();

        By okButton = By.id("android:id/button1");
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();

        By secondOkButton = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
        wait.until(ExpectedConditions.presenceOfElementLocated(secondOkButton));
        driver.findElement(secondOkButton).click();

        By apiDemosButton = By.xpath("//android.widget.TextView[@text=\"API Demos\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(apiDemosButton));
        driver.findElement(apiDemosButton).click();

        By viewsButton = By.xpath("//android.widget.TextView[@text=\"Views\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(viewsButton));
        driver.findElement(viewsButton).click();

        By popUpButton = AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Popup Menu\"))");
        wait.until(ExpectedConditions.presenceOfElementLocated(popUpButton));
        driver.findElement(popUpButton).click();

        By makeAPopUp = By.xpath("//android.widget.Button[@text=\"MAKE A POPUP!\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(makeAPopUp));
        driver.findElement(makeAPopUp).click();

        By searchButton = By.xpath("//android.widget.TextView[@text=\"Search\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
        driver.findElement(searchButton).click();

        By toastMessage = By.xpath("//android.widget.Toast");
        String message = driver.findElement(toastMessage).getText();
        System.out.println("message " + message);

        Assert.assertTrue(message.contains("Search"));


    }
}
