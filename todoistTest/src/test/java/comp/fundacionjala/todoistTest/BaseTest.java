package comp.fundacionjala.todoistTest;

import comp.fundacionjala.todoistTest.Project.CreateProjectTest;
import comp.fundacionjala.todoistTest.Project.UpdateProjectTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CreateProjectTest.class, UpdateProjectTest.class,})
public class BaseTest {

    @BeforeClass
    public static void setUp() {

    }

    @AfterClass
    public static void tearDown() {
        DriverManager.getInstance().getDriver().quit();
    }
}
