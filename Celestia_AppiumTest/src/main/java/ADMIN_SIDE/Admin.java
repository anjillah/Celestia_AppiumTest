package ADMIN_SIDE;

import Constant.Config;
import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import static io.appium.java_client.AppiumBy.*;


/**
 * Admin Login and Logout constants for easier readability, management and less duplicate codes
 */
public class Admin {
    AndroidDriver driver;

    public Admin() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    public AndroidDriver admin_login() throws Exception {
        String ADMIN_EMAIL = "duane.chan19@gmail.com";
        String ADMIN_PASSWORD = "potangina";

        driver.findElement(xpath(Config.EMAIL_FIELD)).sendKeys(ADMIN_EMAIL); //input email
        driver.findElement(xpath(Config.PASSWORD_FIELD)).sendKeys(ADMIN_PASSWORD); //input password
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();//click login button

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver admin_logout() throws InterruptedException {
        driver.findElement(AppiumBy.xpath(Config.LOGOUT_BUTTON)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.CANCEL_LOGOUT)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.LOGOUT_BUTTON)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.CONFIRM_LOGOUT)).click();
        Thread.sleep(1000);
        return driver;
    }
} //end