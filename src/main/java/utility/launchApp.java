package utility;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import properties.MobileProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class launchApp {



    public static AppiumDriver launchHealthApp () {

        MobileProperties mobileProperty = new MobileProperties();
        String version = mobileProperty.getVersion();
        String device  = mobileProperty.getDevice();

        AppiumDriver driver = null;


                try {

                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setCapability("automationName", "XCUITest");
                    cap.setCapability("platformName", "iOS");
                    cap.setCapability("platformVersion", version);
                    cap.setCapability("deviceName", device);
                    cap.setCapability("bundleId", "com.globant.AppleHealthApp");
                    cap.setCapability("app",
                            "/Users/rodrigofontan/Library/Developer/Xcode/DerivedData/AppleHealthApp-artofcimjjjcuucfsstxxtqcokzw/Build/Products/Debug-iphonesimulator/AppleHealthApp.app");

                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    driver = new AppiumDriver(url, cap);
                    Assert.assertNotNull(driver);
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return driver;
            }

}
