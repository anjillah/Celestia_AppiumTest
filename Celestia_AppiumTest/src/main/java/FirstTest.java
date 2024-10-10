import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * Initial test only
 */
public class FirstTest {

    public AndroidDriver driver;
    public String appiumServerURL = "http://127.0.0.1:4723";
    public String app_path = System.getProperty("user.dir") + "\\apps\\app-release.apk";


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:app", app_path);

        try {
            driver = new AndroidDriver(new URI(appiumServerURL).toURL(), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() throws InterruptedException {
        //Input email
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/" +
                        "android.view.View/android.view.View/android.widget.EditText[1]"))
                .sendKeys("bini_maloi@gmail.com");
        //input password
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/" +
                        "android.view.View/android.view.View/android.widget.EditText[2]"))
                .sendKeys("qwertyui");
        //click login button
        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}