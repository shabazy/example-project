package com.tech.api.service;

import com.tech.api.entity.Contact;
import com.tech.api.repository.ContactRepository;
import com.tech.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Cacheable(Constants.CacheKey.CONTACT_LIST)
    public Page<Contact> getContacts(Specification<Contact> contactSpecification, Pageable pageable) {
         return contactRepository.findAll(contactSpecification, pageable);
    }
}
