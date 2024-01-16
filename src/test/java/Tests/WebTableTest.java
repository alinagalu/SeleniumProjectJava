package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod(){
        // deschidem un browser de Chrome
        driver=new ChromeDriver();
        // accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browsewrul in modul maximize
        driver.manage().window().maximize();

        //se poate cauta elementul cu xpath sau css daca nu avem ID
        // cel cu // e relativ si cu acela lucram
        //Click dreapta si inspect elements, cautam elementul
        //dam ctrl+f si scriem //h5[text()='Elements']
        //trebuie sa fie 1 din 1

        //facem un scroll; 0 si 400 sunt coordonatele
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declaram un element
        WebElement ElementsField=driver.findElement(By.xpath("//h5[text()='Elements']"));
        ElementsField.click();

        WebElement WebTableField=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        WebTableField.click();

        List<WebElement> tableElement = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tableElement.size();

        WebElement AddField=driver.findElement(By.id("addNewRecordButton"));
        AddField.click();

        WebElement FirstNameField=driver.findElement(By.id("firstName"));
        String firstNameValue="Alina";
        FirstNameField.sendKeys(firstNameValue);

        WebElement LastNameField=driver.findElement(By.id("lastName"));
        String lastNameValue="Galu";
        LastNameField.sendKeys(lastNameValue);

        WebElement EmailField=driver.findElement(By.id("userEmail"));
        String emailValue="testing@testing.com";
        EmailField.sendKeys(emailValue);

        WebElement AgeField=driver.findElement(By.id("age"));
        String ageValue="25";
        AgeField.sendKeys(ageValue);

        WebElement SalaryField=driver.findElement(By.id("salary"));
        String salaryValue="25";
        SalaryField.sendKeys(salaryValue);

        WebElement DepartmentField=driver.findElement(By.id("department"));
        String departmentValue="HR";
        DepartmentField.sendKeys(departmentValue);

        WebElement SubmitField=driver.findElement(By.id("submit"));
        SubmitField.click();


        //se valideaza faptul ca lista s-a marit cu un element
        List<WebElement> expectedtableElement = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer expectedTableSize = actualTableSize+1;
        Assert.assertEquals(expectedtableElement.size(), expectedTableSize);

        //se valideaza valorile ultimului rand completat
        String actualTableValue = expectedtableElement.get(3).getText();
        System.out.println("sirul este: "+ expectedtableElement.get(3).getText());
        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));

        WebElement submitElement = driver.findElement(By.id("submit"));



    }


}
