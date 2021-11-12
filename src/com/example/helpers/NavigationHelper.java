package com.example.helpers;

import com.example.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver;
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        driver = manager.getDriver();
        this.baseUrl = baseUrl;
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }


    public void openLoginPage() {
        driver.findElement(By.linkText("Войти")).click();
    }
}
