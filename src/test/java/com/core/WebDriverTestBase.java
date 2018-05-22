package com.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import com.core.PropertiesCache;

import  static com.codeborne.selenide.WebDriverRunner.*;

public class WebDriverTestBase {
    protected WebDriver driver;
    private String browser = System.getProperty("browser", CHROME);
    private long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    private long pageWait = Long.parseLong(PropertiesCache.getProperty("wait.page"));
    private long scriptWait = Long.parseLong(PropertiesCache.getProperty("wait.script"));


    @BeforeClass
    public void setup(){
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        switch (browser.toLowerCase()){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                //driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(scriptWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @AfterClass
    public void endTest(){
        //driver.quit();
    }
}
