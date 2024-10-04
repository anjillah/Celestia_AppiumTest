package ADMIN_SIDE;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AdminNavigationTest {
    AndroidDriver driver;

    @Test
    public void admin_navigation() throws Exception {
// === LOGIN PAGE ===
        Admin_Constants adminConstants = new Admin_Constants();
        driver = adminConstants.admin_login();


// === NAVIGATION ===
        //go to dashboard
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")).click();
        Thread.sleep(1000);

        //go to items page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")).click();
        Thread.sleep(1000);

        //go to user management page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]")).click();
        Thread.sleep(1000);

        //go to profile
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[4]")).click();
        Thread.sleep(1000);


// === ADMIN LOGOUT ===
        driver = adminConstants.admin_logout();
    }

    @AfterTest
    public void tearDown() {driver.quit();}
} //end