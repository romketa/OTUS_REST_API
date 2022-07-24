package otus.ru.rest.api;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import otus.ru.rest.api.dto.Store;
import otus.ru.rest.api.services.StoreApi;

public class CreateStoreOrderTest {


    @Test
    public void checkPostStoreOrder(){
        StoreApi storeApi = new StoreApi();

        storeApi.placeAnOrder();
        storeApi.findPurchasedOrder();
    }




}
