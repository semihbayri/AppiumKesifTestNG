import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Appium10 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("deviceName","e94f8218");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10000);

        // swipe test
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // Get the screen dimensions
        Dimension screenSize = driver.manage().window().getSize();

        // left to right

        int startX = (int) (screenSize.width * 0.8);
        int startY = screenSize.height / 2;
        int endX = (int) (screenSize.width * 0.1);
        int endY = screenSize.height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swiperLR = new Sequence(finger,0);

        swiperLR.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY));
        swiperLR.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swiperLR.addAction(finger.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),endX,endY));
        swiperLR.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swiperLR));

        Thread.sleep(2000);

        // Right to Left
        int startX1 = (int) (screenSize.getWidth() * 0.2);
        int startY1 = screenSize.getHeight() / 2;
        int endX1 = (int) (screenSize.getWidth() * 0.8);
        int endY1 = screenSize.getHeight() / 2;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipeRL = new Sequence(finger1,0);

        swipeRL.addAction(finger1.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX1,startY1));
        swipeRL.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeRL.addAction(finger1.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),endX1,endY1));
        swipeRL.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipeRL));



    }

}