package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main_Menu {


    private static WebElement element = null;


    public static WebElement lnk_FootballToday(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.sport.football-today"));

        return element;

    }

    public static WebElement lnk_PowerLeagues(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.sidebar-wrapper > div:nth-of-type(2) > div.title > div.arrow > span.icon"));

        return element;

    }






}
