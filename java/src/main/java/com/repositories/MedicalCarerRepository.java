package com.repositories;

import com.entities.MedicalCarer;
import com.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCarerRepository extends JpaRepository<MedicalCarer, Long> {

}
