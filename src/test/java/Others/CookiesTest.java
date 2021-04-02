package Others;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.GregorianCalendar;
import java.util.Set;

public class CookiesTest {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290,730));
        driver.manage().window().setPosition(new Point(8,30));
        driver.navigate().to("https://www.amazon.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(8, driver.manage().getCookies().size(),"Numbers of cookies isn't as expected.");
    }
    @AfterEach
    public void closeAndQuit(){
        //driver.close();
        //driver.quit();
    }

    @Test
    public void getCookiesAndDeleteThem(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie :cookies){
        System.out.println(cookie);}

        Cookie skinCookie = driver.manage().getCookieNamed("skin");
        driver.manage().deleteCookieNamed("skin");
        Assertions.assertEquals(7,driver.manage().getCookies().size(),"Numbers of cookies isn't as expected.");
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0,driver.manage().getCookies().size(),"Numbers of cookies isn't as expected.");
    }
    @Test
    public void addCookiesAndDeleteThem(){
       Cookie newCookie = new Cookie("test_cookie","test_value",".amazon.com","/",new GregorianCalendar(2021,4,12).getTime(),true,true);
       driver.manage().addCookie(newCookie);
       Assertions.assertNotNull(driver.manage().getCookieNamed("test_cookie"), "Cookie doesn't exist.");

        Cookie secondCookie = new Cookie("test_cookie2", "test_value2");
        driver.manage().addCookie(secondCookie);
        Assertions.assertNotNull(driver.manage().getCookieNamed("test_cookie2"), "Cookie doesn't exist.");

        driver.manage().deleteCookie(newCookie);
        Assertions.assertNull(driver.manage().getCookieNamed("test_cookie"), "Cookie is not deleted.");
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie :cookies){
            System.out.println(cookie);}
    }

    }

