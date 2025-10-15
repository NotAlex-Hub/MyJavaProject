package api.test;

import assertions.PetsServiceAssertions;
import org.testng.annotations.Test;
import pageModels.PetService;
import testData.PetTestData;

public class PetServiceTest {

    private final PetService petService = new PetService();
    private final PetsServiceAssertions petsServiceAssertions = new PetsServiceAssertions();
    private final PetTestData petTestData = new PetTestData();

    @Test(description = "Успешное добавление питомца")
    public void addPetTest() {
        petService.postAddPet(petTestData.getCreatePetRequest(), 200);
        petsServiceAssertions.assertFullFieldPet(petTestData.getCreatePetRequest());

    }
}
