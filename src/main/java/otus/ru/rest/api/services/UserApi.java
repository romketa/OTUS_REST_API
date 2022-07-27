package otus.ru.rest.api.services;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import otus.ru.rest.api.dto.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class UserApi extends BaseApi {

    public static final String USER = "/user";

    public static final Long ID = 10L;

    public static final String EMAIL = "Ivan_Ivanov@mail.ru";

    public static final String FIRST_NAME = "Ivan";

    public static final String LAST_NAME = "Ivanov";

    public static final String UPDATED_FIRST_NAME = "Petr";

    public static final String UPDATED_LAST_NAME = "Petrov";

    public static final String PASSWORD = "Password";

    public static final String USERNAME = "Login";

    public static final String PHONE = "89127568971";

    public static final int USER_STATUS = 0;

    private ValidatableResponse validateCreationUser(User user, ResponseSpecification respSpec) {
        return given(reSpec)
                .basePath(USER)
                .body(user)
                .log().all()
                .when()
                .post()
                .then()
                .spec(respSpec)
                .log().all();
    }

    private ValidatableResponse validateUpdateUser(User user, ResponseSpecification respSpec) {
        return given(reSpec)
                .basePath(USER + "/" + USERNAME)
                .queryParam("username", USERNAME)
                .body(user)
                .log().all()
                .when()
                .put()
                .then()
                .spec(respSpec)
                .log().all();
    }

    public UserApi createUser(ResponseSpecification respSpec) {
        System.out.println("|-----|-----| Send POST /user request");
        User user = User.builder()
                .id(ID)
                .userStatus(USER_STATUS)
                .email(EMAIL)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .password(PASSWORD)
                .username(USERNAME)
                .phone(PHONE)
                .build();
        validateCreationUser(user, respSpec);
        return this;
    }

    public ResponseSpecification respSpecForUserCreateOrUpdate() {
        return given()
                .expect()
                .statusCode(200)
                .body("type", equalTo("unknown"))
                .body("message", equalTo(ID.toString()))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreateUser.json"));
    }

    public ResponseSpecification respSpecForGet() {
        return given()
                .expect()
                .statusCode(200);
    }

    public ResponseSpecification respSpecDeleteOrder() {
        return given()
                .expect()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo(USERNAME));
    }

    public UserApi findAndCheckCreatedUser(ResponseSpecification respSpec) {
        System.out.println("|-----|-----| Send GET /user/"+ USERNAME + " request");
        RestAssured.given()
                .when()
                .get(BASE_URL + USER + "/" + USERNAME)
                .then()
                .spec(respSpec)
                .log().all();
        return this;
    }

    public UserApi deletePurchasedOrder(ResponseSpecification respSpec) {
        System.out.println("|-----|-----| Send DELETE /user/"+ USERNAME + " request");
        RestAssured.given()
                .when()
                .delete(BASE_URL + USER + "/" + USERNAME)
                .then()
                .spec(respSpec)
                .log().all();
        return this;
    }

    public UserApi updateUser(ResponseSpecification respSpec) {
        System.out.println("|-----|-----| Send PUT /user/"+ USERNAME + " request");
        User user = User.builder()
                .id(ID)
                .userStatus(USER_STATUS)
                .email(EMAIL)
                .firstName(UPDATED_FIRST_NAME)
                .lastName(UPDATED_LAST_NAME)
                .password(PASSWORD)
                .username(USERNAME)
                .phone(PHONE)
                .build();
        validateUpdateUser(user, respSpec);
        return this;
    }
}
