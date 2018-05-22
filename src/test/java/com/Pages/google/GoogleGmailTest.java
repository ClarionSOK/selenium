package com.Pages.google;

import com.core.PropertiesCache;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.core.WebDriverTestBase;


import static org.testng.Assert.*;



public class GoogleGmailTest extends WebDriverTestBase{
    private String link = "https://www.google.com.ua";
    private String login = String.valueOf(PropertiesCache.getProperty("login.username"));
    private String password = String.valueOf(PropertiesCache.getProperty("login.password"));

    private WebElement mailLink;
    private WebElement loginField;
    private WebElement nextButton;
    private WebElement passwordField;
    private WebElement incomeMailButton;
    private WebDriverWait wait;

    By mailLinkLocator= By.xpath("//a[contains(text(),'Почта')]");
    By loginFieldLocator=By.xpath("//*[@id=\"identifierId\"]");
    By nextButtonLocator=By.xpath("//*[@id=\"identifierNext\"]");
    By passwordFieldLocator=By.xpath("//input[@type=\"password\"]");
    By incomeMailLocator = By.cssSelector("a[href='https://mail.google.com/mail/?tab=wm#inbox']");

//    public GoogleGmailTest(WebDriver driver) {
 //       super(driver);
 //   }


    @Test
    public void loginTest(){
        wait = new WebDriverWait(driver, 20); //?????
        //Переходим по адресу гугла
        driver.get(link);
        //Ищем линк с текстом Почта
        mailLink = driver.findElement(mailLinkLocator);
        //Клик
        mailLink.click();
        //Убеждаемся что линк правильный
        assertTrue(driver.getCurrentUrl().contains("accounts.google.com/signin"));
        //Ищем и заполняем поле логина
        loginField= driver.findElement(loginFieldLocator);
        loginField.sendKeys(login);
        //Кликаем далее
        nextButton = driver.findElement(nextButtonLocator);
        nextButton.click();
        //Ищем и заполняем поле пароля
        passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
        //ждем кликабельный элемент
        incomeMailButton = wait.until(ExpectedConditions.elementToBeClickable(incomeMailLocator));
        //Убеждаемся что линк правильный
        assertTrue(driver.getCurrentUrl().contains("mail.google.com/mail/"));
    }
}
