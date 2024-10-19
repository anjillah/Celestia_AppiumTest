package COOP_SIDE;

import Constant.Config;
import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class Coop {
    AndroidDriver driver;

    public Coop() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    public AndroidDriver coop_login() throws InterruptedException {
        String COOP_EMAIL = "coop@gmail.com";
        String COOP_PASSWORD = "Coop123";

        driver.findElement(AppiumBy.id(Config.EmailField_AppiumId)).sendKeys(COOP_EMAIL);
        driver.findElement(AppiumBy.id(Config.PasswordField_AppiumId)).sendKeys(COOP_PASSWORD);
        driver.findElement(AppiumBy.id(Config.LoginButton_AppiumId)).click();

        Thread.sleep(2000);

        return driver;
    }

}