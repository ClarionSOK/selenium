package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;



import static org.testng.Assert.*;



public class GoogleGmailTest extends WebDriverTestBase{
    private String link = "https://www.google.com.ua";
    private String login = "kitcenter.isaev@gmail.com";
    private String password = "1q3e5t7uZX";



    @Test
    public void loginTest(){
        //Переходим по адресу гугла
        webDriver.get(link);
        //Ищем линк с текстом Почта
        By mailLinkLocator= By.xpath("//a[contains(text(),'Почта')]");
        WebElement mailLink = webDriver.findElement(mailLinkLocator);
        //Клик
        mailLink.click();
        //Убеждаемся что линк правильный
        assertTrue(webDriver.getCurrentUrl().contains("accounts.google.com/signin"));
        //Ищем и заполняем поле логина
        By loginFieldLocator=By.xpath("//*[@id=\"identifierId\"]");
        WebElement loginField=webDriver.findElement(loginFieldLocator);
        loginField.sendKeys(login);
        //Кликаем далее
        By nextButtonLocator=By.xpath("//*[@id=\"identifierNext\"]");
        WebElement nextButton = webDriver.findElement(nextButtonLocator);
        nextButton.click();
        //Ищем и заполняем поле пароля
        By passwordFieldLocator=By.xpath("//input[@type=\"password\"]");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
        //Проверяем что мы на странице с почтой
        System.out.println(webDriver.getCurrentUrl());
        //assertTrue(webDriver.getCurrentUrl().contains("mail.google.com/mail/"));
    }


}
