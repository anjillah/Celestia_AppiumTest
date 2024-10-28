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
        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(FARMER_EMAIL);

        //input password
        String FARMER_PASSWORD = "qwertyui";
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(FARMER_PASSWORD);

        //click login button
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver farmer_logout() throws InterruptedException {
//        public static final


        driver.findElement(AppiumBy.id(Config.LOGOUT_BUTTON)).click();
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
