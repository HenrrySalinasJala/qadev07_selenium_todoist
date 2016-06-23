package com.fundacionjala.todoistTest.Task;

import com.fundacionjala.todoistTest.TodayPage;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LoginFrame;

import static org.junit.Assert.assertFalse;

public class DeleteTaskTest {

    private static HomePage homePage;

    private static String taskName;

    private static Task task;

    private ITaskForm taskForm;

    @BeforeClass
    public static void setUp() {
        homePage = LoginFrame.loginAsPrimaryUser();
        task = new Task();
    }

    @Test
    public void testDeleteTaskFromTodayPage() {
        taskForm = new TodayPage();
        taskName = "new task 2222";
        homePage.createTask(taskForm, taskName);
        task.deleteTask(taskName);
        assertFalse(task.taskExists(taskName));
    }
}
