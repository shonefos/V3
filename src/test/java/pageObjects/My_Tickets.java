package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Meridian on 10/28/2017.
 */
public class My_Tickets {

    private static WebElement element = null;


    public static WebElement tab_Mytickets(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket-tab.tab-tickets"));

        return element;

    }


    public static WebElement lnk_OpenMyT(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.sections > div:nth-of-type(2)"));

        return element;

    }

    public static WebElement lnk_viewTicket(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket-wrapper > div:nth-of-type(1) > div.action > div.button > a > span"));

        return element;

    }
    public static WebElement get_ticketvalue(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket.payout.open > div.details > div > div:nth-of-type(1) > div.payout > div.stake > div.right"));

        return element;

    }

    public static WebElement get_ticketId(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket-wrapper > div:nth-of-type(1) > div.action > div.ticket-info"));

        return element;

    }

    public static WebElement get_ticketevent(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket.payout.open > div.details > div > div:nth-of-type(1) > div.event > div.rivals"));

        return element;

    }

    public static WebElement get_detailedticketAccandID(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket.payout.open > div.details > div > div:nth-of-type(1) > div.regular-ticket > div.ticket-id"));

        return element;

    }

    public static WebElement get_detailedticketCodeandName(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket.payout.open > div.details > div > div:nth-of-type(1) > div.event > div.rivals"));

        return element;

    }

    public static WebElement get_detailedticketValue(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket.payout.open > div.details > div > div:nth-of-type(1) > div.payout > div.stake > div.right"));

        return element;

    }

    public static WebElement get_detailedticketgame(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket.payout.open > div.details > div > div:nth-of-type(1) > div.event > div:nth-of-type(2) > div > div:nth-of-type(2)"));

        return element;

    }

    public static WebElement get_detailedticketodd(WebDriver driver){

        element = driver.findElement(By.cssSelector(" div.ticket.payout.open > div.details > div > div:nth-of-type(1) > div.event > div:nth-of-type(2) > div.winning > div:nth-of-type(3)"));

        return element;

    }

    public static WebElement get_ticketID(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.ticket-wrapper > div:nth-of-type(1) > div.action > div.ticket-info"));

        return element;

    }

    public static WebElement checkTicket(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.dropdown.right.tooltip > div.wrapper > div.value"));

        return element;

    }


    public static WebElement ticketCheckInput(WebDriver driver){

        element = driver.findElement(By.id("ticket_check_input"));

        return element;

    }

    public static WebElement addButton(WebDriver driver){

        element = driver.findElement(By.className("add"));

        return element;

    }

    public static WebElement popupTicketview(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.regular-ticket > div.ticket-id"));

        return element;

    }

    public static WebElement popupTicketviewRivals(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.event > div.rivals"));

        return element;

    }

    public static WebElement popupTicketviewGame(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.event > div:nth-of-type(2) > div"));

        return element;

    }

    public static WebElement popupTicketviewClose(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.panel > div.actions > button"));

        return element;

    }

    public static WebElement lnk_closetikcet_checkticket_view(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.panel > div.actions > button"));

        return element;

    }








































}
