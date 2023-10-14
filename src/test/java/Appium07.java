import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
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

public class Appium07 {

    @Test
    public void test () throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"10000");

        // Drag and drop test

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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

        By dragAndDropButton = By.xpath("//android.widget.TextView[@text=\"Drag and Drop\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(dragAndDropButton));
        driver.findElement(dragAndDropButton).click();

        By firstDot = By.id("com.touchboarder.android.api.demos:id/drag_dot_1");
        By secondDot = By.id("com.touchboarder.android.api.demos:id/drag_dot_2");
        By thirdDot = By.id("com.touchboarder.android.api.demos:id/drag_dot_3");

        // Perform drag and drop using PointerInput and PointerInputOptions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence dragAndDrop = new Sequence(finger,0);

        // ilk noktadan hareket(secme) ettirme islemi
        dragAndDrop.addAction(finger.createPointerMove
                (Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(firstDot)),0,0));

        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // ilk noktayi hareket ettirme
        dragAndDrop.addAction(finger.createPointerMove
                (Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(firstDot)),0,0));

        // ikinci noktaya hareket ettirme
        dragAndDrop.addAction(finger.createPointerMove
                (Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(secondDot)),0,0));

        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragAndDrop));


        Sequence dragAndDrop2 = new Sequence(finger,0);
        By hiddenDot = By.id("com.touchboarder.android.api.demos:id/drag_dot_hidden");

        // ilk noktadan hareket(secme) ettirme islemi
        dragAndDrop2.addAction(finger.createPointerMove
                (Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(thirdDot)),0,0));

        dragAndDrop2.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));


        // ilk noktayi hareket ettirme
        dragAndDrop2.addAction(finger.createPointerMove
                (Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(thirdDot)),0,0));


        // ikinci noktaya hareket ettirme
        dragAndDrop2.addAction(finger.createPointerMove
                (Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(hiddenDot)),0,0));

        dragAndDrop2.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragAndDrop2));

    }
}
