
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class AuthorizationTests extends BaseUITest {

    private String CreatedAccessToken;

@Before
public void regUser() {
   Response response =  ApiHelper.registerUserApi();
    CreatedAccessToken = response.body().jsonPath().getString("accessToken");
}
@After
public void deleteUser() {
    ApiHelper.deleteUser(CreatedAccessToken);
}
    @Test
    @Description("Успешная авторизация пользователя по клику на кнопку 'Войти в аккаунт'")
    public void loginSuccessButtonLoginOnMain() {
        mainPage.clickLoginOnMain();
        authPage.loginUser(TestData.EMAIL, TestData.PASSWORD); //авторизуемся
        String actualText = mainPage.checktextButtonOrder();
        String expectedText = "Оформить заказ";
        assertTrue(actualText.contains(expectedText));// Проверяем, что перешли на страницу профиля и название кнопки соответствует авторизованному пользователю
    }

    @Test
    @Description("Успешная авторизация пользователя по клику на кнопку 'Личный кабинет'")
    public void loginSuccessButtonPersonalCabinet() {
        mainPage.clickPersonalCabinet();
        authPage.loginUser(TestData.EMAIL, TestData.PASSWORD); //авторизуемся
        String actualText = mainPage.checktextButtonOrder();
        String expectedText = "Оформить заказ";
        assertTrue(actualText.contains(expectedText));// Проверяем, что перешли на страницу профиля и название кнопки соответствует авторизованному пользователю
    }


    @Test
    @Description("Успешная авторизация пользователя по клику на кнопку 'Войти' в форме регистрации")
    public void loginSuccessButtonLoginLink() {
        mainPage.clickLoginOnMain();
        mainPage.clickRegister();
        mainPage.clickLoginLink();
        authPage.loginUser(TestData.EMAIL, TestData.PASSWORD); //авторизуемся
        String actualText = mainPage.checktextButtonOrder();
        String expectedText = "Оформить заказ";
        assertTrue(actualText.contains(expectedText));// Проверяем, что перешли на страницу профиля и название кнопки соответствует авторизованному пользователю
    }


    @Test
    @Description("Успешная авторизация пользователя по клику на кнопку 'Войти' в форме регистрации")
    public void loginSuccessButtonforgotPasswordLink() {
        mainPage.clickLoginOnMain();
        mainPage.clickforgotPasswordLink();
        mainPage.clickLoginLink();
        authPage.loginUser(TestData.EMAIL, TestData.PASSWORD); //авторизуемся, чтоб убедиться в успешной регистрации
        String actualText = mainPage.checktextButtonOrder();
        String expectedText = "Оформить заказ";
        assertTrue(actualText.contains(expectedText));// Проверяем, что перешли на страницу профиля и название кнопки соответствует авторизованному пользователю
    }


}
