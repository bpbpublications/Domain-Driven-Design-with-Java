package expert.os.books.ddd.chapter04.domain;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class LoyaltyCardRepositoryTest {

    @Container
    public PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:13")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @Test
    void shouldSaveAndRetrieveLoyaltyCard() {
        String databaseName = postgresContainer.getDatabaseName();
        String username = postgresContainer.getUsername();
        String password = postgresContainer.getPassword();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(databaseName).isEqualTo("testdb");
            softly.assertThat(username).isEqualTo("test");
            softly.assertThat(password).isEqualTo("test");
        });
    }

}
