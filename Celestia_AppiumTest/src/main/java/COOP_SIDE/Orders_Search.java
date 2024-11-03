package COOP_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orders_Search {
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
        String ORDERS_PAGE = "android:id/ordersPage";
        String SEARCH = "android:id/searchText";
        String WORD = "KINIING";

        //navigate to Orders screen
        driver.findElement(AppiumBy.id(ORDERS_PAGE)).click();

        //navigate to Delivering
        driver.findElement(AppiumBy.id(SEARCH)).sendKeys(WORD);

        //print out the search results -- if empty or there a searches

    }
}
