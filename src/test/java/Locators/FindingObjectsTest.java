package Locators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindingObjectsTest {

    WebDriver driver;

    @BeforeEach
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://wikipedia.pl"); //radek gowno
    }

    @AfterEach
    public void closeAndQQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void findElementById() {
        driver.findElement(By.id("searchInput"));
        driver.findElement(By.name("search"));
        driver.findElement(By.className("searchButton"));

        List<WebElement> externalClassElements = driver.findElements(By.className("external"));
        WebElement elementWithTwoClasses = null;
        for (WebElement externalClassElement : externalClassElements) {
            String elementClass = externalClassElement.getAttribute("class");
            if (elementClass.equals("external text")) {
                elementWithTwoClasses = externalClassElement;
            }
        }
        Assertions.assertTrue(elementWithTwoClasses != null, "Element was not found.");

        int imagesCounter = driver.findElements(By.tagName("img")).size();
        System.out.println("There are "+ imagesCounter + " image elements on this site.");
    }
}
