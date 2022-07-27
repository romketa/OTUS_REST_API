package otus.ru.rest.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import otus.ru.rest.api.services.UserApi;

public class UserTest {

    @Test
    @DisplayName("Check creation user, get created user and delete created order")
    public void checkCreationUser() {

        UserApi userApi = new UserApi();

        userApi.createUser(userApi.respSpecForUserCreateOrUpdate())
                .findAndCheckCreatedUser(userApi.respSpecForGet())
                .deletePurchasedOrder(userApi.respSpecDeleteOrder());
    }

    @Test
    @DisplayName("Check updating user")
    public void checkUpdatingUser() {

        UserApi userApi = new UserApi();

        userApi.createUser(userApi.respSpecForUserCreateOrUpdate())
                .findAndCheckCreatedUser(userApi.respSpecForGet())
                .updateUser(userApi.respSpecForUserCreateOrUpdate())
                .findAndCheckCreatedUser(userApi.respSpecForGet())
                .deletePurchasedOrder(userApi.respSpecDeleteOrder());
    }
}
