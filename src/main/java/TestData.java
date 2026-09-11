import com.github.javafaker.Faker;

public class TestData {

    private static final String URL_ADRESS = "https://stellarburgers.education-services.ru";
    static Faker user = new Faker();
    public static final String NAME = user.name().firstName();
    public static final String EMAIL = user.internet().emailAddress();
    public static final String PASSWORD = user.regexify("[0-9]{6}");
    public static final String BADPASSWORD = user.regexify("[0-9]{5}");
}
