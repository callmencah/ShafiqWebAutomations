package Utils;

import com.github.javafaker.Faker;

public class Library {
    protected Faker faker = new Faker();
    protected String fakeName = faker.name().fullName();
    protected String fakeEmail = faker.internet().emailAddress();
    protected String firstName = faker.name().firstName();

}

