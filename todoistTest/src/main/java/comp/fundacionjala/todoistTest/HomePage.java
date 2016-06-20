package comp.fundacionjala.todoistTest;

public class HomePage extends BasePage {

    private SideBar sideBar;

    private ToolBar toolBar;

    private  ProjectContainer projectContainer;

    public HomePage(){
        toolBar=new ToolBar();
        sideBar=new SideBar();
        projectContainer=new ProjectContainer();
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    public ProjectContainer getProjectContainer() {
        return projectContainer;
    }
}
