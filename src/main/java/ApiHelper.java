
import io.qameta.allure.Step;
import model.CreateUserModel;
import io.restassured.response.Response;
import model.LoginUserModel;

import static io.restassured.RestAssured.*;

public class ApiHelper {
    private static final String BASE_URL = "https://stellarburgers.education-services.ru/";
    private static final String REGISTER_PATH = "/api/auth/register";
    private static final String DELETE_PATH = "/api/auth/user";
    private static final String LOGIN_PATH = "/api/auth/login";

    @Step("Успешная регистрация пользователя")
    public static Response registerUserApi() {


        CreateUserModel userModel = new CreateUserModel(TestData.EMAIL, TestData.PASSWORD, TestData.NAME);
           return   given()
                   .baseUri(BASE_URL)
                   .log().all()
                    .contentType("application/json")
                    .body(userModel)
                    .when()
                    .post(REGISTER_PATH);
        }

    @Step("Успешная удаление пользователя")
    public static Response deleteUser (String accessToken) {
        return given()
                .baseUri(BASE_URL)
                .log().all()
                .contentType("application/json")
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_PATH);
    }
    @Step("Успешная авторизация пользователя")
    public static Response authUser (LoginUserModel loginModel) {

        return given()
                .baseUri(BASE_URL)
                .log().all()
                .contentType("application/json")
                .body(loginModel)
                .when()
                .post(LOGIN_PATH);
    }

    }
