package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Meridian on 11/4/2017.
 */
public class Date_Picker {

    private static WebElement element = null;

    public static void GetTimeDate(WebDriver driver) {


        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        //System.out.println("Trenutan datum i vreme je: " + date1);
        String[] splitdate = date1.split("\\s+");
        System.out.println("Trenutno vreme:" + splitdate[1]);
        //String[] dateminute = date1.split("\\:");
        //System.out.println(dateminute[1]);
        //double y = Double.parseDouble(dateminute[1]);


    }
}






