package com.Pages.google;

import com.core.PropertiesCache;
import com.core.WebDriverTestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.google.GoogleSearchPage;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest extends WebDriverTestBase{

    private String link = "https://www.google.com.ua";
    private String text = String.valueOf(PropertiesCache.getProperty("search.text"));



    @Test
    public void searchTest(){

        driver.get(link);
        GoogleSearchPage search = new GoogleSearchPage(driver);
        search.search(text);
        search.getResult(text);
    }
}
