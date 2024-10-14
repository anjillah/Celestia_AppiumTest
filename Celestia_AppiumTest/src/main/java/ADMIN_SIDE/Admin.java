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
        //input email
        String ADMIN_EMAIL = "duane.chan19@gmail.com";
        driver.findElement(xpath(Config.EmailField_AppiumId)).sendKeys(ADMIN_EMAIL);

        //input password
        String ADMIN_PASSWORD = "potangina";
        driver.findElement(xpath(Config.PasswordField_AppiumId)).sendKeys(ADMIN_PASSWORD);

        //click login button
        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver admin_logout() throws InterruptedException {
        driver.findElement(AppiumBy.xpath(Config.LogoutButton_AppiumId)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.CancelLogoutButton_Appium_xpath)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.LogoutButton_AppiumId)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.ConfirmLogoutButton_Appium_xpath)).click();
        Thread.sleep(1000);
        return driver;
    }
} //end