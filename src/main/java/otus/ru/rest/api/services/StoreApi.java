package otus.ru.rest.api.services;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import otus.ru.rest.api.data.Status;
import otus.ru.rest.api.dto.Store;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StoreApi extends BaseApi {

    private static final String STORE = "/store/order";

    private static final int ID = 3;

    private static final int PET_ID = 2;

    private static final int QUANTITY = 1;

    private static final String CURRENT_DATE = getFormattedDate();

    public StoreApi() {
        super();
    }

    private static String getFormattedDate() {
        return LocalDateTime.now().atZone(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
    }

    private ValidatableResponse postStoreOrder(Store store, ResponseSpecification respSpec) {
        return given(reSpec)
                .basePath(STORE)
                .body(store)
                .log().all()
                .when()
                .post()
                .then()
                .spec(respSpec)
                .log().all();
    }

    public ResponseSpecification respSpecStoreOrder() {
        return given()
                .expect()
                .statusCode(200)
                .body("id", equalTo(ID))
                .body("id", greaterThanOrEqualTo(1))
                .body("id", lessThanOrEqualTo(10))
                .body("petId", equalTo(PET_ID))
                .body("quantity", equalTo(QUANTITY))
                .body("shipDate", is(CURRENT_DATE))
                .body("status", anyOf(is(Status.APPROVED.getName()), is(Status.PLACED.getName()), is(Status.DELIVERED.getName())))
                .body("complete", allOf(instanceOf(Boolean.class), is(true)))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/PostStoreOrder.json"));
    }

    public ResponseSpecification respSpecDeleteOrder() {
        return given()
                .expect()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo(String.valueOf(ID)));
    }

    public ResponseSpecification respSpecDeleteOrderNotFound() {
        return given()
                .expect()
                .statusCode(404)
                .body("code", equalTo(404))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("Order Not Found"));
    }

    public StoreApi placeAnOrder(ResponseSpecification respSpec) {
        System.out.println("|-----|-----| Send POST /store/order request");
        Store store = Store.builder()
                .id(ID)
                .petId(PET_ID)
                .quantity(QUANTITY)
                .shipDate(CURRENT_DATE.toString())
                .status(Status.APPROVED.getName())
                .complete(true)
                .build();
        postStoreOrder(store, respSpec);
        return this;
    }


    public StoreApi findAndCheckPurchasedOrder(ResponseSpecification respSpec) {
        System.out.println("|-----|-----| Send GET /store/order/" + ID + " request");
        RestAssured.given()
                .when()
                .get(BASE_URL + STORE + "/" + ID)
                .then()
                .spec(respSpec)
                .log().all();
        return this;
    }

    public StoreApi deletePurchasedOrder(ResponseSpecification respSpec) {
        System.out.println("|-----|-----| Send DELETE /store/order/" + ID + " request");
        RestAssured.given()
                .when()
                .delete(BASE_URL + STORE + "/" + ID)
                .then()
                .spec(respSpec)
                .log().all();
        return this;
    }
}
