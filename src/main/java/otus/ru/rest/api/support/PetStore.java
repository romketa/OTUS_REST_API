package otus.ru.rest.api.support;

import com.google.inject.Inject;
import io.restassured.specification.ResponseSpecification;
import otus.ru.rest.api.services.BaseApi;
import otus.ru.rest.api.services.PetStoreApi;
import otus.ru.rest.api.services.StoreApi;
import otus.ru.rest.api.services.UserApi;

public class PetStore {

    private PetStoreApi petStoreApi;

    @Inject
    public PetStore(PetStoreApi petStoreApi) {
        this.petStoreApi = petStoreApi;
    }

    public StoreApi storeApi(){
        return new StoreApi();
    }

    public UserApi userApi(){
        return new UserApi();
    }
}
