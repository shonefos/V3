package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Turbo {

    private static WebElement element = null;


    public static WebElement Turbo_Popup(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.turbo-wrapper"));

        return element;

    }

    public static WebElement Turbo_button_CheckTicketView(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.actions > turbo-cash-button > button.button.turbo"));

        return element;

    }

    public static WebElement Ten_Percentage (WebDriver driver) {

        element = driver.findElement(By.cssSelector("form > label:nth-of-type(1)"));

        return element;
    }

    public static WebElement Accept_All (WebDriver driver) {

        element = driver.findElement(By.cssSelector("form > label:nth-of-type(2)"));

        return element;
    }

    public static WebElement Only_Higher (WebDriver driver) {

        element = driver.findElement(By.cssSelector("form > label:nth-of-type(3)"));

        return element;
    }

    public static WebElement lnk_Turbobutton_ticketcheckview (WebDriver driver) {

        element = driver.findElement(By.cssSelector("button.primary"));

        return element;
    }

    public static WebElement lnk_OK_Turbo_pop_up_payout_ticketcheckview (WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.panel > div.actions > button"));

        return element;
    }

    public static WebElement Turbo_Offer (WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.content > div:nth-of-type(3) > div.value"));

        return element;
    }

    public static WebElement Turbo_button_MyT (WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.ticket.payout.open > div.details > div > div.payout-wrapper > turbo-cash-button > button.button.turbo"));

        return element;
    }

    public static WebElement Turbo_Popup_TicketID (WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.panel > div.title"));

        return element;
    }

    public static WebElement Turbo_payout_message (WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.content > div:nth-of-type(2)"));

        return element;
    }





























}
