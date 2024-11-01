package CLIENT_SIDE;

import COOP_SIDE.Coop;
import Constant.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class Client_LoginTest {
    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void testLogin() throws InterruptedException, MalformedURLException {
        Client client = new Client();
        driver = client.client_login();
    }
}
