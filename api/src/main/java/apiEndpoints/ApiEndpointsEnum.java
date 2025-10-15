package apiEndpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiEndpointsEnum {

    POST_PETS("v2/pet");

    private final String url;
}
