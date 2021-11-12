package com.example.helpers;

import com.example.ApplicationManager;
import com.example.models.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TaskHelper {
    private WebDriver driver;

    public TaskHelper(ApplicationManager manager) {
        this.driver = manager.getDriver();
    }

    public void createNewTask(TaskData task) {
        driver.get("https://ticktick.com/webapp/#p/inbox/tasks/618eca1ba142533b1d5019ab");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[2]/following::*[name()='svg'][4]")).click();
        driver.findElement(By.id("edit-project-name")).click();
        driver.findElement(By.id("edit-project-name")).clear();
        driver.findElement(By.id("edit-project-name")).sendKeys("list");
        driver.findElement(By.xpath("//div[@id='project-modal-detail-view']/div[3]/button[2]")).click();    }
}