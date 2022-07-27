import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({otus.ru.rest.api.StoreOrderTest.class, otus.ru.rest.api.UserTest.class})
public class TestSuite {
}
