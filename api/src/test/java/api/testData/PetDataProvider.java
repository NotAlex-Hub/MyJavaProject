package api.testData;

import org.testng.annotations.DataProvider;

public class PetDataProvider {

    @DataProvider(name = "dataRequiredFields")
    public Object[][] dataRequiredFields() {
        return new Object[][]{
                {"id"}, {"category"}, {"name"}, {"photoUrls"}, {"tags"}
        };
    }
}
