package otus.ru.rest.api.services;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import otus.ru.rest.api.dto.Store;

import static io.restassured.RestAssured.given;

public class StoreApi {

    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public static final String STORE = "/store/order";

    private RequestSpecification reSpec;

    public StoreApi() {
        reSpec = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }

    public ValidatableResponse postStoreOrder(Store store){
        return  given(reSpec)
                .basePath(STORE)
                .body(store)
                .log().all()
                .when()
                .post()
                .then()
                .log().all();
    }

    public ResponseSpecification resp(Store store){
        return null;
    }

}
