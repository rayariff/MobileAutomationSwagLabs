package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class PostiveCase {
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args)  {
        try{
            loginSwaglabs();
        }catch(Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }
    public static void loginSwaglabs() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "note8");
        cap.setCapability("udid","krjjzl8xc6hu59vk");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","10");
        cap.setCapability("appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        cap.setCapability("autoGrantPermissions", true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
        System.out.println("Login User with Valid Data");

        MobileElement usernameField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']"));
        MobileElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
        MobileElement loginButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));
        MobileElement productText = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));
//
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        String result = productText.getText();
        System.out.println("\n User should redirected to product page and see " +result+ "text");

        System.out.println("Completed...");

    }
}
