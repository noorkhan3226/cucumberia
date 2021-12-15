package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    public static String token;
    String baseURL= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification request= given().header("Content-type","application/json").body(
                "{\n" +
                        "  \"email\": \"khanABCD\",\n" +
                        "  \"password\": \"jh12345aaa\"\n" +
                        "}"
        );

        Response response=request.when().post("/generateToken.php");
        response.prettyPrint();

        token ="Bearer "+response.jsonPath().getString("token");
        //System.out.println(token);
    }
}
