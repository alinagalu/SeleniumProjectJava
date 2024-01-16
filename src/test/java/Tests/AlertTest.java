package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void automationMethod() {
        // deschidem un browser de Chrome
        driver = new ChromeDriver();
        // accesam o pagina web
        driver.get("https://demoqa.com/");

        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //facem browsewrul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll; 0 si 400 sunt coordonatele
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        WebElement alertElement=driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertElement.click();

        WebElement alertOkElement= driver.findElement(By.id("alertButton"));
        alertOkElement.click();

        Alert alertOk=driver.switchTo().alert();
        //ne mutam cu focusul pe alerta pentru a putea lucra cu ea

        alertOk.accept();

        WebElement alertDelayElement= driver.findElement(By.id("timerAlertButton"));
        alertDelayElement.click();

        //definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertDelay=driver.switchTo().alert();
        alertDelay.accept();

        WebElement alertConfirmationElement= driver.findElement(By.id("confirmButton"));
        alertConfirmationElement.click();

        Alert alertConfirmation=driver.switchTo().alert();
        alertConfirmation.dismiss();

        WebElement alertPromptElement= driver.findElement(By.id("promtButton"));
        alertPromptElement.click();
        Alert alertPrompt=driver.switchTo().alert();
        alertPrompt.sendKeys("Alina");
        alertPrompt.accept();


    }
}