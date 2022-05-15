package ru.yandex.praktikum.refactoring;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgerLogo;

    @Step("Нажать кнопку конструктор")
    public void clickConstructorButton() {constructorButton.click();}

    @Step("Нажать на логотип")
    public void clickStellarBurger() {stellarBurgerLogo.click();}

}
