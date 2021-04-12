package Exercises;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FiveSimpleLocators {
    @Test
    public void findExactElements(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295,730));
        driver.navigate().to("http://fakestore.testelka.pl");

        driver.findElement(By.id("woocommerce-product-search-field-0"));
        driver.navigate().to("https://fakestore.testelka.pl/moje-konto/");

        driver.findElement(By.name("username"));
        driver.findElement(By.id("username"));

        driver.findElement(By.id("rememberme"));
        driver.findElement(By.name("rememberme"));

        driver.findElement(By.partialLinkText("hasła?"));
        driver.findElement(By.className("search-field"));
        driver.findElement(By.linkText("Żeglarstwo"));
        driver.close();
        driver.quit();
         }
}
