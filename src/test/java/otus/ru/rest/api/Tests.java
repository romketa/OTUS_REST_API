package otus.ru.rest.api;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Tests {


    @Test
    public void test1(){
        LocalDateTime lct = LocalDateTime.now();
        System.out.println(lct);
        System.out.println(lct.toString());
    }

}
