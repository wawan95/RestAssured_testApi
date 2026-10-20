
package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;

public class UserApiTest {

    private static final String BASE_URL =
            "https://jsonplaceholder.typicode.com";

    @Test
    void shouldGetUsersList() {
        given()
            .baseUri(BASE_URL)
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .contentType("application/json")
            .body("size()", greaterThan(0))
            .body("[0].id", equalTo(1));
    }

    @Test
    void shouldGetUserById() {
        given()
            .baseUri(BASE_URL)
        .when()
            .get("/users/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("name", equalTo("Leanne Graham"))
            .body("email", notNullValue());
    }

    @Test
    void shouldCreatePost() {
        String requestBody = """
            {
              "title": "REST Assured Test",
              "body": "Learning API automation",
              "userId": 1
            }
            """;

        given()
            .baseUri(BASE_URL)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("REST Assured Test"))
            .body("body", equalTo("Learning API automation"))
            .body("userId", equalTo(1))
            .body("id", notNullValue());
    }

    @Test
    void shouldUpdatePost() {
        String requestBody = """
            {
              "id": 1,
              "title": "Updated Title",
              "body": "Updated API test",
              "userId": 1
            }
            """;

        given()
            .baseUri(BASE_URL)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", equalTo("Updated Title"))
            .body("body", equalTo("Updated API test"));
    }

    @Test
    void shouldDeletePost() {
        given()
            .baseUri(BASE_URL)
        .when()
            .delete("/posts/1")
        .then()
            .statusCode(200);
    }

    @Test
    void shouldValidatePostResponseFields() {
        given()
            .baseUri(BASE_URL)
        .when()
            .get("/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", equalTo(1))
            .body("title", notNullValue())
            .body("body", notNullValue());
    }

}
