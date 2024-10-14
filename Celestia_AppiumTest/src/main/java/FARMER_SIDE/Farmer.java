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
        driver.findElement(AppiumBy.id(Config.EmailField_AppiumId)).sendKeys(FARMER_EMAIL);

        //input password
        String FARMER_PASSWORD = "qwertyui";
        driver.findElement(AppiumBy.id(Config.PasswordField_AppiumId)).sendKeys(FARMER_PASSWORD);

        //click login button
        driver.findElement(AppiumBy.id(Config.LoginButton_AppiumId)).click();

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver farmer_logout() throws InterruptedException {
        driver.findElement(AppiumBy.id(Config.LogoutButton_AppiumId)).click();
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
