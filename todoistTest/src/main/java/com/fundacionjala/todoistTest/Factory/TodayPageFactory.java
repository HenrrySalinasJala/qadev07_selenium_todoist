package com.fundacionjala.todoistTest.Factory;

import com.fundacionjala.todoistTest.TodayPage;

public class TodayPageFactory extends PageFactory{
    
    public IPage createPage() {
        return new TodayPage();
    }
}
