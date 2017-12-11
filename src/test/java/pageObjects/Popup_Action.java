package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Meridian on 10/28/2017.
 */
public class Popup_Action {
    private static WebElement element = null;

    public static WebElement popup_alert(WebDriver driver){

        element = driver.findElement(By.cssSelector("p.alert"));

        return element;

    }

    public static WebElement popup_button(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.panel > div.actions > button"));

        return element;
    }



    public static WebElement popup_tittle(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.panel > div.title"));

        return element;
    }

    public static WebElement popup_close(WebDriver driver) {

        element = driver.findElement(By.cssSelector("button.close"));

        return element;
    }
}
