package pageModels;

import entities.PetsService.requestDto.Pet;
import specifications.Specifications;

import static apiEndpoints.ApiEndpointsEnum.POST_PETS;
import static io.restassured.RestAssured.given;
import static pageModels.BasePage.PET_SERVICE_URL;

public class PetService {

    public void postAddPet(Pet data, int statusCode) {
        Specifications.getSpecifications(Specifications.requestSpecification(PET_SERVICE_URL),
                Specifications.responseSpecification(statusCode));
        given().body(data)
                .post(POST_PETS.getUrl());
    }
}
