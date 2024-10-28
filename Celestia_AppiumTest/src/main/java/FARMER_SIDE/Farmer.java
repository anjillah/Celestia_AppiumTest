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
        String FARMER_EMAIL = "bini_maloi@gmail.com";
        String FARMER_PASSWORD = "qwertyui";

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(FARMER_EMAIL); //input email
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(FARMER_PASSWORD); //input password
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();//click login button

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver farmer_logout() throws InterruptedException {
        driver.findElement(AppiumBy.id(Config.LOGOUT_BUTTON)).click(); //click Logout button on Profile
        Thread.sleep(1000);

        driver.findElement(AppiumBy.xpath(Config.CANCEL_LOGOUT)).click(); //cancel logout
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.LOGOUT_BUTTON)).click(); //click Logout button on Profile
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath(Config.CONFIRM_LOGOUT)).click(); //confirm logout
        Thread.sleep(1000);

        return driver;
    }
} //end
