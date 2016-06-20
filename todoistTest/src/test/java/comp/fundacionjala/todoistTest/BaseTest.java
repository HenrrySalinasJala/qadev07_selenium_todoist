package comp.fundacionjala.todoistTest;

import comp.fundacionjala.todoistTest.Project.CreateProjectTest;
import comp.fundacionjala.todoistTest.Project.DeleteProjectTest;
import comp.fundacionjala.todoistTest.Project.UpdateProjectTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CreateProjectTest.class, UpdateProjectTest.class, DeleteProjectTest.class})
public class BaseTest {

    @BeforeClass
    public static void setUp() {

        HomePage homePage = LoginFrame.login("es.henrry@gmail.com", "TodoIst1234");
    }

    @AfterClass
    public static void tearDown() {
        DriverManager.getInstance().getDriver().quit();
    }
}
