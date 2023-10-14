import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class Appium08 {

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"10000");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Uc izin mevcut ana sayfaya ilerlemek icin elementlere tikladik
        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();

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

        By expandableListButton = By.xpath("//android.widget.TextView[@text='Expandable Lists']");
        wait.until(ExpectedConditions.presenceOfElementLocated(expandableListButton));
        driver.findElement(expandableListButton).click();

        By customAdapterButton = By.xpath("//android.widget.TextView[@text='1. Custom Adapter']");
        wait.until(ExpectedConditions.presenceOfElementLocated(customAdapterButton));
        driver.findElement(customAdapterButton).click();

        By peopleNamesButton = By.xpath("//android.widget.TextView[@text='People Names']");
        wait.until(ExpectedConditions.presenceOfElementLocated(peopleNamesButton));
        driver.findElement(peopleNamesButton).click();

        By chuck = By.xpath("//android.widget.TextView[@text='Chuck']");
        wait.until(ExpectedConditions.presenceOfElementLocated(chuck));

        // Create a PointerInput instance
        PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH,"finger");

        // Sequence of actions
        Sequence longPress = new Sequence(pointer,0);

        longPress.addAction(pointer.createPointerMove(Duration.ofSeconds(2),
                PointerInput.Origin.fromElement(driver.findElement(chuck)),0, 0));

        longPress.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new Pause(pointer,Duration.ofSeconds(2)));
        longPress.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the sequence of actions
        driver.perform(Arrays.asList(longPress));
    }

}


