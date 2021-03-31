package Others;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class NavigationAndClosingTest {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    @AfterEach
    public void afterQuit(){
        driver.quit();
    }

    @Test
    public void getMethod() {
        driver.get("https://www.naszraciborz.pl/?rt=1617110670");
        }

    @Test
    public void navigate(){
        URL googleURL = null;
        try {
            googleURL = new URL("https://google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.navigate().to(googleURL);
        driver.navigate().to("https:www.youtube.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.getCurrentUrl();
    }
    @Test
    public void getPageSource(){
        String googleImg = "/images/branding/googleg/1x/googleg_standard_color_128dp.png";
        driver.navigate().to("https://google.pl");
        Assertions.assertTrue(driver.getPageSource().contains(googleImg),"Page source not contains: "+ googleImg);
    }
}
