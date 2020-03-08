import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HealthCheck {

    @Test
    public void HealthCheck_ShouldReturn_OK() {

        given().
                when().
                get("http://localhost:8080/actuator/health").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }
}
