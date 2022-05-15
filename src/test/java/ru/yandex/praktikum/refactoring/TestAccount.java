package ru.yandex.praktikum.refactoring;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.data.User;
import ru.yandex.praktikum.data.UserClient;

import static com.codeborne.selenide.Selenide.*;

public class TestAccount {
    MainPage mainPage = null;
    private UserClient userClient;
    private User user;
    String accessToken;

    @Before
    public void setUp() {
        //Код для включения тестов в Яндекс браузере
/*      ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\a\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
*/
        Configuration.browserSize="1920x1080";
        userClient = new UserClient();
        user = User.getAllRandom();
        ValidatableResponse response = userClient.create(user);
        accessToken = response.extract().path("accessToken");
        mainPage = open(MainPage.URL, MainPage.class);

    }

    @After
    public void after() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        closeWebDriver();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» и переход в «Конструктор»")
    public void TransitFromPersonalAccountToDesigner() {
        mainPage.clickPersonalAreaButton();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setEmail(user.getEmail());
        authorizationPage.setPassword(user.getPassword());
        authorizationPage.clickEnterButton();

        mainPage.clickPersonalAreaButton();

        HeaderPage headerPage = page(HeaderPage.class);
        headerPage.clickConstructorButton();
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void TransitFromPersonalAccountToMainPage() {
        mainPage.clickPersonalAreaButton();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setEmail(user.getEmail());
        authorizationPage.setPassword(user.getPassword());
        authorizationPage.clickEnterButton();

        mainPage.clickPersonalAreaButton();

        HeaderPage headerPage = page(HeaderPage.class);
        headerPage.clickStellarBurger();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void ExitFromPersonalArea() {
        mainPage.clickPersonalAreaButton();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setEmail(user.getEmail());
        authorizationPage.setPassword(user.getPassword());
        authorizationPage.clickEnterButton();

        mainPage.clickPersonalAreaButton();

        PersonalAreaPage personalAreaPage = page(PersonalAreaPage.class);
        personalAreaPage.clickExitButton();
    }
}
