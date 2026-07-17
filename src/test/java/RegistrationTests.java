import io.restassured.response.Response;
import jdk.jfr.Description;
import model.LoginUserModel;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseUITest {


    private String CreatedAccessToken;
    private boolean userWasCreated;

    @After
   public void deleteUser() {
       if(userWasCreated) {
           LoginUserModel loginModel = new LoginUserModel(TestData.EMAIL, TestData.PASSWORD);
           Response response = ApiHelper.authUser(loginModel);// авторизация для уточнения токена
           CreatedAccessToken = response.body().jsonPath().getString("accessToken");
           ApiHelper.deleteUser(CreatedAccessToken);//удаление через полученный токен
         } else {
        System.out.println("Очистка пропущена: пользователь не был создан");
    }
       }

    @Test
    @Description("Успешная регистрация нового пользователя")
    public void registrationSuccess() {
        mainPage.clickLoginOnMain();
        mainPage.clickRegister();
        authPage.register(TestData.EMAIL, TestData.PASSWORD, TestData.NAME);
       assertTrue(authPage.isLoginTitleDisplayed());// Проверяем, что регистрация прошла успешно и мы перешли на страницу авторизации
        userWasCreated = true;
    }

    @Test
    @Description("Ошибка при регистрации: пароль меньше 6 символов")
    public void registrationPasswordTooShort() {
        mainPage.clickLoginOnMain();
        mainPage.clickRegister();
        authPage.register(TestData.EMAIL, TestData.BADPASSWORD, TestData.NAME); // 5 символов
        assertTrue(authPage.isPasswordErrorVisible());// Проверяем, что ошибка отображается
        userWasCreated = false;
    }
}
