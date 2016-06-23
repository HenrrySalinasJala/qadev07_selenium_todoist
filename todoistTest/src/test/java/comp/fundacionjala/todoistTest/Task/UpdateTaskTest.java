package comp.fundacionjala.todoistTest.Task;

import org.junit.BeforeClass;
import org.junit.Test;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import comp.fundacionjala.todoistTest.TodayPage;

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
