package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Meridian on 10/26/2017.
 */
public class Ticket_Create {

    private static WebElement element = null;


    public static WebElement lnk_Offer(WebDriver driver)    {

        element = driver.findElement(By.cssSelector("div.sidebar-wrapper > div:nth-of-type(5) > div.title > a.link > div.name"));

        return element;

    }

    public static WebElement lnk_Odds1(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.padding > div:nth-of-type(1) > div.wrapper > div > event-list-item > div.match.standard > games-component > div.games > div:nth-of-type(1) > div.three > div:nth-of-type(1) > div > div:nth-of-type(2)"));

        return element;

    }

    public static WebElement lnk_Odds2(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.padding > div:nth-of-type(1) > div.wrapper > div > event-list-item > div.match.standard > games-component > div.games > div:nth-of-type(1) > div.three > div:nth-of-type(2) > div > div:nth-of-type(1)"));

        return element;

    }

    public static WebElement lnk_Odds3(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.padding > div:nth-of-type(1) > div.wrapper > div > event-list-item > div.match.standard > games-component > div.games > div:nth-of-type(1) > div.three > div:nth-of-type(3) > div > div:nth-of-type(1)"));

        return element;

    }
    public static WebElement txtbx_stake(WebDriver driver) {

        element = driver.findElement(By.cssSelector("#stake-input"));

        return element;

    }

    public static WebElement get_eventname(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.rivals > div.name"));

        return element;

    }

    public static WebElement get_eventgame(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.game-wrapper > div:nth-of-type(2)"));

        return element;

    }

    public static WebElement get_eventodd(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.odd"));

        return element;

    }

    public static WebElement get_ticketvalue(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.payment > div:nth-of-type(1) > div.value"));

        return element;

    }

    public static WebElement lnk_submitbutton(WebDriver driver) {

        element = driver.findElement(By.cssSelector("button.submit"));

        return element;

    }











    public static WebElement get_kenoeventname(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div.drawing"));
        String kenodate = driver.findElement(By.cssSelector("div.drawing")).getText();
        String[] splitkeno = kenodate.split("[\\(\\)]");
        System.out.println("Vreme keno izvlacenja je:" + splitkeno[1]);
        //String[] kenominute = kenodate.split("[\\:\\)]");
        //System.out.println(kenominute[1]);
        //double x = Double.parseDouble(kenominute[1]);
        return element;

    }

}


