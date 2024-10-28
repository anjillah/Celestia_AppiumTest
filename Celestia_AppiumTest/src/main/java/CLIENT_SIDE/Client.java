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
        String CLIENT_EMAIL = "bini_colet@gmail.com";
        String CLIENT_PASSWORD = "12345678";

        driver.findElement(AppiumBy.xpath(Config.EMAIL_FIELD)).sendKeys(CLIENT_EMAIL); //Input email
        driver.findElement(AppiumBy.xpath(Config.PASSWORD_FIELD)).sendKeys(CLIENT_PASSWORD); //input password
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();//click login button

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver client_logout() throws Exception {
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
