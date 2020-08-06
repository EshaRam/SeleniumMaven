import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment10 {
    WebDriver driver;
    @BeforeMethod
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/resources 1/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }
    @Test
    public void assignment3() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
       // List<WebElement> rows = driver.findElements(By.id("resultTable"));
        int rowcount = rows.size();

        System.out.println(rows.toString());
        for(int i=1;i<rowcount;i++) {

            WebElement ele = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]"));
            //System.out.println("Element is " +i+ " "+ele);
           // if(ele.getTagName() )
            ele.click();
            if(ele.isSelected())
                System.out.println("Checkbox displayed in : "+i);
            else
                System.out.println("Checkbox not displayed in :"+i);

        }
        Thread.sleep(7000);

    }
    @AfterMethod

    public void teardown(){
        driver.close();
    }

    }
