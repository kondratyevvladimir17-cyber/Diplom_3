import jdk.jfr.Description;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorTests extends BaseUITest{



    @Test
    @Description("Проверка открытой вкладки 'Булки'")
    public void clickTabBuns(){
        mainPage.clickconstructorButton();
        String tabName = mainPage.buttonOrderInBasketVisible();
       assertEquals(tabName, "Булки");
    }



    @Test
    @Description("Проверка открытия и отображения вкладки 'Соусы'")
    public void  clickTabSauces(){
        mainPage.clickconstructorButton();
        mainPage.clickTabSauce();
        mainPage.buttonOrderInBasketVisible();
        String tabName = mainPage.buttonOrderInBasketVisible();
        assertEquals(tabName, "Соусы");
    }


    @Test
    @Description("Проверка открытия и отображения вкладки 'Начинки'")
    public void clickTabFillings(){
        mainPage.clickconstructorButton();
        mainPage.clickTabFillings();
        mainPage.buttonOrderInBasketVisible();
        String tabName = mainPage.buttonOrderInBasketVisible();
        assertEquals(tabName, "Начинки");
    }
}
