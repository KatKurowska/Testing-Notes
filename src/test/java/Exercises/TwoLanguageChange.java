package Exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TwoLanguageChange {

    WebDriver driver;

    @BeforeEach
    public void createDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterEach
    public void endSession() {
        driver.quit();
    }

    @Test
    public void CompareLocationAndTitle(){
        driver.get("http://wikipedia.pl");
        String pageTitle = "Wikipedia, wolna encyklopedia";
        String pageElement = "lang="+"pl";
        Assertions.assertEquals(pageTitle,driver.getTitle());
        Assertions.assertEquals("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna",driver.getCurrentUrl());
        Assertions.assertTrue(driver.getPageSource().contains(pageElement),"Checking is page contains the element");
    }

    @Test
    public void ChangeLanguage(){
        driver.get("http://wikipedia.pl");
        driver.findElement(new By.ByCssSelector("a[title='hiszpański']")).click();
        String spanishTitle = "Wikipedia, la enciclopedia libre";
        String spanishElement ="lang="+"es";
        Assertions.assertEquals(spanishTitle,driver.getTitle());
        Assertions.assertEquals("https://es.wikipedia.org/wiki/Wikipedia:Portada",driver.getCurrentUrl());
        Assertions.assertTrue(driver.getPageSource().contains(spanishElement));
    }
}
