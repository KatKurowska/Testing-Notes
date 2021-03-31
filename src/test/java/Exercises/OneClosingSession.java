package Exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;

public class OneClosingSession {

    @Test
    public void navigateBetweenWikiAndNasa(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org");
        driver.get("https://www.nasa.gov");
        driver.navigate().back();

        Assertions.assertEquals("https://www.wikipedia.org"+"/",driver.getCurrentUrl());
        System.out.println("FIRST ASSERTION: actual page URL - "+ driver.getCurrentUrl());
        driver.navigate().forward();
        Assertions.assertEquals("NASA", driver.getTitle());
        System.out.println("SECOND ASSERTION: actual page title - "+ driver.getTitle());
        driver.close();
        driver.quit();
    }
}
