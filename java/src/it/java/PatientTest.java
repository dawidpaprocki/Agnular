import com.tools.Constance;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.Assert.assertNotNull;


public class PatientTest {

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testCreatePatient() {

    Map<String,Object> patient = new HashMap<>();
    patient.put("id", 1L);

    Response response =
      given()
      .contentType("application/json")
      .accept("application/json")
      .body(patient)
      .when()
      .post(Constance.URL_ADRESS + "/patients")
      .then()
      .statusCode(200)
      .contentType("application/json")
      .extract()
      .response();
    String userId = response.jsonPath().getString("Id");
    assertNotNull(userId);
  }


  @Test
  public void testIfPathWorking() {
    RestAssured
      .when()
      .get(Constance.URL_ADRESS + "/patients")
      .then()
      .assertThat()
      .statusCode(200);
  }

  @Test
  public void getAllPatientsTrue() {
    RestAssured
      .when()
      .get(Constance.URL_ADRESS + "/patients")
      .then()
      .assertThat()
      .body( "id", hasSize(greaterThan(0)));
  }

  @Test
  public void getPatientTrue() {
    RestAssured
      .when()
      .get(Constance.URL_ADRESS + "/patients/1")
      .then()
      .assertThat()
      .body( "id", equalTo(1));
  }

  @Test
  public void getPatientFalse() {
    RestAssured
      .when()
      .get(Constance.URL_ADRESS + "/patients1")
      .then()
      .assertThat()
      .body( "id", not(equalTo(2)));
  }


}
