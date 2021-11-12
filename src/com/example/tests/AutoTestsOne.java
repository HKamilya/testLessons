package com.example.tests;

import com.example.models.TaskData;
import com.example.models.UserData;
import org.junit.Test;

public class AutoTestsOne extends TestBase {


    @Test
    public void loginTest() throws Exception {
        manager.getNavigation().openHomePage();

        manager.getAuth().login(user);
    }

    @Test
    public void addNewTaskTest() throws Exception {
        manager.getNavigation().openHomePage();
        UserData user = new UserData();
        manager.getAuth().login(user);
        TaskData taskData = new TaskData("new task");
        manager.getProjectHelper().createNewTask(taskData);
    }
}
