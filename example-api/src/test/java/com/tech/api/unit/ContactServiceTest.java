package com.tech.api.unit;

import com.tech.api.entity.Contact;
import com.tech.api.repository.ContactRepository;
import com.tech.api.service.ContactServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
public class ContactServiceTest {

    @InjectMocks
    ContactServiceImpl contactService;

    @Mock
    ContactRepository contactRepository;

    @Test
    public void testSearchSuccess() {
        String name = "homer";
        Specification<Contact> contactSpecification = (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%"+name+"%");
        PageRequest pageRequest = PageRequest.of(1, 5);
        Page<Contact> exampleContacts = new PageImpl<>(generateContacts());
        Mockito.when(contactRepository.findAll(contactSpecification, pageRequest)).thenReturn(exampleContacts);
        Page<Contact> contacts = contactService.getContacts(contactSpecification, pageRequest);
        Assertions.assertEquals(contacts.getSize(), exampleContacts.getSize());
    }

    private List<Contact> generateContacts() {
        Contact contact1 = generateContact("Homer Simpson", "https://vignette.wikia.nocookie.net/simpsons/images/b/bd/Homer_Simpson.png/revision/latest/scale-to-width-down/72?cb=20140126234206");
        Contact contact2 = generateContact("Maggie Simpson", "https://vignette.wikia.nocookie.net/simpsons/images/8/89/Maggie.png/revision/latest/scale-to-width-down/87?cb=20090115172358");
        return List.of(contact1, contact2);
    }

    private Contact generateContact(String name, String url) {
        Contact contact2 = new Contact();
        contact2.setName(name);
        contact2.setUrl(url);
        return contact2;
    }


}
