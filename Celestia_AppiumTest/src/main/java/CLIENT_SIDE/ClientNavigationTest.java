package CLIENT_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClientNavigationTest {
    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void client_navigation() throws Exception {
// === LOGIN PAGE ===
       Client clientConstants = new Client();
       driver = clientConstants.client_login();

// === NAVIGATION ===
        //Click on Dashboard page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                        "android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[1]")).click();
        Thread.sleep(1000);

        //Click on Orders Page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")).click();
        Thread.sleep(1000);

        //go to Contact Page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.view.View/android.view.View[3]/android.view.View/android.view.View[3]")).click();
        Thread.sleep(1000);

        //go to Profile
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.view.View/android.view.View[2]/android.view.View/android.view.View[4]")).click();
        Thread.sleep(1000);


// === CLIENT LOGOUT ===
        driver = clientConstants.client_logout();
    }

    @AfterTest
    public void tearDown() {driver.quit();}
} //end