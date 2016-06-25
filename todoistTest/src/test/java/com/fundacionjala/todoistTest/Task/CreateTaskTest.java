package com.fundacionjala.todoistTest.Task;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LoginFrame;
import com.fundacionjala.todoistTest.TodayPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateTaskTest {

    private  HomePage homePage;

    private  Task task;

    private String taskName;

    private ITaskForm taskForm;

    @Before
    public void setUp() {

        homePage = LoginFrame.loginAsPrimaryUser();
        task=new Task();
    }

    @Test
    public void testCreateTaskByTodayPage() {
        taskForm = new TodayPage();
        taskName = "new task 2222";
        homePage.createTask(taskForm, taskName);
        assertTrue("The task created should be displayed",task.taskExists(taskName));
    }
    @After
    public void tearDown() {
        task.deleteTask(taskName);
    }


}
