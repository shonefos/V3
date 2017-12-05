package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Meridian on 10/25/2017.
 */
public class LogIn_Page {

    private static WebElement element = null;

    public static WebElement txtbx_UserName(WebDriver driver) {

        element = driver.findElement(By.cssSelector("[name=\"email_input\"]"));

        return element;

    }

    public static WebElement txtbx_Password(WebDriver driver) {

        element = driver.findElement(By.cssSelector("#password-input"));

        return element;

    }

    public static WebElement btn_LogIn(WebDriver driver) {

        element = driver.findElement(By.cssSelector("button.button.signin"));

        return element;


    }
}
