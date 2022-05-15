package ru.yandex.praktikum.refactoring;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAreaPage {

    @FindBy(how = How.XPATH, using = ".//button[text() ='Выход']")
    private SelenideElement exitButton;

    @Step("Нажать на кнопу выход")
    public void clickExitButton() {exitButton.click();}
}
