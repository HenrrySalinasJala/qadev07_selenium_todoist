package com.fundacionjala.todoistTest.Task;

import com.fundacionjala.todoistTest.TodayPage;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fundacionjala.todoistTest.HomePage;
import com.fundacionjala.todoistTest.LoginFrame;

import static org.junit.Assert.assertTrue;

public class UpdateTaskTest {
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
    public void testUpdateTaskFromTodayPage() {
        taskForm = new TodayPage();
        taskName = "new task 4444";
        homePage.createTask(taskForm, taskName);
        String newTaskName = "new task 555";
        task.updateTaskName(taskName,newTaskName);
        assertTrue(task.taskExists(newTaskName));
    }
}
