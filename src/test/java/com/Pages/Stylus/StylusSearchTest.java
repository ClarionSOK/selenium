package com.Pages.Stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.core.WebDriverTestBase;

import static org.testng.Assert.assertTrue;

public class StylusSearchTest extends WebDriverTestBase{
    private String link = "http://stylus.ua";
    private String searchItem = "Sony z2";
    private String searchResultTitle = "Результаты поиска по запросу \"" + searchItem + "\"";
    @Test
    public void searchTest(){
        driver.get(link);

        //Searching item
        By searchFieldLocator = By.xpath("//*[@id=\"head-search\"]/form/input[1]");
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchItem);
        searchField.submit();

        //Making sure we are on right page by analysing title
        By titleLocator = By.xpath("//*[@id=\"content\"]/h1");
        WebElement title = driver.findElement(titleLocator);
        System.out.println(title.getText());
        assertTrue(title.getText().contains(searchResultTitle));

        //Trying to find purple phone
        By purpleLinkLocator = By.xpath("//span[contains(text(), 'Purple')]");
        WebElement purpleLink = driver.findElement(purpleLinkLocator);
        purpleLink.click();

        //Making sure we have found what we need by trying to find "purple" and "xperia" in title or URL
        By phoneTitleLocator = By.xpath("//*[@id=\"product-block\"]/header/div[1]/h1");
        WebElement phoneTitle = driver.findElement(phoneTitleLocator);
        assertTrue((phoneTitle.getText().contains("Purple") && phoneTitle.getText().contains("Xperia"))
                || (driver.getCurrentUrl().contains("purple") && driver.getCurrentUrl().contains("xperia")));
    }

}
