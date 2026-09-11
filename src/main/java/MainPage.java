import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    private final By buttonLoginOnMainPage = By.xpath("//button[normalize-space()='Войти в аккаунт']"); // Кнопка на главной "Войти в аккаунт"
    private final By linkRegister = By.xpath("//a[normalize-space()='Зарегистрироваться']"); //Кнопка "Зарегистрироваться"

    private final By buttonOrderInBasket = By.xpath("//button[normalize-space()='Оформить заказ']");
    private final By buttonPlaceOrder = By.xpath("//button[normalize-space()='Оформить заказ']");
    private final By buttonPersonalAccount = By.xpath("//p[text()='Личный Кабинет']"); //кнопка "Личный кабинет"
    private final By loginLink = By.xpath("//a[text()='Войти']");//кнопка войти в форме регистрации
    private final By forgotPasswordLink = By.xpath("//a[text()='Восстановить пароль']");// кнопка восстановления пароля
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By tabBuns = By.xpath("//span[text()='Булки']");
    private final By tabSauces = By.xpath("//span[text()='Соусы']");
    private final By tabFillings = By.xpath("//span[text()='Начинки']");
    private final By tabsActive = By.cssSelector("div[class*='tab_tab_type_current'] span");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке 'Войти в аккаунт'") //на главной кликнуть по "Войти в аккаунт"
    public void clickLoginOnMain() {
        driver.findElement(buttonLoginOnMainPage).click();
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegister() {
        driver.findElement(linkRegister).click();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickPersonalCabinet() {
        driver.findElement(buttonPersonalAccount).click();

    }
    @Step("Кликнуть кнопку 'Войти' в форме регистрации")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void clickforgotPasswordLink() {
    driver.findElement(forgotPasswordLink).click();
    }

    @Step("Проверяем видимость кнопки 'Оформить заказ' после регистрации")
    public String buttonOrderInBasketVisible() {
        WebElement activeTab = driver.findElement(tabsActive);
        return activeTab.getText();
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickconstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по вкладке конструктора 'Булки'")
    public void clickTabBuns() {
        driver.findElement(tabBuns).click();

    }
    @Step("Клик по вкладке конструктора 'Соусы'")
        public void clickTabSauce() {
            driver.findElement(tabSauces).click();
        }
    @Step("Клик по вкладке конструктора 'Начинки'")
            public void clickTabFillings() {
            driver.findElement(tabFillings).click();
        }

    @Step("Получить и вернуть текст с кнопки «Оформить заказ»")
    public String checktextButtonOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonPlaceOrder
        ));
        WebElement buttontext = driver.findElement(buttonPlaceOrder);
        return buttontext.getText();
    }
}