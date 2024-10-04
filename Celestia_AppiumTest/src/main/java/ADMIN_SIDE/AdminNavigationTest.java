package ADMIN_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminNavigationTest {
    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void admin_navigation() throws Exception {
// === LOGIN PAGE ===
        //Input email
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.view.View/android.widget.EditText[1]")).sendKeys("duane.chan19@gmail.com");
        //input password
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.view.View/android.widget.EditText[2]")).sendKeys("potangina");
        //click login button
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();

        Thread.sleep(2000);


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


// === USER LOGOUT ===
        //click logout button
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]")).click();
        Thread.sleep(1000);

        //click cancel logout button
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[1]")).click();
        Thread.sleep(1000);

        //click logout button
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]")).click();
        Thread.sleep(1000);

        //click confirm logout button
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]")).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
    }
}