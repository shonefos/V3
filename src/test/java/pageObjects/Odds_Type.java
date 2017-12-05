package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Odds_Type {


    private static WebElement element = null;

    public static WebElement OddsType(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.top > div:nth-of-type(3) > div.wrapper > div.value"));

        return element;

    }

    public static WebElement check_OddsType(WebDriver driver){

        element = driver.findElement(By.cssSelector("#page > div:nth-of-type(1) > div.wrapper > div > event-list-item > div.match.standard > games-component > div.games > div:nth-of-type(1) > div.three > div:nth-of-type(1) > div > div:nth-of-type(2)"));

        return element;

    }

    public static WebElement lnk_OddsType(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.top > div:nth-of-type(3) > div.wrapper > div.value"));

        return element;

    }



    public static WebElement check_OddsType1(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.top > div:nth-of-type(3) > div.list > a:nth-of-type(1)"));

        return element;

    }

    public static WebElement check_OddsType2(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.list > a:nth-of-type(3)"));

        return element;

    }












}
