package otus.ru.rest.api.support;

import com.google.inject.AbstractModule;
import otus.ru.rest.api.services.BaseApi;
import otus.ru.rest.api.services.PetStoreApi;
import otus.ru.rest.api.services.StoreApi;
import otus.ru.rest.api.services.UserApi;

public class PetStoreModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(PetStoreApi.class).to(BaseApi.class);
    }
}
