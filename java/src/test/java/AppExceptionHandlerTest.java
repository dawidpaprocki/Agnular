
import com.AppExceptionHandler;
import com.CustomException;
import com.tools.PropertiesReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PropertiesReader.class)
@TestPropertySource(locations = "classpath:test.properties")
public class AppExceptionHandlerTest {

  @Autowired
  PropertiesReader propertiesReader;


  @Before
  public void setUp() throws IOException {
  }

  @Test
  public void handleAnyException() {
    // given
    AppExceptionHandler appExceptionHandler = new AppExceptionHandler();
    String testMessage = "Test Message";
    // when
    ResponseEntity<Object> testResponseEntity = appExceptionHandler.handleAnyException(new CustomException(""), testMessage);
    // then
    assertEquals(testMessage,testResponseEntity.getBody());
  }
}
