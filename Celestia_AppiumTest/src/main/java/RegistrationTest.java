import Constant.Config;
import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {

    private AndroidDriver driver;
    @BeforeClass
    public void setUp() throws Exception {
        driver = DriverConfig.getDriver();
    }

    //TBC
    //NOT FINAL


//    @Test
//    public void testRegistration() {
////        click on register now
//        driver.findElement(AppiumBy.id("android:id/registerNow")).click();
//
////        click on farmer
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Farmer\")")).click();
//
//
//        String EMAIL_FIELD_REG = "bini_mikha@gmail.com";
//        String FIRST_NAME = "Mikha";
//        String LAST_NAME = "Lim";
//        String PASSWORD_FIELD_REG = "abunjing";
//        String CONFIRM_PASSWORD = "abunjing";
//
////        register email
//        driver.findElement(AppiumBy.id(Config.REG_EMAIL_FIELD_AppiumId)).sendKeys(EMAIL_FIELD_REG);
//        driver.findElement(AppiumBy.id(Config.REG_FIRST_NAME_FIELD_AppiumId)).sendKeys(FIRST_NAME);
//        driver.findElement(AppiumBy.id(Config.REG_LAST_NAME_FIELD_AppiumId)).sendKeys(LAST_NAME);
//        driver.findElement(AppiumBy.id(Config.REG_PASSWORD_FIELD_AppiumId)).sendKeys(PASSWORD_FIELD_REG);
//        driver.findElement(AppiumBy.id(Config.REG_CONFIRM_PASSWORD_FIELD_AppiumId)).sendKeys(CONFIRM_PASSWORD);
//
//        driver.findElement(AppiumBy.id(Config.REG_REGISTRATION_BUTTON_AppiumId)).click();
//    }

    @Test
    public void testRegistrationWithYahooEmail() throws InterruptedException {
        String EMAIL_FIELD_REG = "bini_aiah@yahoo.com";
        String FIRST_NAME = "Aiah";
        String LAST_NAME = "Arceta";
        String PASSWORD_FIELD_REG = "nonopilit";
        String CONFIRM_PASSWORD = "nonopilit";

//        register email
        driver.findElement(AppiumBy.id(Config.REG_EMAIL_FIELD_AppiumId)).sendKeys(EMAIL_FIELD_REG);
        driver.findElement(AppiumBy.id(Config.REG_FIRST_NAME_FIELD_AppiumId)).sendKeys(FIRST_NAME);
        driver.findElement(AppiumBy.id(Config.REG_LAST_NAME_FIELD_AppiumId)).sendKeys(LAST_NAME);
        driver.findElement(AppiumBy.id(Config.REG_PASSWORD_FIELD_AppiumId)).sendKeys(PASSWORD_FIELD_REG);
        driver.findElement(AppiumBy.id(Config.REG_CONFIRM_PASSWORD_FIELD_AppiumId)).sendKeys(CONFIRM_PASSWORD);
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id(Config.REG_REGISTRATION_BUTTON_AppiumId)).click();
    }

    @Test
    public void testRegistrationWithMultiLevelDomain() throws InterruptedException {
        String EMAIL_FIELD_REG = "bini_stacey@slu.edu.com";
        String FIRST_NAME = "Stacey";
        String LAST_NAME = "Sevilleja";
        String PASSWORD_FIELD_REG = "staku";
        String CONFIRM_PASSWORD = "staku";

//        register email
        driver.findElement(AppiumBy.id(Config.REG_EMAIL_FIELD_AppiumId)).sendKeys(EMAIL_FIELD_REG);
        driver.findElement(AppiumBy.id(Config.REG_FIRST_NAME_FIELD_AppiumId)).sendKeys(FIRST_NAME);
        driver.findElement(AppiumBy.id(Config.REG_LAST_NAME_FIELD_AppiumId)).sendKeys(LAST_NAME);
        driver.findElement(AppiumBy.id(Config.REG_PASSWORD_FIELD_AppiumId)).sendKeys(PASSWORD_FIELD_REG);
        driver.findElement(AppiumBy.id(Config.REG_CONFIRM_PASSWORD_FIELD_AppiumId)).sendKeys(CONFIRM_PASSWORD);
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id(Config.REG_REGISTRATION_BUTTON_AppiumId)).click();
    }

    @Test(priority = 1)
    public void testRegistrationWithEmptyFields() throws InterruptedException {
////        click on register now
//        driver.findElement(AppiumBy.id("android:id/registerNow")).click();
//
////        click on farmer
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Farmer\")")).click();


        String EMAIL_FIELD_REG = "";
        String FIRST_NAME = "";
        String LAST_NAME = "";
        String PASSWORD_FIELD_REG = "";
        String CONFIRM_PASSWORD = "";

//        register email
        driver.findElement(AppiumBy.id(Config.REG_EMAIL_FIELD_AppiumId)).sendKeys(EMAIL_FIELD_REG);
        driver.findElement(AppiumBy.id(Config.REG_FIRST_NAME_FIELD_AppiumId)).sendKeys(FIRST_NAME);
        driver.findElement(AppiumBy.id(Config.REG_LAST_NAME_FIELD_AppiumId)).sendKeys(LAST_NAME);
        driver.findElement(AppiumBy.id(Config.REG_PASSWORD_FIELD_AppiumId)).sendKeys(PASSWORD_FIELD_REG);
        driver.findElement(AppiumBy.id(Config.REG_CONFIRM_PASSWORD_FIELD_AppiumId)).sendKeys(CONFIRM_PASSWORD);
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id(Config.REG_REGISTRATION_BUTTON_AppiumId)).click();
    }

    @Test
    public void testRegistrationWithEmptyEmailField() throws InterruptedException {
        //        click on register now
        driver.findElement(AppiumBy.id("android:id/registerNow")).click();

//        click on farmer
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Farmer\")")).click();
        String EMAIL_FIELD_REG = "";
        String FIRST_NAME = "yoko";
        String LAST_NAME = "na";
        String PASSWORD_FIELD_REG = "talaga";
        String CONFIRM_PASSWORD = "ambot";

//        register email
        driver.findElement(AppiumBy.id(Config.REG_EMAIL_FIELD_AppiumId)).sendKeys(EMAIL_FIELD_REG);
        driver.findElement(AppiumBy.id(Config.REG_FIRST_NAME_FIELD_AppiumId)).sendKeys(FIRST_NAME);
        driver.findElement(AppiumBy.id(Config.REG_LAST_NAME_FIELD_AppiumId)).sendKeys(LAST_NAME);
        driver.findElement(AppiumBy.id(Config.REG_PASSWORD_FIELD_AppiumId)).sendKeys(PASSWORD_FIELD_REG);
        driver.findElement(AppiumBy.id(Config.REG_CONFIRM_PASSWORD_FIELD_AppiumId)).sendKeys(CONFIRM_PASSWORD);
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id(Config.REG_REGISTRATION_BUTTON_AppiumId)).click();
    }
}