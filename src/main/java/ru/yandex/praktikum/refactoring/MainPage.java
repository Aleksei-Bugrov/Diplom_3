package ru.yandex.praktikum.refactoring;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAreaButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement signInLink;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsTransition;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesTransition;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingTransition;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsText;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement saucesText;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingsText;

    @FindBy(how = How.XPATH, using = ".//p[text()='Соус традиционный галактический']")
    private SelenideElement sauceIngredient;

    @Step("Нажать на кнопку личный кабинет")
    public void clickPersonalAreaButton() {personalAreaButton.click();}

    @Step("Нажать кнопу войти в аккаунт")
    public void clickSignIn() {signInLink.click();}

    @Step("Нажать на секцию - булки")
    public void clickBuns() {sauceIngredient.scrollIntoView(true); bunsTransition.click();}

    @Step("Нажать на секцию - соус")
    public void clickSauces() {saucesTransition.click();}

    @Step("Нажать на секцию - начинки")
    public void clickFilling() {fillingTransition.click();}

    @Step("Получить текст для проверки")
    public String getTextBuns() {return bunsText.getText();}

    @Step("Получить текст для проверки")
    public String getTextSauces() {return saucesText.getText();}

    @Step("Получить текст для проверки")
    public String getFillingsText() {return fillingsText.getText();}
}
