import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUITest {
    WebDriver driver;
    MainPage mainPage;
    AuthPage authPage;

    private static final String URL_ADRESS = "https://stellarburgers.education-services.ru";

    @Before
    public void startBrowser() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("yandex")) {
            startBrowserYandex();
        } else {
            startBrowserFirefox();
        }
    }

    private void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        authPage = new AuthPage(driver);
        driver.get(URL_ADRESS);
    }

    public void startBrowserFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        authPage = new AuthPage(driver);
        driver.get(URL_ADRESS);
    }


    private void startBrowserYandex() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:/Users/Slava/Desktop/Diplom_3/Diplom_3/drivers/yandexdriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        authPage = new AuthPage(driver);
        driver.get(URL_ADRESS);
    }


   @After
    public void closeBrowser() {
        driver.quit();
    }
}

