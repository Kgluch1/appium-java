package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;



public class BaseTest {
    protected AndroidDriver driver;
    private Properties config;

    @BeforeClass
    public void setUp() throws Exception {
        config = loadConfig();

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(config.getProperty("device.name"))
                .setApp(config.getProperty("app.path"))
                .setAppPackage(config.getProperty("app.package"))
                .setAppActivity(config.getProperty("app.activity"))
                .setNewCommandTimeout(Duration.ofSeconds(120));
        options.setCapability("appium:disableWindowAnimation", true);
        driver = new AndroidDriver(new URL(config.getProperty("appium.url")), options);
        driver.setSetting("waitForIdleTimeout", 0);
        driver.setSetting("waitForSelectorTimeout", 10000);
    }

        @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.terminateApp("com.saucelabs.mydemoapp.android");
            driver.quit();
        }
    }

    private Properties loadConfig() throws Exception {
        Properties props = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            props.load(is);
        }
        return props;
    }
}