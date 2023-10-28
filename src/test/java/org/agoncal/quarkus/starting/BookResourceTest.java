package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given()
            .header(ACCEPT, APPLICATION_JSON)
        .when()
            .get("/api/books")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body("size()", is(4));
    }

    @Test
    public void shouldGetCountAllBooks() {
        given()
            .header(ACCEPT, TEXT_PLAIN)
        .when()
            .get("/api/books/count")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body( is("4"));
    }

    @Test
    public void shouldGetBook() {
        given()
            .header(ACCEPT, APPLICATION_JSON)
                .pathParam("id", 1)
        .when()
            .get("/api/books/{id}")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body("title", is("Understanding Quarkus"))
            .body("author", is("Antonio"))
            .body("genre", is("IT"))
            .body("id", is(1))
            .body("yearOfPublication", is(2020));
    }
}