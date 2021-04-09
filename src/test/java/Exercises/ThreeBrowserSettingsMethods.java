package test.java.Exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreeBrowserSettingsMethods {

    WebDriver driver;

    @BeforeEach
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.wp.pl/");
    }
    @AfterEach
    public void closeAndQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void checkBrowserSettings() throws InterruptedException {

        Dimension size = new Dimension(854,480);
        driver.manage().window().setSize(size);
        Point position = new Point(445,30);
        driver.manage().window().setPosition(position);

        Assertions.assertEquals(size,driver.manage().window().getSize());
        Assertions.assertEquals(position,driver.manage().window().getPosition());

        driver.manage().window().maximize();
        Thread.sleep(2000);
        }
    }


