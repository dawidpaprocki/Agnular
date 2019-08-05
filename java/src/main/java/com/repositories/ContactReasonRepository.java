package com.repositories;

import com.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactReasonRepository extends JpaRepository<Contact, Long> {
}
