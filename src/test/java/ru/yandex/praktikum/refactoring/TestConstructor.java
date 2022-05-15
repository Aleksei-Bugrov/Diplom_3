package ru.yandex.praktikum.refactoring;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.containsString;

public class TestConstructor {
    MainPage mainPage = null;

    @Before
    public void setUp() {
        //Код для включения тестов в Яндекс браузере
/*     ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\a\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
*/
       // Configuration.browserSize="1920x1080";
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @After
    public void after() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Переход в раздел «Булки»")
    public void TransitBunsSection() {
        mainPage.clickBuns();

        MatcherAssert.assertThat(mainPage.getTextBuns(), containsString("Булки"));
    }

    @Test
    @DisplayName("Переход в раздел «Соусы»")
    public void TransitSaucesSection() {
        mainPage.clickSauces();

        MatcherAssert.assertThat(mainPage.getTextSauces(), containsString("Соусы"));
    }

    @Test
    @DisplayName("Переход в раздел «Начинки»")
    public void TransitFillingSection() {
        mainPage.clickFilling();

        MatcherAssert.assertThat(mainPage.getFillingsText(), containsString("Начинки"));
    }
}
