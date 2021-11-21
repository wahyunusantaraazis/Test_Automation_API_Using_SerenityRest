package starter.account.login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import starter.utils.Endpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Login {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;
    public String token;
    public String userId;

    public void setBodyReq(){ //Valid username and password
        requestParams = new JSONObject();
        requestParams.put("userName","yogasaratoga");
        requestParams.put("password","@Password123");
    }

    public void hitEndpointLogin(){
        SerenityRest
                .given()
                    .header("Content-Type", "application/json")
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

    public void hitEndpointUserID(){
        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .header("Authorization", "Bearer " +token)
                .when()
                    .get(endpoint.GETUSERID+userId)
                .then()
                    .statusCode(200);
    }

    @Step
    public void validateEndpointLogin(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/login.json"));
    }
}
