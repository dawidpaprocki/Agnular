package com.repositories;

import com.entities.MedicalFacility;
import com.entities.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalFacilityRepository extends JpaRepository<MedicalFacility, Long> {

}
