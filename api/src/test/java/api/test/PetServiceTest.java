package api.test;

import api.testData.PetDataProvider;
import assertions.PetsServiceAssertions;
import org.testng.annotations.Test;
import pageModels.PetService;
import testData.PetTestData;

import java.util.HashMap;

public class PetServiceTest {

    private final PetService petService = new PetService();
    private final PetsServiceAssertions petsServiceAssertions = new PetsServiceAssertions();
    private final PetTestData petTestData = new PetTestData();

    /*
    Тесты написаны просто для примера, они не проходят, так как я подключаюсь к несуществующей БД в автотестах.
    Так же в этом api нет обязательных полей, они все необязательны. Поэтому для примера я представил,
    что все поля при создании питомца обязательны, за исключением поля status в теле запроса.
     */

    @Test(description = "Успешное добавление питомца")
    public void addPetTest() {
        petService.postAddPet(petTestData.getCreatePetRequest(), 200); //201
        petsServiceAssertions.assertFullFieldPet(petTestData.getCreatePetRequest());
        petService.deletePet(petTestData.getCreatePetRequest().getId(), 204);
    }

    @Test(description = "Добавление питомца без необязательных полей")
    public void addPetWithoutOptionalParamsTest() {
        String actualId = petService.postAddPet(petTestData
                .getCreatePetRequestWithoutOptionalParams(), 200); //201
        petService.deletePet(actualId, 200); //204
    }

    @Test(description = "Добавление питомца без обязательных полей",
            dataProvider = "dataRequiredFields", dataProviderClass = PetDataProvider.class)
    public void addPetWithoutRequiredParamsTest(Object reqField) {
        HashMap<String, Object> mapsData = petTestData.getCreatePetRequestHashMap();
        mapsData.remove(reqField);
        petService.postAddPet(mapsData, 400);
    }

    @Test(description = "Добавление питомца без тела запроса")
    public void addPetWithoutBody() {
        petService.postAddPet(400);

    }
}
