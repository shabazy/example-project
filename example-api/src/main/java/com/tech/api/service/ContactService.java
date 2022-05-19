package com.tech.api.service;

import com.tech.api.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ContactService {

    Page<Contact> getContacts(Specification<Contact> contactSpecification, Pageable pageable);

}
