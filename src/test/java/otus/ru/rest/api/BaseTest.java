package otus.ru.rest.api;

import com.google.inject.Guice;
import com.google.inject.Injector;
import otus.ru.rest.api.services.StoreApi;
import otus.ru.rest.api.services.UserApi;
import otus.ru.rest.api.support.PetStore;
import otus.ru.rest.api.support.PetStoreModule;

public abstract class BaseTest {

    Injector injectorStore = Guice.createInjector(new PetStoreModule());
    PetStore petStore = injectorStore.getInstance(PetStore.class);

    StoreApi storeApi = petStore.storeApi();
    UserApi userApi = petStore.userApi();
}
