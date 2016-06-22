package comp.fundacionjala.todoistTest.Task;

import org.junit.BeforeClass;
import org.junit.Test;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import comp.fundacionjala.todoistTest.TodayPage;
import comp.fundacionjala.todoistTest.ToolBar;

public class CreateTask {

    private HomePage homePage;

    private TaskForm taskform;

    @BeforeClass
    public void setUp() {
        final String username = "es.henrry@gmail.com";
        final String password = "TodoIst1234";
        homePage = LoginFrame.login(username, password);
    }
    @Test
    public void testCreateTaskByTodayPage(){
        ITaskForm taskForm=new TodayPage();
        String taskName = "new task 2222";
        homePage.createTask(taskForm, taskName);

    }
    @Test
    public void testCreateTaskByQuickTaskIcon(){
        ITaskForm taskForm=new ToolBar();
        String taskName = "new task 333";
        homePage.createTask(taskForm, taskName);
    }
    //.items.day_list.ul_today
}
