
import model.CreateUserModel;
import io.restassured.response.Response;
import model.LoginUserModel;

import static io.restassured.RestAssured.*;

public class ApiHelper {
    private static final String BASE_URL = "https://stellarburgers.education-services.ru/";
    private static final String REGISTER_PATH = "/api/auth/register";
    private static final String DELETE_PATH = "/api/auth/user";
    private static final String LOGIN_PATH = "/api/auth/login";


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


    public static Response deleteUser (String accessToken) {
        return given()
                .baseUri(BASE_URL)
                .log().all()
                .contentType("application/json")
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_PATH);
    }

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
