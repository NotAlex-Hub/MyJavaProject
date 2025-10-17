package pages.mainPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

import static org.testng.Assert.assertEquals;
import static utils.DriverSingleton.getDriver;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[text()='Laptops']")
    private WebElement buttonCategoryLaptops;

    @FindBy(xpath = "(//*[@class='card-title'])[1]")
    private WebElement titleLaptop;

    @FindBy(xpath = "//*[@id='nava']/img")
    private WebElement iconCompany;

    @FindBy(xpath = "//*[@id='nava']")
    private WebElement nameCompany;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage clickLaptopCategory() {
        clickableOfElement(buttonCategoryLaptops).click();
        return this;
    }

    public void checkTitleLaptop() {
        waitForSeconds();
        String actualTitle = titleLaptop.getText();
        assertEquals(actualTitle, "Sony vaio i5", "Заголовок не соотвутствует ожидаемому результату");
    }

    public MainPage checkVisibilityIconCompanyInHeader(SoftAssert softAssert) {
        softAssert.assertTrue(visibilityOfElement(iconCompany).isDisplayed(), "Иконка компании в шапке сайта не отображается");
        return this;
    }

    public void checkNameCompanyInHeader() {
        String actualName = nameCompany.getText();
        assertEquals(actualName, "PRODUCT STORE", "Название сайта в шапке сайта не соответствует ожидаемому результату");
    }
}
