package starter.account.getdeleteuser;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.utils.Endpoint;

public class GetUser {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;
    String token;
    String userId;

    public void setBodyReq(){ //Valid username and password
        requestParams = new JSONObject();
        requestParams.put("userName","lalakomala212");
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
    //hit endpoint untuk delete
    public  void hitEndpointDeleteUserID(){
        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .header("Authorization","Bearer "+token)
                .when()
                    .delete(endpoint.GETUSERID+userId)
                .then()
                .statusCode(204);
    }
    public void hitEndpointUserID(){
        SerenityRest
                .given()
                    .header("Content-Type","application/json")
                    .header("Authorization","Bearer")
                .when()
                    .get(endpoint.GETUSERID+userId)
                .then()
                    .statusCode(401);
    }

}
