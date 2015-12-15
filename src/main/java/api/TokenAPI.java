package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import utils.CredentialManager;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by jorgeavila on 12/12/2015.
 */
public class TokenAPI {

    private final static String LOGIN_SERVICE = "login";

    /**
     * Gets the token for a user account
     * @param userName can be normal or from a domain e.g. "domain\\user" or "user"
     * @param password is the user password
     * @param authentication can be "ldap" or "local"
     * @return the token for the user account
     */
    public static String getToken(String userName, String password, String authentication){
        RestAssured.baseURI = CredentialManager.getInstance().getRoomManagerService();
        RestAssured.useRelaxedHTTPSValidation();

        JSONObject request = new JSONObject();
        request.put("username", userName);
        request.put("password", password);
        request.put("authentication", authentication);

        Response response = given()
                .contentType("application/json")
                .body(request.toString())
                .when()
                .post("login");

        JSONObject auth = new JSONObject(response.asString());
        return auth.getString("token");
    }

}
