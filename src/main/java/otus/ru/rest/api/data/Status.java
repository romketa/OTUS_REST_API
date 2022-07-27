package otus.ru.rest.api.data;

public enum Status {

    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private final String name;

    public String getName() {
        return name;
    }

    Status(String name) {
        this.name = name;
    }
}
