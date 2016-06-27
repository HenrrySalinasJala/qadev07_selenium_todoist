package com.fundacionjala.todoistTest.factory;

import com.fundacionjala.todoistTest.ProjectContainer;

public interface IPage {

    ProjectContainer createTask(String taskName);
}
