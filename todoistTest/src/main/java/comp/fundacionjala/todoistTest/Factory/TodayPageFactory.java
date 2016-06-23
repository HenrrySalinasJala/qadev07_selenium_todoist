package comp.fundacionjala.todoistTest.Factory;

import comp.fundacionjala.todoistTest.TodayPage;

public class TodayPageFactory extends PageFactory{
    
    public IPage createPage() {
        return new TodayPage();
    }
}
