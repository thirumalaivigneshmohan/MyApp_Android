package androidTest;

import java.io.File;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class sampleGreenhouseTest {

    protected AppiumDriver driver;

    private WebElement row;

    @Test
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appPath = new File(classpathRoot, "../../App/build/outputs/apk/App-greenhouseandroid-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion", "4.3");
        capabilities.setCapability("app", appPath);
        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        this.driver = new AndroidDriver(serverAddress, capabilities);
    }

    @AfterTest
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
}