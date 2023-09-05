package com.wanted.preonboarding.theater.acceptance;

import io.restassured.RestAssured;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@DisplayName("TheaterController 테스트")
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TheaterAcceptanceTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void beforeEach() {
        RestAssured.port = port;
    }

    @Test
    public void test() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("audienceId", "1");
        requestBody.put("ticketId", "1");

        var extract = RestAssured.given().log().all()
                .body(requestBody)
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .when().post("/theater/enter")
                .then().log().all().extract();

        assertThat(extract.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
