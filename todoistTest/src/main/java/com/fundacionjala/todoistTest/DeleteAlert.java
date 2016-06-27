package com.fundacionjala.todoistTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAlert extends BasePage {

    @FindBy(xpath = "//div[@id=\"GB_window\"]/descendant::span[text()=\"Ok\"]")
    private WebElement btnConfirmDelete;

    public void clickOnBtnConfirmDelete() {
        btnConfirmDelete.click();
    }
}
