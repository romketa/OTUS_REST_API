package otus.ru.rest.api.services;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import otus.ru.rest.api.dto.User;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class UserApiNew {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public static final String USER = "/user";

    private RequestSpecification recSpec;

    public UserApiNew() {
        recSpec = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }

    public ValidatableResponse createUser(User user) {
        return given(recSpec)
                .basePath(USER)
                .body(user)
                .log().all()
                .when()
                .post()
                .then()
                .log().all();


    }

}
