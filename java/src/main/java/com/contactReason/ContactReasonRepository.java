package com.contactReason;

import com.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactReasonRepository extends JpaRepository<ContactReason, Long> {
}
