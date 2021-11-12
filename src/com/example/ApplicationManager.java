package com.example;

import com.example.helpers.TaskHelper;
import com.example.helpers.LoginHelper;
import com.example.helpers.NavigationHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {
    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;
    JavascriptExecutor js;

    private NavigationHelper navigation;
    private LoginHelper auth;
    private TaskHelper taskHelper;

    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gipot\\Desktop\\testLessons\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://ticktick.com/signin";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        navigation = new NavigationHelper(this, baseUrl);
        auth = new LoginHelper(this);
        taskHelper = new TaskHelper(this);
    }

    protected void finalize() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    public static ApplicationManager GetInstance() {

        if (app.get() == null) {

            ApplicationManager newInstance = new ApplicationManager();

            newInstance.getNavigation().openHomePage();

            app.set(newInstance);

        }

        return app.get();

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public void setVerificationErrors(StringBuffer verificationErrors) {
        this.verificationErrors = verificationErrors;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public void setJs(JavascriptExecutor js) {
        this.js = js;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public void setNavigation(NavigationHelper navigation) {
        this.navigation = navigation;
    }

    public LoginHelper getAuth() {
        return auth;
    }

    public void setAuth(LoginHelper auth) {
        this.auth = auth;
    }

    public TaskHelper getProjectHelper() {
        return taskHelper;
    }

    public void setAdmin(TaskHelper taskHelper) {
        this.taskHelper = taskHelper;
    }

}
