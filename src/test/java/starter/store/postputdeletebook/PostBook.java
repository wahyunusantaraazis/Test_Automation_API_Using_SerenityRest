package starter.store.postputdeletebook;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.utils.Endpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostBook {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;
    String token;
    String userId;
    String ISBN;
    HashMap requestpayload;
    JSONObject replaceisbn;
    JSONObject deleteisbn;

    public void setBodyReq(){
        requestParams = new JSONObject();
        requestParams.put("userName","yogasaratoga");
        requestParams.put("password","@Password123");
    }

    public void hitEndpointLogin(){
        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .body(requestParams.toString())
                .when()
                    .post(endpoint.LOGIN)
                .then()
                    .statusCode(200);

        token = SerenityRest
                .then()
                    .extract()
                    .path("token");

        userId = SerenityRest
                .then()
                    .extract()
                    .path("userId");
    }

    //POST BOOK
    public void hitEndpointPostBook(){
        Map<String,Object> requestpayload = new HashMap<>();
        requestpayload.put("userId",userId);
        requestpayload.put("collectionOfIsbns", new ArrayList<Object>(){
            {
                add(new HashMap<String,Object>(){
                    {
                        put("isbn","9781449325862");
                    }
                });
            }
        });

        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .header("Authorization","Bearer " +token)
                    .body(requestpayload)
                .when()
                    .post(endpoint.POSTBOOK)
                .then()
                    .statusCode(201);

        ISBN = SerenityRest
                .then()
                .extract()
                .path( "collectionOfIsbns[0].isbn");
    }

    //PUT BOOK
    public void hitEnpointPutBook(){
        replaceisbn = new JSONObject();
        replaceisbn.put("userId",userId);
        replaceisbn.put("isbn","9781449331818");

        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .header("Authorization","Bearer " +token)
                    .body(replaceisbn.toString())
                .when()
                    .put(endpoint.PUTBOOK+ISBN)
                .then()
                    .statusCode(200);
    }

    //DELETE BOOK
    public void hitEndpointDeleteBook(){
        deleteisbn = new JSONObject();
        deleteisbn.put("isbn","9781449331818");
        deleteisbn.put("userId",userId);

        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .header("Authorization","Bearer " +token)
                    .body(deleteisbn.toString())
                .when()
                    .delete(endpoint.DELETEBOOK)
                .then()
                    .statusCode(204);
    }

    public void validateJSONSchemaPostBook(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/bookstore/postbook.json"));
    }
    public void validateJSONSchemaPutBook(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/bookstore/putbook.json"));
    }
    public void validateJSONSchemaDeleteBook(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/bookstore/delete.json"));
    }
}

//9781449325862 post
//9781449331818 update
