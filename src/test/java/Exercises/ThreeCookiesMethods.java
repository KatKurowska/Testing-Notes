package Exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class ThreeCookiesMethods {

    WebDriver driver;

    @BeforeEach
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://pl.wikipedia.org/");
    }
    @AfterEach
    public void closeAndQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void cookiesMethodsTest()  {
        Assertions.assertEquals(3,driver.manage().getCookies().size(),"Quantity of cookies isn't as expected.");

        Cookie myCookie = new Cookie("my_cookie","whatever_value");
        driver.manage().addCookie(myCookie);
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        for(Cookie cookie : cookiesSet){
            System.out.println(cookie);}
        Assertions.assertTrue(myCookie.getName() == "my_cookie" && cookiesSet.size() == 4);

        driver.manage().deleteCookieNamed("my_cookie");
        cookiesSet.remove(myCookie);
        Assertions.assertEquals(3,driver.manage().getCookies().size());

        driver.manage().deleteCookieNamed("WMF-Last-Access");
        Assertions.assertEquals(2,driver.manage().getCookies().size(),"Cookie hasn't been deleted.");

        Cookie geoIp = driver.manage().getCookieNamed("GeoIP");
        Assertions.assertTrue(geoIp.getDomain().equals(".wikipedia.org") && geoIp.getPath().equals("/") && !geoIp.isHttpOnly());
        //Alternative assertions:
        Assertions.assertEquals(".wikipedia.org", geoIp.getDomain());
        Assertions.assertEquals("/", geoIp.getPath());
        Assertions.assertEquals(false, geoIp.isHttpOnly());
    }
}
