package com.tech.api.controller;

import com.tech.api.entity.Contact;
import com.tech.api.service.ContactService;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @CrossOrigin
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<Contact> getContacts(@And({
            @Spec(path = "name", spec = Like.class)
    }) Specification<Contact> contactSpecification, Pageable pageable) {
        return contactService.getContacts(contactSpecification, pageable);
    }

}
