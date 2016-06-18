package comp.fundacionjala.todoistTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTest.class})
public class BaseTest {

    @BeforeClass
    public static void setUp() {

    }

    @AfterClass
    public static void tearDown() {
        DriverManager.getInstance().getDriver().quit();
    }

}
