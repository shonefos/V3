package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmptyBet {

    private static WebElement element = null;

    public static WebElement lnk_EmptyBet (WebDriver driver){

        element = driver.findElement(By.cssSelector("div.title-wrapper > div:nth-of-type(3)"));

        return element;

    }

    public static WebElement EmptyBet_Popup (WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket.small > div > div.panel"));

        return element;

    }

    public static WebElement EmptyBet_Event (WebDriver driver){

        element = driver.findElement(By.cssSelector("div.form > div:nth-of-type(1) > label > input"));

        return element;

    }

    public static WebElement EmptyBet_Game (WebDriver driver){

        element = driver.findElement(By.cssSelector("textarea"));

        return element;

    }

    public static WebElement EmptyBet_Event_Errormessage (WebDriver driver){

        element = driver.findElement(By.cssSelector("div.form > div:nth-of-type(1) > div.error"));

        return element;

    }

    public static WebElement EmptyBet_Game_Errormessage (WebDriver driver){

        element = driver.findElement(By.cssSelector("div.input.double-height.alert > div.error"));

        return element;

    }

    public static WebElement lnk_EmptyBet_Confirm (WebDriver driver){

        element = driver.findElement(By.cssSelector("button.primary"));

        return element;

    }


















}
