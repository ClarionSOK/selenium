package com;

import com.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class dragAndDrop extends WebDriverTestBase{

    private String link = "https://js.cx/article/drag-and-drop-objects/dragDemo/";

    @Test
    public void dragAndDropTest(){
        driver.get(link);
        //driver.switchTo().frame("code-result__iframe");
        By elemLocator = By.xpath("/html/body/div[1]/img[1]");
        By dropLocator = By.xpath("/html/body/div[2]");
        WebElement elem = driver.findElement(elemLocator);
        WebElement drop = driver.findElement(dropLocator);
        Actions builder = new Actions(driver);
        Action dragAndDropAction = builder.clickAndHold(elem).moveToElement(drop).release(drop).build();

        dragAndDropAction.perform();


    }
}
