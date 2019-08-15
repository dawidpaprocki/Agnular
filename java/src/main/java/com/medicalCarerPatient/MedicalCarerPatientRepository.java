package com.medicalCarerPatient;

import com.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalCarerPatientRepository extends JpaRepository<MedicalCarerPatient, Long> {
    List<MedicalCarerPatient> findAllByPatient(Patient patient);
    List<MedicalCarerPatient> findByPatientAndActive(Patient patient,Boolean isActive);
}
