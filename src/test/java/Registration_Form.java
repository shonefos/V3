
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

// Import package pageObject.*

import pageObjects.*;


/**
 * Created by Meridian on 9/26/2017.
 */
public class Registration_Form {


    public static void main(String[] args) throws InterruptedException {

        //Proverava koji je Operativni Sistem
        //switch (CheckOS.getOS()) {
        //    case WINDOWS:
        //        System.setProperty("webdriver.chrome.driver", "src\\Selenium\\Chromedriver\\chromedriver.exe");
        //        break;
        //    case MAC:
        //        System.setProperty("webdriver.chrome.driver", "src/Selenium/chromedriver2");
        //        break;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://meridianbet.rs");
        driver.manage().window().maximize();


        //PROVERA DA LI POSTOJI LANDING PAGE
        Thread.sleep(3000);

        try {
            if (driver.findElement(By.cssSelector("div.lp-sections")).isDisplayed()) {
                driver.findElement(By.cssSelector("button.signup")).click();
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("-- Ne postoji landing page -- ");

        }
        WebDriverWait waitt = new WebDriverWait(driver, 100);
        Object o = waitt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("button.button.signin")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //UCITAVANJE SAJTA
        try {
            if (driver.findElement(By.cssSelector("a.button.signup")).isDisplayed()) {
                System.out.println("-- Ucitavanje sajta uspesno --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR!!! Ucitavanje sajta neuspesno -- ");

        }


        //Validacione poruke STEP 1
        String firststep = driver.findElement(By.cssSelector("div.steps > div:nth-of-type(1) > div.name")).getText();
        System.out.println(firststep);
        driver.findElement(By.cssSelector("#firstName")).click();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(2) > label > input")).click();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > label > input")).click();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(5) > label > input")).click();
        jse.executeScript("scroll(0, 150);");
        driver.findElement(By.cssSelector("form > div:nth-of-type(6) > label > input")).click();
        Select oSelect = new Select(driver.findElement(By.cssSelector("#stateSelect")));
        oSelect.selectByValue("Angola");

        System.out.println("-- Provera Error poruka na praznim poljima --");
        String firstname = driver.findElement(By.cssSelector("form > div:nth-of-type(1) > div.error")).getText();
        System.out.println("*first name: " + firstname);
        String lastname = driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(2) > div.error")).getText();
        System.out.println("*last name: " + lastname);
        String email = driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > div.error")).getText();
        System.out.println("*email: " + email);
        String password = driver.findElement(By.cssSelector("form > div:nth-of-type(5) > div.error")).getText();
        System.out.println("*password: " + password);

        try {
            if (driver.findElement(By.cssSelector("button.button.next.disabled")).isDisplayed()) {
                System.out.println("-- Dugme za Registraciju je DISABLE sto je OK!!!! --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR Dugme za Registraciju je ENABLE sto nije OK!!!! --");

        }


        //Unos podataka u registracionu formu

        System.out.println("-- Unosim validne podatke u registracionu formu --");
        driver.findElement(By.cssSelector("#firstName")).sendKeys(RandomStringUtils.randomAlphabetic(6));
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(2) > label > input")).sendKeys(RandomStringUtils.randomAlphabetic(6));
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > label > input")).sendKeys("selenium@merbet.com");
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(5) > label > input")).sendKeys("Meridian@01");
        driver.findElement(By.cssSelector("form > div:nth-of-type(6) > label > input")).sendKeys("Meridian@01");
        driver.findElement(By.cssSelector("form > div:nth-of-type(8) > label > div.checkbox > input")).click();
        System.out.println("-- Svi podaci u registracionoj formi uneti --");

        try {
            if (driver.findElement(By.cssSelector("button.button.next")).isDisplayed()) {
                System.out.println("-- Dugme za Registraciju je ENABLE sto je OK!!!! --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR Dugme za Registraciju je DISABLE sto nije OK!!!! --");

        }

        //provera e-mail validacije
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > label > input")).clear();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > label > input")).sendKeys("s");
        System.out.println("Unosim jedno slovo");
        String valemail = driver.findElement(By.cssSelector("div.input.alert > div.error")).getText();
        System.out.println(valemail);
        try {
            if (driver.findElement(By.cssSelector("button.button.next.disabled")).isDisplayed()) {
                System.out.println("-- Dugme za Registraciju je DISABLE sto je OK!!!! --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR Dugme za Registraciju je ENABLE sto nije OK!!!! --");

        }
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > label > input")).clear();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > label > input")).sendKeys("selenium@");
        System.out.println("Unosim jedno slovo + @");
        String valemail1 = driver.findElement(By.cssSelector("div.input.alert > div.error")).getText();
        System.out.println(valemail1);
        try {
            if (driver.findElement(By.cssSelector("button.button.next.disabled")).isDisplayed()) {
                System.out.println("-- Dugme za Registraciju je DISABLE sto je OK!!!! --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR Dugme za Registraciju je ENABLE sto nije OK!!!! --");

        }
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > label > input")).clear();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(2) > form > div:nth-of-type(3) > label > input")).sendKeys("selenium@merbet.com");
        System.out.println("Unosim ispravnu email adresu");
        try {
            if (driver.findElement(By.cssSelector("div.input.alert > div.error")).isDisplayed()) {
                System.out.println("-- ERROR Poruka za netacan email je prisutna !!!! --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--Ispravno unesen email, error poruka ne postoji!!!! --");

        }
        //Predji na drugu stranu
        driver.findElement(By.cssSelector("button.button.next")).click();

        //Validacione poruke STEP 2
        String secondstep = driver.findElement(By.cssSelector("div.steps > div:nth-of-type(2) > div.name")).getText();
        System.out.println(secondstep);
        String pol = driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(1) > label")).getText();
        System.out.println(pol);
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(2) > label > input")).click();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(3) > label > input")).click();
        driver.findElement(By.cssSelector("form > div:nth-of-type(4) > label > input")).click();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(3) > label > input")).click();
        try {
            if (driver.findElement(By.cssSelector("button.button.next.disabled")).isDisplayed()) {
                System.out.println("-- Dugme za Registraciju je DISABLE sto je OK!!!! --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR Dugme za Registraciju je ENABLE sto nije OK!!!! --");

        }
        String street = driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(2) > div.error")).getText();
        System.out.println("*ulica:" + street);
        String city = driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(3) > div.error")).getText();
        System.out.println("*grad:" + city);
        driver.findElement(By.cssSelector("form > div:nth-of-type(4) > label > input")).clear();
        driver.findElement(By.cssSelector("form > div:nth-of-type(4) > label > input")).click();
        String phone = driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(4) > div.error")).getText();
        System.out.println("*telefon:" + phone);
        try {
            if (driver.findElement(By.cssSelector("form > div:nth-of-type(7) > label > div.checkbox > input")).isSelected()) {
                System.out.println("-- Checkbox je selektovan sto je OK!!!! --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR Checkbox nije selektovan sto je OK sto nije OK!!!! --");

        }

        //Popunjavanje validnih podataka
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(2) > label > input")).sendKeys(RandomStringUtils.randomAlphabetic(6));
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > form > div:nth-of-type(3) > label > input")).sendKeys(RandomStringUtils.randomAlphabetic(6));
        driver.findElement(By.cssSelector("form > div:nth-of-type(4) > label > input")).clear();
        driver.findElement(By.cssSelector("form > div:nth-of-type(4) > label > input")).sendKeys("+" + RandomStringUtils.randomNumeric(12));
        try {
            if (driver.findElement(By.cssSelector("button.button.next")).isDisplayed()) {
                System.out.println("-- Dugme za Registraciju je ENABLE sto je OK!!!! --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR Dugme za Registraciju je DISABLE sto nije OK!!!! --");

        }
        jse.executeScript("scroll(0, -150);");

        // Pocetna strana
        driver.findElement(By.cssSelector("div.logo > img")).click();
        WebDriverWait waitz = new WebDriverWait(driver, 100);
        Object j = waitz.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.live-matches > div.wrapper > h2.title")));

        Thread.sleep(5000);
        driver.quit();

    }
}
