package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by Meridian on 11/4/2017.
 */
public class Keno_Page {

    private static WebElement element = null;





    public static WebElement lnk_KenoButton(WebDriver driver){



        element = driver.findElement(By.cssSelector("ul > li:nth-of-type(5) > a.button"));

        return element;

    }

    public static WebElement lnk_KenoRandomFirst(WebDriver driver){

        Random ran = new Random();
        int x = ran.nextInt(80) + 1;
        String numberstr = Integer.toString(x);
        String kenonum1 = "div:nth-of-type("+numberstr+")";

        element = driver.findElement(By.cssSelector("div.picker > " +kenonum1+ " > div.height-wrapper > div.number"));

        return element;

    }

    public static WebElement lnk_KenoRandomSecond(WebDriver driver){

        Random ran = new Random();
        int z = ran.nextInt(80) + 1;
        String numberstr1 = Integer.toString(z);
        String kenonum2 = "div:nth-of-type("+numberstr1+")";

        element = driver.findElement(By.cssSelector("div.picker > " +kenonum2+ " > div.height-wrapper > div.number"));

        return element;

    }

    public static WebElement lnk_KenoSubmit(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.action-wrapper > div.button.primary"));

        return element;

    }

    public static WebElement lnk_KenoSystem(WebDriver driver){

        Random ran = new Random();
        int x = ran.nextInt(3) + 1;
        String numberstr = Integer.toString(x);
        String keno = "div:nth-of-type("+numberstr+")";

        element = driver.findElement(By.cssSelector("div.action-wrapper > div.tabs > div:nth-of-type("+numberstr+")"));

        return element;

    }



}
