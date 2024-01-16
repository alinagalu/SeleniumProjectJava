package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
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

        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        frameElement.click();

        WebElement frame1Element = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);

        WebElement sampleHeadingFrameElemen = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new window este: "+sampleHeadingFrameElemen.getText());

        //ducem focusul pe pagina principala - se foloseste la frame-uri
        driver.switchTo().defaultContent();



    }
}
