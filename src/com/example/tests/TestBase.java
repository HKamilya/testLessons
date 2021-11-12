package com.example.tests;

import com.example.ApplicationManager;

public class TestBase {
    public ApplicationManager manager;

    public TestBase() {
        this.manager = ApplicationManager.GetInstance();
    }
}

