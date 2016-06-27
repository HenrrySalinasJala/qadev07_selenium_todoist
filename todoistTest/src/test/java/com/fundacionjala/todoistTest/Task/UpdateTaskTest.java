package com.fundacionjala.todoistTest.task;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LoginFrame;
import com.fundacionjala.todoistTest.TodayPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UpdateTaskTest {

    private HomePage homePage;

    private String taskName;

    private String newTaskName;

    private Task task;

    private ITaskForm taskForm;

    @Before
    public void setUp() {
        taskName = "new task 4444";
        newTaskName = "new task 555";
        homePage = LoginFrame.loginAsPrimaryUser();
        task = new Task();
        taskForm = new TodayPage();
        homePage.createTask(taskForm, taskName);
    }

    @Test
    public void testUpdateTaskFromTodayPage() {

        task.updateTaskName(taskName, newTaskName);
        assertTrue(task.taskExists(newTaskName));
    }

    @After
    public void tearDown() {
        task.deleteTask(newTaskName);
    }
}
