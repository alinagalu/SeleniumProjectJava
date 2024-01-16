package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class Recursivitate {
    public WebDriver driver;

    @Test

    public void parcurgereListe()
    {
        // deschidem un browser de Chrome
        driver = new ChromeDriver();
        // accesam o pagina web
        driver.get("https://demoqa.com/sortable");

        //facem browsewrul in modul maximize
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i=0;i<list.size()-1;i++)
        {
            WebElement webElement = list.get(i);
            WebElement urmatorulElement = list.get(i++);
            System.out.println("Numarul elementuli este "+webElement.getText());
            actions.clickAndHold(webElement)
                    .moveToElement(urmatorulElement)
                    .release()
                    .build()
                    .perform();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
