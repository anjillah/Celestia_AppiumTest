package COOP_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orders_Preparing {
    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void test(){
        //login
//        Coop coop = new Coop();
//        driver = coop.coop_login();

        //navigate to
    }
}
