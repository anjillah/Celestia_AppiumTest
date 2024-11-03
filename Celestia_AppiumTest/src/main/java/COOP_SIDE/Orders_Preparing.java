package COOP_SIDE;

import Constant.DriverConfig;
import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orders_Preparing {
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
        String PREPARING_BUTTON = "android:id/PreparingButton";

        //Card Details
        String CARD = "android:id/OrderItem_1";
        String OrderID = "android:id/OrderID_1";
        String OrderDetails = "android:id/OrderDetailsText_1";
        String ClientName = "android:id/ClientName_1";
        String OrderStatus = "android:id/OrderStatus_1";
        String OrderAddress = "android:id/OrderAddress_1";
        String DateOrdered = "android:id/OrderDate_1";

        String SHIP_ORDER = "android:id/ShipOrderButton";

        //navigate to Orders screen
        driver.findElement(AppiumBy.id(ORDERS_PAGE)).click();

        //navigate to Preparing
        driver.findElement(AppiumBy.id(PREPARING_BUTTON)).click();

        driver.findElement(AppiumBy.id(CARD)).getText();
        driver.findElement(AppiumBy.id(OrderID)).getText();
        driver.findElement(AppiumBy.id(OrderDetails)).getText();
        driver.findElement(AppiumBy.id(ClientName)).getText();
        driver.findElement(AppiumBy.id(OrderStatus)).getText(); //should be equal to "Preparing"
        driver.findElement(AppiumBy.id(OrderAddress)).getText();
        driver.findElement(AppiumBy.id(DateOrdered)).getText();
        driver.findElement(AppiumBy.id(SHIP_ORDER)).getText();

        //after confirming the order ship the product
        driver.findElement(AppiumBy.id(SHIP_ORDER)).click();
    }
}
