package COOP_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Coop_LoginTest {
    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void testLogin() throws InterruptedException, MalformedURLException {
        Coop coop = new Coop();
        driver = coop.coop_login();
    }
}
