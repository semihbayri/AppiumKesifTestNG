import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium02 {

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // index ile
        By continueButton = AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.Button\").index(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();

        // text ile
        By okButton = AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.Button\").text(\"OK\")");
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();

        // text startwith ile
        By addGestureButton = AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")");
        wait.until(ExpectedConditions.presenceOfElementLocated(addGestureButton));
        driver.findElement(addGestureButton).click();

        // class name ile
        By name = AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.EditText\")");
        wait.until(ExpectedConditions.presenceOfElementLocated(name));
        driver.findElement(name).click();

        driver.findElement(name).sendKeys("testkesif");

         //Actions action = new Actions(driver);
         //action.click(driver.findElement(name)).sendKeys("testkesif").perform();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER)); // klavye de enter tusuna basmak icin yazdik
        driver.hideKeyboard();

        By space =By.id("com.davemac327.gesture.tool:id/gesture_overlay");
        wait.until(ExpectedConditions.presenceOfElementLocated(space));
        driver.findElement(space).click();

        By doneButton = By.xpath("//android.widget.Button[@text='Done']");
        wait.until(ExpectedConditions.presenceOfElementLocated(doneButton));
        driver.findElement(doneButton).click();




    }

}
