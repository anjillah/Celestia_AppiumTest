import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    public AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String appiumServerURL = "http://127.0.0.1:4723";

        //update this always
        String appPath = "C:\\Users\\Asus\\IdeaProjects\\Celestia_AppiumTest\\apps\\CocoByCelestia.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:app", appPath);
//        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apps/CocoByCelestia.apk") ;

        driver = new AndroidDriver(new URL(appiumServerURL), capabilities);
    }

    @Test
    public void test() throws InterruptedException {
        //Input email
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"))
                .sendKeys("bini_maloi@gmail.com");
        //input password
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"))
                .sendKeys("qwertyui");
        //click login button
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();

        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}