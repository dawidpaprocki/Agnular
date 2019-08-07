import com.CustomException;
import com.controllers.PatientController;
import com.entities.Patient;
import com.repositories.PatientRepository;
import com.tools.PropertiesReader;
import org.hibernate.mapping.Any;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class PatientControllerTest {


  @Mock
  private PropertiesReader propertiesReader;

  @InjectMocks
  private PatientController patientController;

  @Mock
  private PatientRepository patientRepository;

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getPatientTestTrue() {
    // given
    Patient patient = new Patient();
    patient.setId(1L);
    // when
    when(patientRepository.findById(1L)).thenReturn(java.util.Optional.of(patient));
    Patient testPatient = patientController.getPatient(1L);
    // then
    assertEquals(1L, testPatient.getId().longValue());
  }

  @Test
  public void getPatientTestFalse() {
    // given
    Patient patient = new Patient();
    patient.setId(1L);
    // when
    when(patientRepository.findById(1L)).thenReturn(java.util.Optional.of(patient));
    Patient testPatient = patientController.getPatient(1L);
    // then
    assertNotEquals(2L, testPatient.getId().longValue());
  }

  @Test
  public void getPatientExceptionTest() {
    // given
    // when
    when(propertiesReader.getPropertiesFile().getProperty(any())).thenReturn("no patient");
    // then
    exceptionRule.expectMessage("no patient");
    exceptionRule.expect(CustomException.class);
    patientController.getPatient(1L);
  }

  @Test
  public void getAllPatientTest() {
    // given
    Patient patient = new Patient();
    Patient patient2 = new Patient();
    patient.setId(1L);
    patient2.setId(2L);
    List<Patient> patientList = Arrays.asList(patient, patient2);
    // when
    when(patientRepository.findAll()).thenReturn(patientList);
    List testPatientList = patientController.getPatients();
    // then
    assertEquals(2, testPatientList.size());
  }



}
