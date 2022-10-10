package otus.ru.rest.api;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;


public class StoreOrderTest extends BaseTest {

    @BeforeEach
    @Step("Создание заказа")
    public void createOrder(){
        storeApi.placeAnOrder(storeApi.respSpecStoreOrder());
    }

    @AfterEach
    @Step("Удаление заказа")
    public void deleteOrder(){
        storeApi.deletePurchasedOrder(storeApi.respSpecDeleteOrder())
                .deletePurchasedOrder(storeApi.respSpecOrderNotFound());
    }


    @Test
    @DisplayName("Check creation an order")
    @Step("Проверка создания заказа")
    public void checkPostStoreOrder() {
        storeApi.findAndCheckPurchasedOrder(storeApi.respSpecStoreOrder());
    }

    @Test
    @DisplayName("Check that not exist order returns 404 Not Found")
    @Step("Проверка что такого заказа не существует")
    public void checkSecondCheck() {
        storeApi.checkThatOrderNotExist(storeApi.respSpecOrderNotFound());
    }
}
