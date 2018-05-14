package com.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {

    private String link = "https://www.google.com.ua";
    private String text = "Selenium";

    private WebDriver webDriver;

    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Test
    public void searchTest(){

        webDriver.get(link);

        By searchLocator = By.xpath("//*[@id=\"lst-ib\"]");

        WebElement searchField = webDriver.findElement(searchLocator);

        searchField.sendKeys(text);

        searchField.submit();

        By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");

        WebElement link = webDriver.findElement(linkLocator);

        assertTrue(link.getText().contains(text));

        webDriver.quit();



    }
}
