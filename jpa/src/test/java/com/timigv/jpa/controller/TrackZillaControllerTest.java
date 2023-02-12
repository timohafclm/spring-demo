package com.timigv.jpa.controller;

import com.timigv.jpa.entity.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrackZillaControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void addApplication() throws Exception {
        var application = givenApplication();

        var responseEntity = restTemplate.postForEntity(testUrl("/tza/application/"), application, Void.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    private String testUrl(String path) {
        return "http://localhost:" + port + path;
    }

    private Application givenApplication() {
        var app = new Application();
        app.setName("Test Application");
        app.setDescription("A test application");
        app.setOwner("Tim");
        return app;
    }
}