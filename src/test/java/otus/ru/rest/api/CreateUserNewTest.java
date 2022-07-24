package otus.ru.rest.api;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import otus.ru.rest.api.dto.User;
import otus.ru.rest.api.dto.UserOut;
import otus.ru.rest.api.services.UserApiNew;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserNewTest {

    @Test
    public void checkUser(){
        User newUser = User.builder()
                .userStatus(11L)
                .email("email123@ya.ru")
                .id(122L)
                .firstName("Ivan")
                .lastName("Ivanov")
                .password("password")
                .username("login")
                .phone("89121234543")
                .build();

        UserApiNew userApi = new UserApiNew();
//example 1
        /*userApi.createUser(newUser)
                .statusCode(200)
                .body("type", equalTo("unknown"))
                .body("message", equalTo("122"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreateUser.json"));*/
        // .body("", )

        //List<Book> books =  response.extract().jsonPath().getList("store.book");
//example 2
        ValidatableResponse response = userApi.createUser(newUser);
        UserOut userOut = response.extract().body().as(UserOut.class);

        Assertions.assertEquals("122", userOut.getMessage());

    }
}
