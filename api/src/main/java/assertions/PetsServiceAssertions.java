package assertions;

import DBUtils.getDataFromDB.GetDataFromDBPetService;
import entities.PetsService.requestDto.Pet;
import pageModels.BasePage;

import java.util.HashMap;

public class PetsServiceAssertions extends BasePage {
    private GetDataFromDBPetService data = new GetDataFromDBPetService();

    public void assertFullFieldPet(Pet expectedResult) {

        HashMap<String, Object> actualResult = data.getDataFromPet(expectedResult.getId());

        softAssert.assertEquals(expectedResult.getId(), actualResult.get("id"));
        softAssert.assertEquals(expectedResult.getCategory(), actualResult.get("category"));
        softAssert.assertEquals(expectedResult.getName(), actualResult.get("name"));
        softAssert.assertEquals(expectedResult.getPhotoUrls(), actualResult.get("photoUrls"));
        softAssert.assertEquals(expectedResult.getTags(), actualResult.get("tags"));
        softAssert.assertEquals(expectedResult.getStatus(), actualResult.get("status"));
    }
}
