package starter.account.register;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import starter.UsernameGenerator;
import starter.utils.Endpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Register {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;

    public void setBodyReq(){
        requestParams = new JSONObject();
        requestParams.put("userName", UsernameGenerator.getUsername(10));
        requestParams.put("password","@Password98");
    }
    public void setBodyReqFailed(){
        requestParams = new JSONObject();
        requestParams.put("userName","yogasaratoga");
        requestParams.put("password","@Password123");
    }

    public void hitEnpointRegister(){
        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .body(requestParams.toString())
                .when()
                    .post(endpoint.REGISTER)
                .then()
                    .statusCode(201);
    }
    public void hitEnpointRegisterFailed(){
        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .body(requestParams.toString())
                .when()
                    .post(endpoint.REGISTER)
                .then()
                    .statusCode(406);
    }

    @Step
    public void validateEndpointRegister(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/register.json"));
    }

}
