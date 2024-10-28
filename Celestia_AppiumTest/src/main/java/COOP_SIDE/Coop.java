package COOP_SIDE;

import Constant.Config;
import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class Coop {
    AndroidDriver driver;

    public Coop() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    public AndroidDriver coop_login() throws InterruptedException {
        String COOP_EMAIL = "coop@gmail.com";
        String COOP_PASSWORD = "Coop123";

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(COOP_EMAIL);
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(COOP_PASSWORD);
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver coop_logout() throws Exception {
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

}