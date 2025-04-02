package com.labseq;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class LabseqResourceTest {
    @Test
    void LabseqGetNTest() {
        given()
          .when().get("/labseq/10")
          .then()
             .statusCode(200)
             .body(is("3"));
    }

    @Test
    void LabseqGetNTestInvalid() {
        given()
          .when().get("/labseq/-1")
          .then()
             .statusCode(500);
    }
}