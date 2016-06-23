package com.fundacionjala.todoistTest.Factory;

import com.fundacionjala.todoistTest.ProjectContainer;

public interface IPage {
    ProjectContainer createTask(String taskName);
    
}
