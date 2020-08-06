package com.edu.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selectors {

    WebDriver driver;
    @BeforeMethod

    public void setUp(){

        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/resources 1/chromedriver");
       driver = new ChromeDriver();
        driver.get("http://whiteboxqa.com/index.php");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

    }

    @Test

    public void selectors(){


       boolean logo = driver.findElement(By.id("logo")).isDisplayed();
       System.out.println(logo);
       String tagname = driver.findElement(By.cssSelector("div#footerbot > h4")).getTagName();
        System.out.println(tagname);

        driver.findElement(By.linkText("SCHEDULE")).click();

    }
    @Test
    public void footerLinks(){

        WebElement link = driver.findElement(By.cssSelector(".col-md-6.col-sm-12.col-xs-12.pull-right.social"));
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(links.size());

        for (int i = 1; i < links.size(); i++) {

            System.out.println(links.get(i).getText());
        }

    }

    @AfterMethod

    public void tearDown(){
        driver.quit();
    }




}