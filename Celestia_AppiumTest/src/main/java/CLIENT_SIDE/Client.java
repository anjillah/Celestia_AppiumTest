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

    public AndroidDriver client_login() throws InterruptedException {
        String CLIENT_EMAIL = "bini_colet@gmail.com";
        String CLIENT_PASSWORD = "12345678";

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(CLIENT_EMAIL); // Input email
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(CLIENT_PASSWORD); // Input password
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click(); // Click login button

        Thread.sleep(2000);

        return driver;
    }

    public AndroidDriver client_logout() throws Exception {
        driver.findElement(AppiumBy.id("android:id/profilePage")).click(); // Assuming this is the correct ID
        driver.findElement(AppiumBy.id(Config.LOGOUT_BUTTON)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id(Config.CANCEL_LOGOUT)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id(Config.LOGOUT_BUTTON)).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id(Config.CONFIRM_LOGOUT)).click();
        Thread.sleep(1000);

        return driver;
    }
}
