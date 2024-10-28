import Constant.Config;
import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void testValidLogin() throws Exception {
        String FARMER_EMAIL = "bini_maloi@gmail.com";
        String FARMER_PASSWORD = "qwertyui";

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(FARMER_EMAIL);
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(FARMER_PASSWORD);
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        // Add validation to check if the user is redirected to the dashboard/home screen
        String currentActivity = driver.currentActivity();
        Assert.assertEquals(currentActivity, ".MainActivity", "The current activity should be MainActivity");

        // Print success message
        System.out.println("Test successful: Valid login worked as expected.");
    }

    @Test
    public void testInvalidEmailFormat() throws Exception {
        String FARMER_EMAIL = "bini_maloigmail.com";  // Invalid format
        String FARMER_PASSWORD = "qwertyui";

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(FARMER_EMAIL);
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(FARMER_PASSWORD);
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        try {
            String errorMessage = driver.findElement(AppiumBy.id("android:id/errorMessage")).getText();
            assertEquals("Invalid email format.", errorMessage);
            // Print failure message (unexpected behavior)
            System.out.println("Test failed: Invalid email format was not handled correctly.");
        } catch (Exception e) {
            // Print success message (expected failure)
            System.out.println("Test successful: Invalid email format was correctly handled.");
        }
    }

    @Test
    public void testIncorrectPassword() throws Exception {
        String FARMER_EMAIL = "bini_maloi@gmail.com";
        String FARMER_PASSWORD = "wrongpassword"; // Incorrect password

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(FARMER_EMAIL);
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(FARMER_PASSWORD);
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        try {
            String errorMessage = driver.findElement(AppiumBy.id("android:id/errorMessage")).getText();
            assertEquals("Incorrect credentials.", errorMessage);
            // Print failure message (unexpected behavior)
            System.out.println("Test failed: Incorrect password was not handled correctly.");
        } catch (Exception e) {
            // Print success message (expected failure)
            System.out.println("Test successful: Incorrect password was correctly handled.");
        }
    }

    @Test
    public void testEmptyEmailField() throws Exception {
        String FARMER_PASSWORD = "qwertyui";

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(""); // Empty email field
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(FARMER_PASSWORD);
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        try {
            String errorMessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Fields cannot be empty']")).getText();
            assertEquals("Please enter your email.", errorMessage);
            // Print failure message (unexpected behavior)
            System.out.println("Test failed: Empty email field was not handled correctly.");
        } catch (Exception e) {
            // Print success message (expected failure)
            System.out.println("Test successful: Empty email field was correctly handled.");
        }
    }

    @Test
    public void testEmptyPasswordField() throws Exception {
        String FARMER_EMAIL = "bini_maloi@gmail.com";

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(FARMER_EMAIL);
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(""); // Empty password field
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        try {
            String errorMessage = driver.findElement(AppiumBy.id("android:id/errorMessage")).getText();
            assertEquals("Please enter your password.", errorMessage);
            // Print failure message (unexpected behavior)
            System.out.println("Test failed: Empty password field was not handled correctly.");
        } catch (Exception e) {
            // Print success message (expected failure)
            System.out.println("Test successful: Empty password field was correctly handled.");
        }
    }

    @Test
    public void testBothFieldsEmpty() throws Exception {
        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(""); // Empty email field
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(""); // Empty password field
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        try {
            String errorMessage = driver.findElement(AppiumBy.id("android:id/errorMessage")).getText();
            assertEquals("Please enter both email and password.", errorMessage);
            // Print failure message (unexpected behavior)
            System.out.println("Test failed: Both fields empty were not handled correctly.");
        } catch (Exception e) {
            // Print success message (expected failure)
            System.out.println("Test successful: Both fields empty were correctly handled.");
        }
    }

    @Test
    public void testSqlInjectionInEmail() throws Exception {
        String FARMER_EMAIL = "bini_maloi@gmail.com' OR '1'='1'--"; // SQL injection attempt
        String FARMER_PASSWORD = "qwertyui";

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(FARMER_EMAIL);
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(FARMER_PASSWORD);
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        try {
            String errorMessage = driver.findElement(AppiumBy.id("android:id/errorMessage")).getText();
            assertEquals("Incorrect credentials.", errorMessage);
            // Print failure message (unexpected behavior)
            System.out.println("Test failed: SQL injection in email was not handled correctly.");
        } catch (Exception e) {
            // Print success message (expected failure)
            System.out.println("Test successful: SQL injection in email was correctly handled.");
        }
    }

    @Test
    public void testSqlInjectionInPassword() throws Exception {
        String FARMER_EMAIL = "bini_maloi@gmail.com";
        String FARMER_PASSWORD = "' OR '1'='1'--"; // SQL injection attempt

        driver.findElement(AppiumBy.id(Config.EMAIL_FIELD)).sendKeys(FARMER_EMAIL);
        driver.findElement(AppiumBy.id(Config.PASSWORD_FIELD)).sendKeys(FARMER_PASSWORD);
        driver.findElement(AppiumBy.id(Config.LOGIN_BUTTON)).click();

        Thread.sleep(2000);

        try {
            String errorMessage = driver.findElement(AppiumBy.id("android:id/errorMessage")).getText();
            assertEquals("Incorrect credentials.", errorMessage);
            // Print failure message (unexpected behavior)
            System.out.println("Test failed: SQL injection in password was not handled correctly.");
        } catch (Exception e) {
            // Print success message (expected failure)
            System.out.println("Test successful: SQL injection in password was correctly handled.");
        }
    }

    @AfterTest
    public void tearDown() {
        // Clean up if needed
        if (driver != null) {
            driver.quit();
        }
    }
}