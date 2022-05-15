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

public class TestLogin {
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
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginButtonMainPage() {
        mainPage.clickSignIn();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setEmail(user.getEmail());
        authorizationPage.setPassword(user.getPassword());
        authorizationPage.clickEnterButton();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginPersonalAreaButton() {
        mainPage.clickPersonalAreaButton();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setEmail(user.getEmail());
        authorizationPage.setPassword(user.getPassword());
        authorizationPage.clickEnterButton();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginButtonRegisterPage() {
        mainPage.clickSignIn();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegister();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickEnterLink();

        authorizationPage.setEmail(user.getEmail());
        authorizationPage.setPassword(user.getPassword());
        authorizationPage.clickEnterButton();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginButtonRestorePassword() {
        mainPage.clickSignIn();

        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRestorePassword();

        RestorePassword restorePassword = page(RestorePassword.class);
        restorePassword.clickEnterButton();

        authorizationPage.setEmail(user.getEmail());
        authorizationPage.setPassword(user.getPassword());
        authorizationPage.clickEnterButton();
    }
}
