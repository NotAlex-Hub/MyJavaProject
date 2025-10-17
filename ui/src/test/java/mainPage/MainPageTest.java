package mainPage;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mainPage.MainPage;

public class MainPageTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final SoftAssert softAssert = new SoftAssert();

    @Test(description = "Проверка содержания заголовка ноутбука")
    public void checkTitleLaptop() {
        mainPage.clickLaptopCategory()
                .checkTitleLaptop();
    }

    @Test(description = "Проверка отображения иконки и названия компании в шапке сайта")
    public void checkVisibilityIconCompany() {
        mainPage.checkVisibilityIconCompanyInHeader(softAssert)
                .checkNameCompanyInHeader();
    }
}
