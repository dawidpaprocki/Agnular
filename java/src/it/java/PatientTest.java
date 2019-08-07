import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.number.OrderingComparison.*;


public class PatientTest {

  @Test
  public void testIfPathWorking() {
    RestAssured
      .when()
      .get("http://localhost:8080/patients")
      .then()
      .assertThat()
      .statusCode(200);
  }

  @Test
  public void getAllPatientsTrue() {
    RestAssured
      .when()
      .get("http://localhost:8080/patients")
      .then()
      .assertThat()
      .body( "id", hasSize(greaterThan(0)));
  }

  @Test
  public void getPatientTrue() {
    RestAssured
      .when()
      .get("http://localhost:8080//patients/1")
      .then()
      .assertThat()
      .body( "id", equalTo(1));
  }
  @Test
  public void getPatientFalse() {
    RestAssured
      .when()
      .get("http://localhost:8080//patients/1")
      .then()
      .assertThat()
      .body( "id", not(equalTo(2)));
  }
}
