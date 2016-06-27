package com.fundacionjala.todoistTest.factory;

import com.fundacionjala.todoistTest.TodayPage;

public class TodayPageFactory extends PageFactory{
    
    public IPage createPage() {
        return new TodayPage();
    }
}
