package ru.yandex.praktikum.refactoring;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePassword {
    @FindBy(how = How.XPATH, using = ".//a[text() ='Войти']")
    private SelenideElement enterButton;

    @Step("Нажатие на кнопку выход")
    public void clickEnterButton() {enterButton.click();}
}
