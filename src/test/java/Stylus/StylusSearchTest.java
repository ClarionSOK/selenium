package Stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;

import static org.testng.Assert.assertTrue;

public class StylusSearchTest extends WebDriverTestBase{
    private String link = "http://stylus.ua";
    private String searchItem = "Sony z2";
    private String searchResultTitle = "Результаты поиска по запросу \"" + searchItem + "\"";
    @Test
    public void searchTest(){
        webDriver.get(link);

        //Searching item
        By searchFieldLocator = By.xpath("//*[@id=\"head-search\"]/form/input[1]");
        WebElement searchField = webDriver.findElement(searchFieldLocator);
        searchField.sendKeys(searchItem);
        searchField.submit();

        //Making sure we are on right page by analysing title
        By titleLocator = By.xpath("//*[@id=\"content\"]/h1");
        WebElement title = webDriver.findElement(titleLocator);
        System.out.println(title.getText());
        assertTrue(title.getText().contains(searchResultTitle));

        //Trying to find purple phone
        By purpleLinkLocator = By.xpath("//span[contains(text(), 'Purple')]");
        WebElement purpleLink = webDriver.findElement(purpleLinkLocator);
        purpleLink.click();

        //Making sure we have found what we need by trying to find "purple" in title or URL
        By phoneTitleLocator = By.xpath("//*[@id=\"product-block\"]/header/div[1]/h1");
        WebElement phoneTitle = webDriver.findElement(phoneTitleLocator);
        assertTrue(phoneTitle.getText().contains("Purple") || webDriver.getCurrentUrl().contains("purple"));
    }

}
