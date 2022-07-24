package otus.ru.rest.api.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import otus.ru.rest.api.dto.Store;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.assertj.core.api.Assertions.*;

public class StoreApi extends BaseApi{

    private static final String STORE = "/store/order";

    private static final int ID = 3;

    private static final int PET_ID = 2;

    private static final int QUANTITY = 1;

    private static final LocalDateTime CURRENT_DATE = LocalDateTime.now();

    private static final String STATUS = "placed";

    public StoreApi() {
        super();
    }

    public ValidatableResponse postStoreOrder(Store store, ResponseSpecification respSpec1){
        return  given(reSpec)
                .basePath(STORE)
                .body(store)
                .log().all()
                .when()
                .post()
                .then()
                .spec(respSpec1)
                .log().all();
    }

    public void placeAnOrder() {
        Store store = Store.builder()
                .id(ID)
                .petId(PET_ID)
                .quantity(QUANTITY)
                .shipDate(CURRENT_DATE.toString())
                .status(STATUS)
                .complete(true)
                .build();
        postStoreOrder(store, respSpec());
    }

    public ResponseSpecification respSpec(){
        return given()
                .expect()
                .statusCode(200)
                .body("id", equalTo(ID))
                .body("petId", equalTo(PET_ID));
    }

    public void findPurchasedOrder(){
        RestAssured.given()
                .when()
                .get(BASE_URL + STORE +  "/3")
                .then()
                .log().all();

        assertThat("3")
                .as("incorrest")
                .isEqualTo("3");
    }
}
