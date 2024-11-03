package COOP_SIDE;

import Constant.DriverConfig;
import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orders_Calendar {
    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverConfig.getDriver();

        //login
        Coop coop = new Coop();
        driver = coop.coop_login();
    }

    @Test
    public void test(){
        String CALENDAR_ICON = "Calendar Icon";

        //navigate to calendar
        driver.findElement(AppiumBy.accessibilityId(CALENDAR_ICON)).click();

        //continue
    }

    }
