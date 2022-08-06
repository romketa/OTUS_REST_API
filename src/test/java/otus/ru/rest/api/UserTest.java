package otus.ru.rest.api;

import org.junit.jupiter.api.*;

public class UserTest extends BaseTest {

    @BeforeEach
    public void createUser() {
        userApi.createUser(userApi.respSpecForUserCreateOrUpdate());
    }

    @AfterEach
    public void deleteUser() {
        userApi.deletePurchasedOrder(userApi.respSpecDeleteOrder());
    }

    @Test
    @DisplayName("Check creation user")
    public void checkCreationUser() {
        userApi.findAndCheckCreatedUser(userApi.respSpecForGet());
    }

    @Test
    @DisplayName("Check updating user")
    public void checkUpdatingUser() {

        userApi.findAndCheckCreatedUser(userApi.respSpecForGet())
                .updateUser(userApi.respSpecForUserCreateOrUpdate())
                .findAndCheckCreatedUser(userApi.respSpecForGet());
    }
}
