package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.core.AbstractPage;

import static org.testng.Assert.assertTrue;

public class GoogleSearchPage extends AbstractPage{
    By searchLocator = By.xpath("//*[@id=\"lst-ib\"]");
    By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");


    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }
    public void search(String text){
        WebElement searchField = driver.findElement(searchLocator);
        searchField.sendKeys(text);
        searchField.submit();
    }
    public void getResult(String text){
        WebElement link = driver.findElement(linkLocator);
        assertTrue(link.getText().contains(text));

    }

}
