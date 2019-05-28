package streams.dtos;

public enum Country {

    SPAIN("Spain"),
    GERMANY("Germany");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
