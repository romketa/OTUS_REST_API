package otus.ru.rest.api;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

public class UserTest extends BaseTest {

    @BeforeEach
    @Step("Создание пользователя")
    public void createUser() {
        userApi.createUser(userApi.respSpecForUserCreateOrUpdate());
    }

    @AfterEach
    @Step("Удаление пользователя")
    public void deleteUser() {
        userApi.deletePurchasedOrder(userApi.respSpecDeleteOrder());
    }

    @Test
    @DisplayName("Check creation user")
    @Step("Проверка создания пользователя")
    public void checkCreationUser() {
        userApi.findAndCheckCreatedUser(userApi.respSpecForGet());
    }

    @Test
    @DisplayName("Check updating user")
    @Step("Проверка обновления пользователя")
    public void checkUpdatingUser() {

        userApi.findAndCheckCreatedUser(userApi.respSpecForGet())
                .updateUser(userApi.respSpecForUserCreateOrUpdate())
                .findAndCheckCreatedUser(userApi.respSpecForGet());
    }
}
