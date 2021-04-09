package Basics;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    @Test
    public void demoTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295,730));

         /*driver.navigate().to("https://google.pl");
        WebElement searchField = driver.findElement(By.cssSelector("[title='Search']"));
        String searchEntry = "wszechświaty równoległe";
        String title = "Wieloświat - Wikiedia,wolna encyklopedia";

        searchField.sendKeys(searchEntry);
        searchField.submit();
        driver.findElement(By.xpath(".//*[text()='"+ title +"']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs(title));
        String entryURL = "https://pl.wikipedia.org/wiki/Wielo%C5%9Bwiat";
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct");*/
        driver.quit();
    }
}
