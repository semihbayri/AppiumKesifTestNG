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
import java.util.List;

public class Appium09 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.sahibinden");
        capabilities.setCapability("appActivity","com.sahibinden.ui.supplementary.UrlForwardingActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");

        // scroll test
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By acceptCookies = By.id("com.sahibinden:id/btn_accept_cookies");
        wait.until(ExpectedConditions.presenceOfElementLocated(acceptCookies));
        driver.findElement(acceptCookies).click();

        By vasitaButton = By.xpath("//android.widget.TextView[@text=\"Vasıta\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(vasitaButton));
        driver.findElement(vasitaButton).click();

        By closeButton = By.id("com.sahibinden:id/anchor_view");
        wait.until(ExpectedConditions.presenceOfElementLocated(closeButton));
        driver.findElement(closeButton).click();

        // scroll down
        int startX = driver.manage().window().getSize().getWidth()/2;
        int startY = (int) (driver.manage().window().getSize().getHeight()*0.8); // /2 yaparsaniz ekranin ortasini secer
        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence scrollDown = new Sequence(finger,0);

        scrollDown.addAction(finger.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX,startY));
        scrollDown.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scrollDown.addAction(finger.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX,endY));
        scrollDown.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scrollDown));

        /*
        By havaAraclari = By.xpath("//android.widget.TextView[@text=\"Hasarlı Araçlar\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(havaAraclari));
        driver.findElement(havaAraclari).click();

         */
        Thread.sleep(2000);

        // Scroll up
        int startX1 = driver.manage().window().getSize().getWidth() / 2;
        int startY1 = (int) (driver.manage().window().getSize().getHeight() * 0.2);
        int endY1 = (int) (driver.manage().window().getSize().getHeight() * 0.8);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence scrollUp = new Sequence(finger1,0);

        scrollUp.addAction(finger1.createPointerMove(Duration.ofSeconds(2),PointerInput.Origin.viewport(),startX1,startY1));
        scrollUp.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scrollUp.addAction(finger1.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX1,endY1));
        scrollUp.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scrollUp));










    }


}