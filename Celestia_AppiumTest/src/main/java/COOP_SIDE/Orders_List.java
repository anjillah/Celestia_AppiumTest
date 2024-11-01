package COOP_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Orders_List {
    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverConfig.getDriver();

        Coop coop = new Coop();
        driver = coop.coop_login();
    }

    @Test
    public void testScrollOrdersList() { //TO FIX
        String ORDERS_PAGE = "android:id/ordersPage";
        String ORDER_LIST = "android:id/OrderList";

        // Navigate to the Orders screen
        driver.findElement(AppiumBy.id(ORDERS_PAGE)).click();

        boolean canScrollMore = true;
        int maxScrollAttempts = 10; // Limit the number of scroll attempts to prevent infinite scrolling
        int scrollAttempts = 0;

        while (canScrollMore && scrollAttempts < maxScrollAttempts) {
            try {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"" + ORDER_LIST + "\")).setAsVerticalList().scrollForward()"));
                scrollAttempts++;
            } catch (Exception e) {
                // If scrolling fails, assume we reached the end of the list
                canScrollMore = false;
            }
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        // Uncomment to close the driver after the test
        // driver.quit();
    }
}
