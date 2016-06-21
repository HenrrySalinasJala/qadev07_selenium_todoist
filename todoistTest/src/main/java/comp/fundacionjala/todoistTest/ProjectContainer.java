package comp.fundacionjala.todoistTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectContainer extends BasePage {

    @FindBy(className = "project_link")
    private WebElement lnkProjectName;

    public WebElement getLnkProjectName() {
        return lnkProjectName;
    }
}
