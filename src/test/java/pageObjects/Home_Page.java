package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Meridian on 10/25/2017.
 */
public class Home_Page {

    private static WebElement element = null;

public static WebElement lnk_Home_Page(WebDriver driver){

    element = driver.findElement(By.cssSelector("div.logo > img"));

    return element;

}

public static WebElement lnk_LogOut(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.list-item.button.separator"));

        return element;

    }

    public static WebElement lnk_username(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.logout > div:nth-of-type(2) > div.wrapper"));

        return element;

    }

    public static WebElement lnk_logout(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.list-item.button.separator"));

        return element;

    }

    public static WebElement lnk_MyAccount(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.logout > div:nth-of-type(2) > div.list > div:nth-of-type(1)"));

        return element;

    }








}
