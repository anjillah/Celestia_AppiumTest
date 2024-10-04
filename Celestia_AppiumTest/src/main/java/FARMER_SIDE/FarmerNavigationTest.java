package FARMER_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FarmerNavigationTest {
AndroidDriver driver;
@BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void farmer_navigation() throws Exception {
// === LOGIN PAGE ===
        Farmer farmerConstants = new Farmer();
        driver = farmerConstants.farmer_login();

// === NAVIGATION ===
        //Click on dashboard
//        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
//                        "android.view.View/android.view.View[2]/android.view.View/android.view.View[1]")).click();
//        Thread.sleep(1000);

        //Click on orders page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")).click();
        Thread.sleep(1000);

        //go to items page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                        "android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")).click();
        Thread.sleep(1000);

        //go to profile
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                        "android.view.View/android.view.View[3]/android.view.View/android.view.View[4]")).click();
        Thread.sleep(1000);


// === FARMER LOGOUT ===
        driver = farmerConstants.farmer_logout();
    }

    @AfterTest
    public void tearDown() {driver.quit();}
} //end