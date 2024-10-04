package FARMER_SIDE;

import Constant.Config;
import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class Farmer {
    AndroidDriver driver;

    public Farmer() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    public AndroidDriver farmer_login() throws Exception{
        //input email
        String FARMER_EMAIL = "bini_maloi@gmail.com";
        driver.findElement(AppiumBy.xpath(Config.EmailField_Appium_xpath)).sendKeys(FARMER_EMAIL);

        //input password
        String FARMER_PASSWORD = "qwertyui";
        driver.findElement(AppiumBy.xpath(Config.PasswordField_Appium_xpath)).sendKeys(FARMER_PASSWORD);

        //click login button
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver farmer_logout() throws InterruptedException {
        driver.findElement(AppiumBy.xpath(Config.LogoutButton_Appium_xpath)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.CancelLogoutButton_Appium_xpath)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.LoginButton_Appium_xpath)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.ConfirmLogoutButton_Appium_xpath)).click();
        Thread.sleep(1000);

        return driver;
    }
} //end
