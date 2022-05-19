package com.tech.api.integration;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;


import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
class ContactControllerTest {

    private static final String CONTACTS_ENDPOINT = "/api/contacts";

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void testContactsSuccess() {
        String searchNameParameter = "Homer";
        List<HashMap<String, Object>> contents = getContents(searchNameParameter);
        String name = String.valueOf(contents.get(0).get("name"));
        Assertions.assertTrue(name.contains(searchNameParameter));
    }

    @Test
    public void testContactsFail() {
        String searchNameParameter = "aaaaaaaaaaa";
        List<HashMap<String, Object>> contents = getContents(searchNameParameter);
        Assertions.assertEquals(0, contents.size());
    }

    private List<HashMap<String, Object>> getContents(String searchNameParameter) {
        Response response = given().queryParam("name", searchNameParameter)
                .get(CONTACTS_ENDPOINT);
        JsonPath jpath = response.jsonPath();
        return jpath.get("content");
    }

}
