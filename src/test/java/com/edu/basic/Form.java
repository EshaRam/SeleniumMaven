package com.edu.basic;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Form {
    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/resources 1/chromedriver 2");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
    }

    @Test

    public void form() throws InterruptedException {

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
        //driver.findElement(By.id("email")).sendKeys("Esha");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("eee123");

        Actions action = new Actions(driver);
        WebElement password = driver.findElement(By.xpath("//input[@name='firstName']"));
        action.keyDown(password, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        WebElement username = driver.findElement(By.id("email"));
        action.keyDown(username, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        //action.keyDown(Keys.CONTROL ).sendKeys( "v" ).keyUp( Keys.CONTROL ).build().perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//td/input[@name='register']")).click();
    }
    @AfterMethod

    public void teardown(){
        driver.close();
    }

}
