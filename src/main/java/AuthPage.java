import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AuthPage {

    private final WebDriver driver;

    private final By inputEmail = By.xpath("//label[normalize-space()='Email']//following::input");
    private final By inputPassword = By.cssSelector("input[type='password']");
    private final By inputName = By.xpath("//label[normalize-space()='Имя']//following::input");
    private final By buttonRegister = By.xpath("//button[normalize-space()='Зарегистрироваться']");
    private final By buttonLogin = By.xpath("//button[normalize-space()='Войти']"); //локатор для кнопки "Войти" при авторизации
    private final By emailInput = By.xpath("//input[@name='name']");//поле для майла вход
    private final By passwordInput = By.cssSelector("input[type='password']");//поле пароль для входа
    private final By passwordErrorText = By.xpath("//p[text()='Некорректный пароль']");
    private final By loginTitle = By.xpath("//h2[text()='Вход']");


    public AuthPage(WebDriver driver) {
        this.driver = driver;

    }

    //Успешная регистрация пользователя
    public void register(String email, String password, String name) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonRegister).click();
    }

    //Успешный вход в аккаунт
    public void loginUser(String email, String password) {
        //   driver.findElement(emailInput).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
        //  driver.findElement(emailInput).sendKeys(email);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
        // driver.findElement(passwordInput).click();
        // driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(buttonLogin).click();
    }

    //Ожидание появления текста ошибки пароля
    public boolean isPasswordErrorVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordErrorText));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isLoginTitleDisplayed() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(loginTitle))
                    .isDisplayed();
        } catch (Exception e) {
            // Если элемент не появился, не упадет с ошибкой, а просто вернет false
            return false;
        }
    }
}