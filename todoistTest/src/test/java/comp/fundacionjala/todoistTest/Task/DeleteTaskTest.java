package comp.fundacionjala.todoistTest.Task;

import org.junit.BeforeClass;
import org.junit.Test;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import comp.fundacionjala.todoistTest.TodayPage;

import static org.junit.Assert.assertFalse;

public class DeleteTaskTest {

    private static HomePage homePage;

    private static String taskName;

    private static Task task;

    private ITaskForm taskForm;

    @BeforeClass
    public static void setUp() {
        final String username = "es.henrry@gmail.com";
        final String password = "TodoIst1234";
        homePage = LoginFrame.login(username, password);

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
