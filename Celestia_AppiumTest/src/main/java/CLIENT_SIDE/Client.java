package CLIENT_SIDE;

import Constant.Config;
import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class Client {
    AndroidDriver driver;

    public Client() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    public AndroidDriver client_login() throws Exception {
        //Input email
        String CLIENT_EMAIL = "bini_colet@gmail.com";
        driver.findElement(AppiumBy.xpath(Config.EmailField_AppiumId)).sendKeys(CLIENT_EMAIL);

        //input password
        String CLIENT_PASSWORD = "12345678";
        driver.findElement(AppiumBy.xpath(Config.PasswordField_AppiumId)).sendKeys(CLIENT_PASSWORD);

        //click login button
        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver client_logout() throws Exception {
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
