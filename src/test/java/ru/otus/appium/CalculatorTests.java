package ru.otus.appium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests extends TestBase {

    @Test
    void testPlus() {
        wd.findElementById("digit_8").click();
        wd.findElementByAndroidUIAutomator("new UiSelector().text(\"+\")").click();
        wd.findElementByXPath(".//*[@text='3']").click();
        wd.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").description(\"equals\")").click();
        int result = Integer.parseInt(wd.findElementById("com.google.android.calculator:id/result_final").getText());
        assertEquals(11, result);
    }

    @Test
    void testDivisionByZero() {
        wd.findElementById("com.google.android.calculator:id/digit_8").click();
        wd.findElementById("com.google.android.calculator:id/op_div").click();
        wd.findElementByXPath(".//*[@text='0']").click();
        wd.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").description(\"equals\")").click();
        String result = wd.findElementById("com.google.android.calculator:id/result_preview").getText();
        assertEquals("Can't divide by 0", result);
    }

}