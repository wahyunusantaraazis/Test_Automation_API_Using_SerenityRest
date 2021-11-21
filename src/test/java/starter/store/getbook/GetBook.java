package starter.store.getbook;

import net.serenitybdd.rest.SerenityRest;
import starter.utils.Endpoint;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetBook {
    Endpoint endpoint = new Endpoint();

    //GET CERTAIN BOOK BY ISBN
    public void hitEndpointGetBook(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .queryParam("ISBN","9781449365035")
                .when()
                .get(endpoint.GETBOOK)
                .then()
                .statusCode(200);
    }
    //Validate JSONSchema GET BOOK
    public void validateJSONSchemaGetBook(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/bookstore/getbook.json"));
    }
}
