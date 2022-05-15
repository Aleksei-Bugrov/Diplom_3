package ru.yandex.praktikum.refactoring;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/../input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/../input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/../input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    public SelenideElement incorrectPassword;

    @FindBy(how = How.XPATH, using = ".//a[text() ='Войти']")
    private SelenideElement enterLink;

    @Step("Заполнить поле - имя")
    public void setNameField(String name) {nameField.setValue(name);}

    @Step("Заполнить поле - почта")
    public void setEmailField(String email) {emailField.setValue(email);}

    @Step("Заполнить поле - пароль")
    public void setPasswordField(String password) {passwordField.setValue(password);}

    @Step("Нажать кнопу зарегистрироваться")
    public void clickRegisterButton() {registerButton.click();}

    @Step("Нажать на кнопу войти")
    public void clickEnterLink() {enterLink.click();}
}
