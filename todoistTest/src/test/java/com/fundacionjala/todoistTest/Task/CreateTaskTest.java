package com.fundacionjala.todoistTest.Task;

import com.fundacionjala.todoistTest.TodayPage;
import com.fundacionjala.todoistTest.ToolBar;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LoginFrame;

import static org.junit.Assert.assertTrue;

public class CreateTaskTest {

    private static HomePage homePage;

    private static Task task;

    private TaskForm taskform;

    private String taskName;

    private ITaskForm taskForm;

    @BeforeClass
    public static void setUp() {

        homePage = LoginFrame.loginAsPrimaryUser();
    }

    @Test
    public void testCreateTaskByTodayPage() {
        taskForm = new TodayPage();
        taskName = "new task 2222";
        homePage.createTask(taskForm, taskName);
        assertTrue("The task created should be displayed",task.taskExists(taskName));
    }

    @Test
    public void testCreateTaskByQuickTaskIcon() {
        taskForm = new ToolBar();
        taskName = "new task 333";
        homePage.createTask(taskForm, taskName);
        assertTrue("The task created should be displayed",task.taskExists(taskName));
    }
}
