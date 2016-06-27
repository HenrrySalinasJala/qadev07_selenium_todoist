package com.fundacionjala.todoistTest.factory;

public class TodayFactoryPage extends FactoryPage {
    
    public IPage createPage() {
        return new TodayPage();
    }
}
