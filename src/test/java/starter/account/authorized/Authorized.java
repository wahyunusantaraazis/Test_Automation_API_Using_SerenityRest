package starter.account.authorized;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import starter.utils.Endpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Authorized {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParam;

    public void setBodyReq(){
        requestParam = new JSONObject();
        requestParam.put("userName","yogasaratoga");
        requestParam.put("password","@Password123");
    }
    public void hitEndpoitnAuthorized(){
        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .body(requestParam.toString())
                .when()
                    .post(endpoint.AUTHORIZED)
                .then()
                    .statusCode(200);
    }

//    @Step
//    public void validateEndpointAuthorized(){
//        SerenityRest
//                .then()
//                .body(matchesJsonSchemaInClasspath())
//    }
}
