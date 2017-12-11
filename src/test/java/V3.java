import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class V3 {

    public static WebDriver driver = new ChromeDriver();
    public static ChromeOptions options = new ChromeOptions();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
    Date date = new Date();


    @BeforeTest

    public void login() throws InterruptedException {

        driver.get("http://stage.meridianbet.com:3100");
        driver.manage().window().maximize();
        options.addArguments("--disable-notifications");
        options.addArguments("start-fullscreen");

        //PROVERA DA LI POSTOJI LANDING PAGE
        Thread.sleep(3000);

        try {
            if (driver.findElement(By.cssSelector("div.lp-sections")).isDisplayed()) {
                driver.findElement(By.cssSelector("div.sections.four > a:nth-of-type(1) > div.wrapper > img")).click();
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("-- Ne postoji landing page -- ");

        }

        WebDriverWait waittt = new WebDriverWait(driver, 100);
        Object o = waittt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("button.button.signin")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //UCITAVANJE SAJTA
        try {
            if (driver.findElement(By.cssSelector("a.button.signup")).isDisplayed()) {
                System.out.println("-- Ucitavanje sajta uspesno --");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("--ERROR!!! Ucitavanje sajta neuspesno -- ");

        }


        //Log in

        LogIn_Page.txtbx_UserName(driver).sendKeys("savichi@stage.com");
        LogIn_Page.txtbx_Password(driver).sendKeys("1");
        Thread.sleep(1000);
        LogIn_Page.btn_LogIn(driver).click();
        Thread.sleep(3000);


    }

    @AfterTest

    public void logout() throws InterruptedException {

        driver.quit();

    }

    @BeforeMethod
    public void Home_Page() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(3000);
    }


    @Test(enabled = false)

    public void Check_balance() throws InterruptedException {

        //Provera stanja racuna
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.logout > div:nth-of-type(3) > div.wrapper")).click();
        String cash = driver.findElement(By.cssSelector("div.list > div:nth-of-type(2) > span")).getText();
        System.out.println("Keš:" + cash);
        String bonus = driver.findElement(By.cssSelector("div.logout > div:nth-of-type(3) > div.list > div:nth-of-type(3)")).getText();
        System.out.println("Bonus:" + bonus);

    }


    @Test(priority = 1, enabled = false)

    public void Create_ticket() throws InterruptedException {

        Thread.sleep(5000);
        Ticket_Create.lnk_Offer(driver).click();

        WebDriverWait wait_offer = new WebDriverWait(driver, 30);
        Object wo = wait_offer.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.padding > div:nth-of-type(1) > div.wrapper > div > event-list-item:nth-of-type(1) > div.match.standard")));

        Ticket_Create.lnk_Odds1(driver).click();
        Thread.sleep(1000);
        String eventname = Ticket_Create.get_eventname(driver).getText();
        String eventgame = Ticket_Create.get_eventgame(driver).getText();
        String eventodd = Ticket_Create.get_eventodd(driver).getText();
        String ticketvalue = Ticket_Create.get_ticketvalue(driver).getText();
        System.out.println(eventname + " game :" + eventgame + " odd: " + eventodd + " stake: " + ticketvalue);
        driver.findElement(By.cssSelector("button.submit")).click();
        Thread.sleep(3000);
        String pop_alert = Popup_Action.popup_alert(driver).getText();
        System.out.println(pop_alert);

        switch (pop_alert) {
            case "Tiket je Prihvaćen":
                Popup_Action.popup_button(driver).click();
                Thread.sleep(1000);
                break;
            case "Identična opklada je već odigrana":
                Popup_Action.popup_button(driver).click();
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("button.cancel")).click();
                Thread.sleep(1000);
                Ticket_Create.lnk_Odds2(driver).click();
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("button.submit")).click();
                Thread.sleep(1000);
                Popup_Action.popup_button(driver).click();
                break;
            default:
                Popup_Action.popup_button(driver).click();
                Thread.sleep(2000);
                driver.findElement(By.cssSelector("button.cancel")).click();
                Ticket_Create.lnk_Odds3(driver).click();
                Thread.sleep(2000);
                Popup_Action.popup_button(driver).click();
                break;
        }


    }

    @Test(priority = 2, enabled = false)

    public void CheckTicketMyTickets() throws InterruptedException {

        My_Tickets.lnk_OpenMyT(driver).click();
        Thread.sleep(5000);
        My_Tickets.lnk_viewTicket(driver).click();
        Thread.sleep(3000);
        String ticketID = My_Tickets.get_detailedticketAccandID(driver).getText();
        String ticketcodeandevent = My_Tickets.get_detailedticketCodeandName(driver).getText();
        System.out.println(ticketcodeandevent);
        String ticketgame = My_Tickets.get_detailedticketgame(driver).getText();
        String ticketvalueMT = My_Tickets.get_detailedticketValue(driver).getText();
        System.out.println(ticketgame + ticketvalueMT);

    }


    //Provera stanja racuna posle odigranog tiketa

    @Test(priority = 3, enabled = false)

    public void CheckinBalanceAfter() throws InterruptedException {


        driver.findElement(By.cssSelector("div.logout > div:nth-of-type(3) > div.wrapper")).click();

        String cash1 = driver.findElement(By.cssSelector("div.list > div:nth-of-type(2) > span")).getText();
        System.out.println("Keš:" + cash1);


        String bonus1 = driver.findElement(By.cssSelector("div.logout > div:nth-of-type(3) > div.list > div:nth-of-type(3)")).getText();
        System.out.println("Bonus:" + bonus1);

        //double x = Double.parseDouble(cash.split(" ")[0]);
        //double y = Double.parseDouble(cash1.split(" ")[0]);
        //System.out.println("Razlika na računu: "+(y-x));
        Thread.sleep(2000);


    }

    //KENO

    @Test(priority = 4, enabled = false)

    public void Keno() throws InterruptedException {

        //Go to Keno page

        Keno_Page.lnk_KenoButton(driver).click();
        Thread.sleep(4000);

        //Izaberi dva random boja

        Keno_Page.lnk_KenoRandomFirst(driver).click();
        Thread.sleep(1000);
        Keno_Page.lnk_KenoRandomSecond(driver).click();
        Thread.sleep(1000);

        //Izaberi random keno sistem

        Keno_Page.lnk_KenoSystem(driver).click();
        String kenosistem = Keno_Page.lnk_KenoSystem(driver).getText();
        System.out.println("Izabrani keno sistem: " + kenosistem);
        Thread.sleep(1000);

        //Potvrdi keno opkladu

        Keno_Page.lnk_KenoSubmit(driver).click();
        Thread.sleep(1000);

        //Vreme keno izvlacenja

        System.out.println("VAZNO!!! - Vreme keno izvlacenja mora biti manje od 6 min od trenutnog vremena!!!");
        Date_Picker.GetTimeDate(driver);
        String kenodate = Ticket_Create.get_kenoeventname(driver).getText();
        String[] kenominute = kenodate.split("[\\:\\)]");
        double q = Double.parseDouble(kenominute[1]);
        String date1 = dateFormat.format(date);
        String[] dateminute = date1.split("\\:");
        double y = Double.parseDouble(dateminute[1]);
        System.out.println("Izabrano Keno izvlacenje pocinje za: " + (q - y) + " minuta");

        //Potvrdi opkladu

        Ticket_Create.lnk_submitbutton(driver).click();
        Thread.sleep(1000);
        Popup_Action.popup_button(driver).click();
        Thread.sleep(3000);

    }

    //POWERLEAGUES

    @Test(priority = 5, enabled = false)

    public void PowerLeagues() throws InterruptedException {


        //Idi na PowerLeagues (Fudbal danas)
        Main_Menu.lnk_PowerLeagues(driver).click();
        Thread.sleep(4000);

        List<WebElement> items2 = driver.findElements(By.cssSelector("div.category.featured.sport.open > div.dropdown > sidebar-league-component"));
        System.out.println("POWER LEAGUES : ");

        int count = 0;
        for (WebElement located_element : items2) {
            System.out.println(count + "  " + located_element.getText());

            count++;

        }

        System.out.println("Broj Liga u Power Leagues : " + count);
        Home_Page.lnk_MyAccount(driver).click();
        Thread.sleep(2000);
    }

    @Test(priority = 6, enabled = false)

    public void CheckTicket() throws InterruptedException {

        My_Tickets.lnk_OpenMyT(driver).click();
        Thread.sleep(3000);
        String TicketID = My_Tickets.get_ticketId(driver).getText();
        System.out.println(TicketID);

        My_Tickets.lnk_viewTicket(driver).click();
        Thread.sleep(3000);
        String ticketID = My_Tickets.get_detailedticketAccandID(driver).getText();
        String ticketcodeandevent = My_Tickets.get_detailedticketCodeandName(driver).getText();
        System.out.println(ticketcodeandevent);
        String ticketgame = My_Tickets.get_detailedticketgame(driver).getText();
        String ticketvalueMT = My_Tickets.get_detailedticketValue(driver).getText();
        System.out.println(ticketgame + ticketvalueMT);


        My_Tickets.checkTicket(driver).click();
        Thread.sleep(1000);
        My_Tickets.ticketCheckInput(driver).sendKeys(TicketID);
        My_Tickets.addButton(driver).click();
        Thread.sleep(3000);
        String TicketIDPopup = My_Tickets.popupTicketview(driver).getText();
        System.out.println(TicketIDPopup);
        String TicketRivalsPopup = My_Tickets.popupTicketviewRivals(driver).getText();
        System.out.println(TicketRivalsPopup);
        String TicketGamePopup = My_Tickets.popupTicketviewGame(driver).getText();
        System.out.println(TicketGamePopup);
        Thread.sleep(2000);
        My_Tickets.popupTicketviewClose(driver).click();
        Thread.sleep(2000);
        Home_Page.lnk_MyAccount(driver).click();
        Thread.sleep(2000);


    }

    @Test(priority = 7, enabled = false)

    public void OddsType() throws InterruptedException {

        Ticket_Create.lnk_Offer(driver).click();
        Thread.sleep(3000);
        String oddstype = Odds_Type.OddsType(driver).getText();
        String odds = Ticket_Create.lnk_Odds1(driver).getText();
        System.out.println(" *** Format kvota *** ");
        System.out.println(oddstype + " kvote su: " + odds);
        Odds_Type.lnk_OddsType(driver).click();
        Thread.sleep(1000);
        Odds_Type.check_OddsType1(driver).click();
        Thread.sleep(1000);
        String oddstype1 = Odds_Type.OddsType(driver).getText();
        String odds1 = Ticket_Create.lnk_Odds1(driver).getText();
        System.out.println(oddstype1 + " kvote su: " + odds1);
        Odds_Type.lnk_OddsType(driver).click();
        Thread.sleep(1000);
        Odds_Type.check_OddsType2(driver).click();
        Thread.sleep(1000);
        String oddstype2 = Odds_Type.OddsType(driver).getText();
        Thread.sleep(1000);
        String odds2 = Ticket_Create.lnk_Odds1(driver).getText();
        System.out.println(oddstype2 + " kvote su: " + odds2);
        Thread.sleep(2000);

    }

    @Test(priority = 8, enabled = false)

    public void Turbo() throws InterruptedException {
        My_Tickets.lnk_OpenMyT(driver).click();
        Thread.sleep(3000);
        String TicketID = My_Tickets.get_ticketId(driver).getText();
        System.out.println(" Proveravam tiket: " + TicketID);
        My_Tickets.get_ticketId(driver).click();
        Thread.sleep(4000);

        try {
            if (Turbo.Turbo_button_MyT(driver).isDisplayed()) {
                System.out.println("-- TURBO Cash je dostupan u My Tickets -- ");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("-- TURBO Cash NIJE dostupan u My Tickets -- ");
        }

        Home_Page.lnk_username(driver).click();
        Thread.sleep(1000);
        Home_Page.lnk_MyAccount(driver).click();
        Thread.sleep(2000);
        My_Account.lnk_Mytickets(driver).click();
        Thread.sleep(1500);
        My_Account.lnk_FirstTicket(driver).click();
        Thread.sleep(2000);
        try {
            if (Turbo.Turbo_button_CheckTicketView(driver).isDisplayed()) {
                System.out.println("-- TURBO Cash je dostupan u MyAccount-u -- ");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("-- Ne postoji TURBO Cash opcija u My Account-u -- ");
            My_Tickets.lnk_closetikcet_checkticket_view(driver).click();

        }
        My_Tickets.lnk_closetikcet_checkticket_view(driver).click();
        Thread.sleep(1000);
        My_Account.lnk_Close_MyAccount(driver).click();
        Thread.sleep(1000);


        My_Tickets.checkTicket(driver).click();
        Thread.sleep(1000);
        My_Tickets.ticketCheckInput(driver).sendKeys(TicketID);
        Thread.sleep(2000);
        My_Tickets.addButton(driver).click();
        Thread.sleep(3000);

        //Provera da li postoji turbo na tiketu iz ticket check view-a
        try {
            if (Turbo.Turbo_button_CheckTicketView(driver).isDisplayed()) {
                System.out.println("-- TURBO Cash je dostupan u Check Ticket -- ");
                Turbo.Turbo_button_CheckTicketView(driver).click();
                System.out.println("-- Trazim TURBO isplatu -- ");

            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("-- Ne postoji TURBO Cash opcija u Check Ticket -- ");
            My_Tickets.lnk_closetikcet_checkticket_view(driver).click();

        }

        Thread.sleep(4000);

        // Provera da li se pojavljuje turbo popup
        try {
            if (Turbo.Turbo_Popup(driver).isDisplayed()) {
                System.out.println("-- TURBO Pop-up je prikazan -- ");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("!!! ERROR -- TURBO Pop-up NIJE je prikazan -- ");

        }
        System.out.println("-- Ponudjene opcije za Turbo Cash -- ");
        String ten = Turbo.Ten_Percentage(driver).getText();
        String all = Turbo.Accept_All(driver).getText();
        String high = Turbo.Only_Higher(driver).getText();
        System.out.println("* " + ten + "\n" + "* " + all + "\n" + "* " + high);
        String turboticketID = Turbo.Turbo_Popup_TicketID(driver).getText();
        String[] partss = turboticketID.split("\\s");
        String part3 = partss[1];
        System.out.println("Turbo cash ponudjen za tiket : " + part3);
        String turbooffer = Turbo.Turbo_Offer(driver).getText();
        System.out.println("Ponudjen TURBO Cash : " + turbooffer);
        Turbo.lnk_Turbobutton_ticketcheckview(driver).click();
        Thread.sleep(5000);

        String turbopayout = Turbo.Turbo_payout_message(driver).getText();
        String turboticketID2 = Turbo.Turbo_Popup_TicketID(driver).getText();
        String[] parts = turboticketID2.split("\\s");
        String part2 = parts[1];
        System.out.println("Turbo cash isplacen za tiket : " + part2);
        System.out.println(turbopayout);

        Turbo.lnk_OK_Turbo_pop_up_payout_ticketcheckview(driver).click();

    }

    @Test(priority = 3)
    public void EmptyBet() throws InterruptedException {

        EmptyBet.lnk_EmptyBet(driver).click();

        try {
            if (EmptyBet.EmptyBet_Popup(driver).isDisplayed()) {
                System.out.println("-- EMPTY BET Pop-up je prikazan -- ");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("!!! ERROR -- EMPTY BET Pop-up NIJE je prikazan -- ");

        }

        EmptyBet.EmptyBet_Event(driver).click();
        EmptyBet.EmptyBet_Game(driver).click();
        EmptyBet.EmptyBet_Event(driver).click();

        String ebeventerror = EmptyBet.EmptyBet_Event_Errormessage(driver).getText();
        String ebgameerror = EmptyBet.EmptyBet_Game_Errormessage(driver).getText();
        System.out.println("Error poruke Empty Bet : ");
        System.out.println(ebeventerror);
        System.out.println(ebgameerror);
        System.out.println(" *** Provera Error EB poruka *** ");
        for (int i = 0; i < 7; ) {
            EmptyBet.EmptyBet_Event(driver).sendKeys("" + i);
            EmptyBet.EmptyBet_Game(driver).click();
            System.out.println("Unet znak : " + i);
            try {
                if (EmptyBet.EmptyBet_Event_Errormessage(driver).isDisplayed()) {
                    String eventerror = EmptyBet.EmptyBet_Event_Errormessage(driver).getText();
                    System.out.println(eventerror);
                }
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                System.out.println("Nema error poruke !!! ");

            }

            i++;

        }

        for (int i = 0; i < 5; ) {

            EmptyBet.EmptyBet_Game(driver).sendKeys("" + i);
            EmptyBet.EmptyBet_Event(driver).click();
            System.out.println("Unet znak : " + i);
            try {
                if (EmptyBet.EmptyBet_Game_Errormessage(driver).isDisplayed()) {
                    String gameerror = EmptyBet.EmptyBet_Game_Errormessage(driver).getText();
                    System.out.println(gameerror);
                }
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                System.out.println("Nema error poruke !!! ");

            }

            i++;
        }

        try {
            if (EmptyBet.lnk_EmptyBet_Confirm(driver).isDisplayed()) {
                System.out.println("Dugme PRIHVATI je dostupno ");
            }
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            System.out.println("ERROR !!! - Dugme PRIVATI nije dostupno ");


        }

        EmptyBet.lnk_EmptyBet_Confirm(driver).click();
        Thread.sleep(2000);
        Ticket_Create.lnk_submitbutton(driver).click();

        Thread.sleep(10000);

        String ticketEB = driver.findElement(By.cssSelector("div.panel > div.title")).getText();
        System.out.println(ticketEB);

        //naci nacin da se uhvati pravi pop-up

        WebDriverWait waitzzz = new WebDriverWait(driver, 100);
        Object ty = waitzzz.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#ticket-output")));

        EmptyBet.lnk_EmptyBet_Confirm(driver).click();
        Thread.sleep(4000);
        Popup_Action.popup_button(driver).click();

        Thread.sleep(10000);


    }

}



