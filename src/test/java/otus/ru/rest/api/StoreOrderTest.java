package otus.ru.rest.api;

import org.junit.jupiter.api.*;


public class StoreOrderTest extends BaseTest {

    @BeforeEach
    public void createOrder(){
        storeApi.placeAnOrder(storeApi.respSpecStoreOrder());
    }

    @AfterEach
    public void deleteOrder(){
        storeApi.deletePurchasedOrder(storeApi.respSpecDeleteOrder())
                .deletePurchasedOrder(storeApi.respSpecOrderNotFound());
    }


    @Test
    @DisplayName("Check creation an order")
    public void checkPostStoreOrder() {
        storeApi.findAndCheckPurchasedOrder(storeApi.respSpecStoreOrder());
    }

    @Test
    @DisplayName("Check that not exist order returns 404 Not Found")
    public void checkSecondCheck() {
        storeApi.checkThatOrderNotExist(storeApi.respSpecOrderNotFound());
    }
}
