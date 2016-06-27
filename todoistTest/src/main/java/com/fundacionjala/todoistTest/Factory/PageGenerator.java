package com.fundacionjala.todoistTest.factory;

public class PageGenerator {

    public IPage generatePage(FactoryPage factoryPage) {
        return factoryPage.createPage();
    }
}
