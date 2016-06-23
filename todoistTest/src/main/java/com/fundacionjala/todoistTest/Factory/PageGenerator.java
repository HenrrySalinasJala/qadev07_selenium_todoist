package com.fundacionjala.todoistTest.Factory;

public class PageGenerator {
    public IPage generatePage(PageFactory pageFactory){
        return pageFactory.createPage();
    }
    
}
