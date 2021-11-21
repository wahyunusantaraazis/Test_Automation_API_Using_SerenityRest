package starter.store.getallbooks;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.utils.Endpoint;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetAllBooks {
    Endpoint endpoint = new Endpoint();
    //GET ALL BOOKS
    public void hitEndpointGetAllBooks(){
        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                .when()
                    .get(endpoint.GETALLBOOKS)
                .then()
                    .statusCode(200);
    }

    //Validate JSONSchema GET ALL BOOKS
    public void validateJSONSchemaGetAllBooks(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/bookstore/getallbooks.json"));
    }
}
