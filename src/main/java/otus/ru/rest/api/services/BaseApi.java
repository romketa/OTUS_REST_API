package otus.ru.rest.api.services;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApi implements PetStoreApi{

    public static final String BASE_URL = System.getProperty("base.url");

    public static Faker faker = new Faker();

    public RequestSpecification reSpec;

    public BaseApi() {
            reSpec = given()
                    .baseUri(BASE_URL)
                    .contentType(ContentType.JSON);
    }

}
