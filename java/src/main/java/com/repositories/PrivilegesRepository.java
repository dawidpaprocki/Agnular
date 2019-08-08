package com.repositories;

import com.entities.MedicalCarer;
import com.entities.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegesRepository extends JpaRepository<Privileges, Long> {

}
