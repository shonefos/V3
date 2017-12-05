package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class My_Account {


    private static WebElement element = null;


    public static WebElement lnk_Mytickets(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.sidebar > a:nth-of-type(3)"));

        return element;

    }

    public static WebElement lnk_FirstTicket(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.results > div:nth-of-type(1) > div.ticket"));

        return element;

    }

    public static WebElement lnk_Close_MyAccount(WebDriver driver){

        element = driver.findElement(By.cssSelector("button.close"));

        return element;

    }












}
