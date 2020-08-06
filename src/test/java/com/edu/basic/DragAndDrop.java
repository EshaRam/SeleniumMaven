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

public class DragAndDrop {
    WebDriver driver;

    @BeforeMethod

    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/resources 1/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        }

        @Test

           public void DragAndDrop() throws InterruptedException {


            WebElement madrid = driver.findElement(By.id("box7"));
            WebElement spain = driver.findElement(By.id("box107"));
            WebElement rome = driver.findElement(By.id("box6"));
            WebElement italy = driver.findElement(By.id("box106"));
            WebElement copenhagen = driver.findElement(By.id("box4"));
            WebElement denmark = driver.findElement(By.id("box104"));
            WebElement washington = driver.findElement(By.id("box3"));
            WebElement unitedstates = driver.findElement(By.id("box103"));
            WebElement oslo = driver.findElement(By.id("box1"));
            WebElement norway = driver.findElement(By.id("box101"));
            WebElement seoul = driver.findElement(By.id("box5"));
            WebElement southkorea = driver.findElement(By.id("box105"));
            WebElement stockholm = driver.findElement(By.id("box2"));
            WebElement sweden = driver.findElement(By.id("box102"));


            Actions action = new Actions(driver);

            action.dragAndDrop(madrid,spain).build().perform();
            action.dragAndDrop(rome,italy).build().perform();
            action.dragAndDrop(copenhagen,denmark).build().perform();
            action.dragAndDrop(washington,unitedstates).build().perform();
            action.dragAndDrop(oslo,norway).build().perform();
            action.dragAndDrop(seoul,southkorea).build().perform();
            action.dragAndDrop(stockholm,sweden).build().perform();

            Thread.sleep(5000);

        }

        @AfterMethod

        public void teardown(){
            driver.close();
        }
    }


