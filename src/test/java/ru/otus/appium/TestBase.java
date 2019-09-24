package ru.otus.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

abstract class TestBase {

    private final String APPIUM_URL = "http://localhost:4723/wd/hub";

    protected AndroidDriver<MobileElement> wd;

    @BeforeEach
    void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        File apkFile = new File("./apk/calculator.apk");
        caps.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "android_emulator");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        caps.setCapability(MobileCapabilityType.UDID, "192.168.56.101:5555");
        wd = new AndroidDriver<>(new URL(APPIUM_URL), caps);
    }

    @AfterEach
    void tearDown() {
        if(wd != null){
            wd.quit();
            wd = null;
        }
    }

}