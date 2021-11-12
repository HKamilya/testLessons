package com.example.helpers;

import com.example.ApplicationManager;
import org.openqa.selenium.*;

public class HelperBase {
    protected ApplicationManager manager;
    protected WebDriver driver;
    protected boolean acceptNextAlert = true;

    public HelperBase(ApplicationManager manager, WebDriver driver) {
        this.manager = manager;
        this.driver = driver;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
