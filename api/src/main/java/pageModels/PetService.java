package pageModels;

import entities.PetsService.requestDto.Pet;
import specifications.Specifications;

import java.util.HashMap;

import static apiEndpoints.ApiEndpointsEnum.POST_PETS;
import static io.restassured.RestAssured.given;
import static pageModels.BasePage.PET_SERVICE_URL;

public class PetService {

    public String postAddPet(Pet data, int statusCode) {
        Specifications.getSpecifications(Specifications.requestSpecification(PET_SERVICE_URL),
                Specifications.responseSpecification(statusCode));
        return given().body(data)
                .post(POST_PETS.getUrl())
                .then().extract().jsonPath().getString("id");

    }

    public void postAddPet(HashMap<String, Object> data, int statusCode) {
        Specifications.getSpecifications(Specifications.requestSpecification(PET_SERVICE_URL),
                Specifications.responseSpecification(statusCode));
        given().body(data)
                .post(POST_PETS.getUrl());
    }

    public void postAddPet(int statusCode) {
        Specifications.getSpecifications(Specifications.requestSpecification(PET_SERVICE_URL),
                Specifications.responseSpecification(statusCode));
        given().log().all()
                .post(POST_PETS.getUrl());
    }

    public void deletePet(String petId, int statusCode) {
        Specifications.getSpecifications(Specifications.requestSpecification(PET_SERVICE_URL),
                Specifications.responseSpecification(statusCode));
        given().log().all()
                .delete(POST_PETS.getUrl() + petId);
    }
}
