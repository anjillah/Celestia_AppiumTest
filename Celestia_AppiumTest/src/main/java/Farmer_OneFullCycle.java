import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Farmer_OneFullCycle {
AndroidDriver driver;
@BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void farmer_OneFullCycle() throws InterruptedException {
    //LOGIN PAGE
    //Input email
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"))
                .sendKeys("bini_maloi@gmail.com");
        //input password
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"))
                .sendKeys("qwertyui");
        //click login button
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();

        Thread.sleep(5000);

    //CURRENT Inside the App
        //Click on Dashboard page
//        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]"))
//                .click();

        //Click on Orders Page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                        "android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")).click();

        Thread.sleep(3000);
        //go to Items Page
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                        "android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")).click();
        Thread.sleep(3000);

        //go to Profile
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                        "android.view.View/android.view.View[3]/android.view.View/android.view.View[4]")).click();
        Thread.sleep(3000);

        //logout User
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                        "android.view.View/android.view.View[2]")).click();
        Thread.sleep(3000);

        //confirm logout
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/" +
                        "android.view.View/android.view.View[2]")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
//    driver.quit();
    }
}
