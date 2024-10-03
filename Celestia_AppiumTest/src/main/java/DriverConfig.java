import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class for constant @BeforeTest setup
 */
public class DriverConfig {
    public static AndroidDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Config.PLATFORM_NAME);
        capabilities.setCapability("appium:automationName", Config.AUTOMATION_NAME);
        capabilities.setCapability("appium:app", Config.APP_PATH);

        return new AndroidDriver(new URL(Config.appiumServerURL), capabilities);
    }
}
