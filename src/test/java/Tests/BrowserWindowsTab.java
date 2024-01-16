package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTab {
    public WebDriver driver;

    @Test
    public void automationMethod() {
        // deschidem un browser de Chrome
        driver = new ChromeDriver();
        // accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browsewrul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll; 0 si 400 sunt coordonatele
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        WebElement browserWindowsElement=driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsElement.click();

        WebElement tabElement=driver.findElement(By.id("tabButton"));
        tabElement.click();

        //getWindowHandles returneaza toate windows deschise in browser
        List<String> tabList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement sampleHeadingElement=driver.findElement(By.id("sampleHeading"));
        System.out.println("textul din noul tab este: "+sampleHeadingElement.getText());

        driver.close();

        //al 2-lea buton
        //revin cu focusul la primul tab
        driver.switchTo().window(tabList.get(0));
        WebElement windowButtonElement=driver.findElement(By.id("windowButton"));
        windowButtonElement.click();

        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement sampleHeadingWindowElement=driver.findElement(By.id("sampleHeading"));
        System.out.println("textul din noul window este: "+sampleHeadingWindowElement.getText());

        driver.close();
        driver.switchTo().window(windowList.get(0));





    }
}
