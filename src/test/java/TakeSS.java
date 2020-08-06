import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeSS {
    WebDriver driver;
 @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/resources 1/chromedriver");

        driver = new ChromeDriver();

        driver.get("http://whiteboxqa.com/schedule.php");
    }
    @Test
    public void screenshot() throws IOException {

        String fileName = "Whitebox_schedule";

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(file, new File("/Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/com/edu/basic/Screenshots"+ fileName + ".png"));

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
