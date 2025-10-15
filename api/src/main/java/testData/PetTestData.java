package testData;

import entities.PetsService.requestDto.Category;
import entities.PetsService.requestDto.Pet;
import entities.PetsService.requestDto.Tag;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class PetTestData {

    private Pet createPetRequest = new Pet(0, createCategory(), "doggie",
            createPhotoUrls(), createTag(), "available");

    private List<Tag> createTag() {
        Tag tag = Tag.builder()
                .id(0)
                .name("friendly")
                .build();
        return Collections.singletonList(tag);
    }

    private Category createCategory() {
        Category category = Category.builder()
                .id(0)
                .name("dogs")
                .build();
        return category;
    }

    private List<String> createPhotoUrls() {
        return Collections.singletonList("http://example.com/photo.jpg");
    }
}
