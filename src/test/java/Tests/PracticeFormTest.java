package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {
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

        WebElement formElement=driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement practiceFormElement=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormElement.click();

        WebElement firstNameElement=driver.findElement(By.id("firstName"));
        String firstNameValue="Andrei";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement=driver.findElement(By.id("lastName"));
        String lastNameValue="Ionescu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement=driver.findElement(By.id("userEmail"));
        String userEmailValue="a.ionescu@email.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement mobileNumerElement= driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue="0789456123";
        mobileNumerElement.sendKeys(mobileNumberValue);

        WebElement pictureElement=driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/1.jpg");
        pictureElement.sendKeys(file.getAbsolutePath());

        WebElement MaleElement= driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement FemaleElement= driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement OtherElement= driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String Gender="Other";
        if(MaleElement.getText().equals(Gender))
        {
         MaleElement.click();
        }
        else if (FemaleElement.getText().equals(Gender)) {
            FemaleElement.click();
        }
        else if (OtherElement.getText().equals(Gender)) {
            OtherElement.click();
        }

        WebElement SubjectsElement= driver.findElement(By.id("subjectsInput"));
        String SubjectsValue="Social Studies";
        SubjectsElement.sendKeys(SubjectsValue);
        SubjectsElement.sendKeys(Keys.ENTER);

        WebElement StateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();",StateElement);
        StateElement.sendKeys("NCR");
        StateElement.sendKeys(Keys.ENTER);

        WebElement CityElement=driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();",CityElement);
        CityElement.sendKeys("Delhi");

    }

}
