package com.edu.basic;

import com.google.common.primitives.Booleans;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment1 {

    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/resources 1/chromedriver 2");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
    }
    @Test

    public void Assignment() throws InterruptedException {



        driver.findElement(By.linkText("REGISTER")).click();
        Thread.sleep(3000);

        String text = driver.findElement(By.linkText("REGISTER")).getText();
        System.out.println(text);
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Esha");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Ram");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.id("userName")).sendKeys("Esha@gmail.com");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("333, W las positas");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pleasanton");
        driver.findElement(By.xpath("//td/input[@name='register']")).click();

        Thread.sleep(3000);
        //driver.findElement(By.ByCssSelector.cssSelector("tr:nth-of-type(3) > td > p:nth-of-type(2) > font")).getText();



         String expectedMessage = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
        String message = driver.findElement(By.ByCssSelector.cssSelector("tr:nth-of-type(3) > td > p:nth-of-type(2) > font")).getText();
        Assert.assertTrue( message.contains(expectedMessage),"Registeration done");
        System.out.println(message);
    }
    @AfterMethod

    public void teardown (){
        driver.close();
    }
}
