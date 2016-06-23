package comp.fundacionjala.todoistTest.Factory;

import comp.fundacionjala.todoistTest.ProjectContainer;

public interface IPage {
    ProjectContainer createTask(String taskName);
    
}
