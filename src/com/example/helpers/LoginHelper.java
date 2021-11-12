package com.example.helpers;

import com.example.ApplicationManager;
import com.example.models.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper {
    private WebDriver driver;

    public LoginHelper(ApplicationManager manager) {
        driver = manager.getDriver();
    }

    public void login(UserData user) {
        driver.findElement(By.id("app")).click();
        driver.findElement(By.id("app")).click();
        driver.findElement(By.id("emailOrPhone")).click();
        driver.findElement(By.id("emailOrPhone")).clear();
        driver.findElement(By.id("emailOrPhone")).sendKeys(user.getEmail());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/section/button")).click();
    }
}
