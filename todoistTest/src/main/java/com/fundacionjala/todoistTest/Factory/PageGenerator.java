package com.fundacionjala.todoistTest.factory;

public class PageGenerator {
    public IPage generatePage(PageFactory pageFactory){
        return pageFactory.createPage();
    }
    
}
