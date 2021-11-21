package starter.account.generatetoken;

import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import starter.UsernameGenerator;
import starter.utils.Endpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GenerateToken {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;

    public void setBodyReq(){
        requestParams = new JSONObject();
        requestParams.put("userName","yogasaratoga");
        requestParams.put("password","@Password123");
    }

    public void setBodyReqFailed(){
        requestParams = new JSONObject();
        requestParams.put("userName", UsernameGenerator.getUsername(10));
        requestParams.put("password","tidakada");
    }

    public void hitEndpointGenerateToken(){
       SerenityRest
               .given()
                    .header("Content-Type","application/json")
                    .body(requestParams.toString())
               .when()
                    .post(endpoint.GENERATETOKEN)
               .then()
                    .statusCode(200);
    }



    @Step
    public void validateEndpointGenerateToken(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/generatetokensucces.json"));
    }

    @Step
    public void validateEndpointGenerateTokenFailed(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/generatetokenfailed.json"));
    }
}
