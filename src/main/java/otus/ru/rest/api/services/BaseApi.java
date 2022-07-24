package otus.ru.rest.api.services;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseApi {

    public static final String BASE_URL = System.getProperty("base.url");
    public RequestSpecification reSpec;
    public BaseApi() {
            reSpec = given()
                    .baseUri(BASE_URL)
                    .contentType(ContentType.JSON);
    }
}
