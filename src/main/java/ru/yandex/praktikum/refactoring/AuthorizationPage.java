package ru.yandex.praktikum.refactoring;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthorizationPage {

    @FindBy(how = How.XPATH, using = ".//input[@name ='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@name ='Пароль']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//a[text() ='Зарегистрироваться']")
    private SelenideElement registerLink;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    public SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//a[text() ='Восстановить пароль']")
    private SelenideElement restorePasswordLink;

    @Step("Заполнить поле - пароль")
    public void setPassword(String password) {passwordField.setValue(password);}

    @Step("Заполнить поле - почта")
    public void setEmail(String email) {emailField.setValue(email);}

    @Step("Нажать на кнопку - зарегистрироваться")
    public void clickRegister() {registerLink.click();}

    @Step("Нажать кнопку войти")
    public void clickEnterButton() {enterButton.click();}

    @Step("Нажать кнопку восстановить пароль")
    public void clickRestorePassword() {restorePasswordLink.click();}

}
