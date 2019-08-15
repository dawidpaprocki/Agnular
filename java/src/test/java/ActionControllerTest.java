import com.Application;
import com.action.Action;
import com.action.ActionController;
import com.action.ActionRepository;
import com.exception.EntityNotFoundException;
import com.medicalCarer.MedicalCarer;
import com.tools.PropertiesReader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ActionControllerTest {


  @Mock
  private PropertiesReader propertiesReader;

  @InjectMocks
  private ActionController actionController;

  //  @Mock
  @Autowired
  public ActionRepository actionRepository;

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

//  @Test
//  public void getPatientTestTrue() {
//    // given
//    Patient patient = new Patient();
//    patient.setId(1L);
//    // when
//    when(patientRepository.findById(1L)).thenReturn(java.util.Optional.of(patient));
//    Patient testPatient = patientController.getPatient(1L);
//    // then
//    assertEquals(1L, testPatient.getId().longValue());
//  }
//
//  @Test
//  public void getPatientTestFalse() {
//    // given
//    Patient patient = new Patient();
//    patient.setId(1L);
//    // when
//    when(patientRepository.findById(1L)).thenReturn(java.util.Optional.of(patient));
//    Patient testPatient = patientController.getPatient(1L);
//    // then
//    assertNotEquals(2L, testPatient.getId().longValue());
//  }

  @Test
  public void getPatientExceptionTest() {
    // given
    // when
//    when(propertiesReader.getPropertiesFile().getProperty(any())).thenReturn("no patient");
    // then
    exceptionRule.expectMessage("Action id: 1");
    exceptionRule.expect(EntityNotFoundException.class);
    actionController.getAction(1L);
  }
  //
  @Test
  public void addAction() {
    // given
    Action action = new Action();
    action.setMedicalCarer(new MedicalCarer());
    // when
//    when(actionRepository.save(any()));
    actionController.addAction(action);
    // then
//    assertEquals(2, testPatientList.size());
  }



}
