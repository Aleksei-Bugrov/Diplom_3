package ru.yandex.praktikum.refactoring;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class TestRegistration {
    MainPage mainPage = null;

    @Before
    public void setUp() {
        //Код для включения тестов в Яндекс браузере
/*     ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\a\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
*/
        //Configuration.browserSize="1920x1080";
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @After
    public void after() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void positiveRegistration() {
        mainPage.clickPersonalAreaButton();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegister();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.setNameField(RandomStringUtils.randomAlphabetic(10));
        registerPage.setEmailField(RandomStringUtils.randomAlphabetic(10)+ "@test.ru");
        registerPage.setPasswordField(RandomStringUtils.randomAlphabetic(10));
        registerPage.clickRegisterButton();

        authorizationPage.enterButton.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    public void negativeRegistration() {
        mainPage.clickPersonalAreaButton();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegister();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.setNameField(RandomStringUtils.randomAlphabetic(10));
        registerPage.setEmailField(RandomStringUtils.randomAlphabetic(10)+ "@test.ru");
        registerPage.setPasswordField(RandomStringUtils.randomAlphabetic(5));
        registerPage.clickRegisterButton();
        registerPage.incorrectPassword.shouldBe(Condition.visible);
    }
}

