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
    protected static final String username="es.henrry@gmail.com";
    protected static final String password="TodoIst1234";
    @BeforeClass
    public static void setUp() {

        HomePage homePage = LoginFrame.login(username, password);
    }

    @AfterClass
    public static void tearDown() {
        DriverManager.getInstance().getDriver().quit();
    }
}
