import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReqresApiTest {

    private static final String BASE_URL = "https://reqres.in/api";
    private static final String API_KEY = "reqres-free-v1";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetUsersList() {
        given().
            header("x-api-key", API_KEY).
            queryParam("page", 2).
        when().
            get("/users").
        then().
            statusCode(200).
            body("page", equalTo(2)).
            body("data", not(empty()));
    }

    @Test
    public void testCreateUser() {
        String userJson = "{ \"name\": \"Marko\", \"job\": \"Tester\" }";
        given().
            header("x-api-key", API_KEY).
            contentType(ContentType.JSON).
            body(userJson).
        when().
            post("/users").
        then().
            statusCode(201).
            body("name", equalTo("Marko")).
            body("job", equalTo("Tester"));
    }

    @Test
    public void testGetUserById() {
        int userId = 2; // uvijek postoji na demo API-ju
        given().
            header("x-api-key", API_KEY).
            pathParam("userId", userId).
        when().
            get("/users/{userId}").
        then().
            statusCode(200).
            body("data.id", equalTo(userId)).
            body("data.email", containsString("@reqres.in"));
    }

    @Test
    public void testUpdateUser() {
        String userJson = "{ \"name\": \"Ivana\", \"job\": \"QA Engineer\" }";
        given().
            header("x-api-key", API_KEY).
            contentType(ContentType.JSON).
            body(userJson).
        when().
            put("/users/2").
        then().
            statusCode(200).
            body("name", equalTo("Ivana")).
            body("job", equalTo("QA Engineer"));
    }

    @Test
    public void testDeleteUser() {
        // Brisanje uvijek vraća 204 (bez sadržaja)
        given().
            header("x-api-key", API_KEY).
        when().
            delete("/users/2").
        then().
            statusCode(204);
    }
}
