package com.edu.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment3 {

    WebDriver driver;


    @BeforeMethod

    public void setUp (){

        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/resources 1/chromedriver 2");
         driver = new ChromeDriver();
         driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }

    @Test
     public void assignment3()  {
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();



        Actions action = new Actions(driver);

        WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
        WebElement employee = driver.findElement(By.id("menu_pim_viewEmployeeList"));

        action.moveToElement(PIM).moveToElement(employee).click().build().perform();


        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        int rowcount = rows.size();

        for (int i=1;i<= rowcount;i++){
            String firstname = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[3]")).getText();
            String lastname = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[4]")).getText();
            String jobtitle = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[5]")).getText();
            System.out.println(firstname + " " + lastname + " - " +  jobtitle);

        }


    }

    @AfterMethod

    public void teardown(){
        driver.close();
    }
}
