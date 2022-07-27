package otus.ru.rest.api;

import org.junit.jupiter.api.*;
import otus.ru.rest.api.services.StoreApi;


public class StoreOrderTest {

    @Test
    @DisplayName("Check creation an order, get created order and delete created order")
    public void checkPostStoreOrder() {
        
        StoreApi storeApi = new StoreApi();

        storeApi.placeAnOrder(storeApi.respSpecStoreOrder())
                .findAndCheckPurchasedOrder(storeApi.respSpecStoreOrder())
                .deletePurchasedOrder(storeApi.respSpecDeleteOrder());
    }

    @Test
    @DisplayName("Check that already deleted entity returns 404")
    public void checkSecondCheck() {

        StoreApi storeApi = new StoreApi();

        storeApi.placeAnOrder(storeApi.respSpecStoreOrder())
                .findAndCheckPurchasedOrder(storeApi.respSpecStoreOrder())
                .deletePurchasedOrder(storeApi.respSpecDeleteOrder())
                .deletePurchasedOrder(storeApi.respSpecDeleteOrderNotFound());
    }
}
