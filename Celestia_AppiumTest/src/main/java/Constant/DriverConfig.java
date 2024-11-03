package Constant;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Class for constant @BeforeTest setup
 */
public class DriverConfig {
    public static AndroidDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Config.PLATFORM_NAME);
        capabilities.setCapability("appium:automationName", Config.AUTOMATION_NAME);
        capabilities.setCapability("appium:app", Config.APP_PATH);
        capabilities.setCapability("appium:deviceName", Config.APP_DEVICE_NAME);

        try {
            return new AndroidDriver(new URI(Config.appiumServerURL).toURL(), capabilities);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
