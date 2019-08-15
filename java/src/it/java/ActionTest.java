import com.tools.Constance;
import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ActionTest {

  @Test
  public void getActionTest(){
    RestAssured
      .when()
      .get(Constance.URL_ADRESS + "/action/1")
      .then()
      .assertThat()
      .statusCode(404);
  }

  @Test
  public void saveActionTest(){

    Map<String,Object> action = new HashMap<>();
    action.put("id", 1L);
    action.put("MedicalCarerId", 1L);

    given()
      .contentType("application/json")
      .accept("application/json")
      .body(action)
      .when()
      .post(Constance.URL_ADRESS + "/addAction")
      .then()
      .statusCode(201)
      .contentType("application/json")
      .extract()
      .response();
  }
}
