package main;

import com.AppExceptionHandler;
import com.CustomException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class AppExceptionHandlerTest {


  @Before
  public void setUp() {
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
