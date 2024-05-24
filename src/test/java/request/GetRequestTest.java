package request;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetRequestTest {
    @Test
    public void getTest(){
        //Request
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        //Response
        Response response = requestSpecification.get("https://petstore.swagger.io/v2/pet/12");
        //validation
        response.prettyPrint();
    }

    @Test
    public void getCourseTest(){
        HashMap<String, Object> header = new HashMap<>();
        header.put("Authorization", "Bearer <token>");


        RequestSpecification request = RestAssured.given();
        request.baseUri("http://localhost:8080");
        request.contentType(ContentType.JSON);
//        request.headers(header);
//        request.auth().basic("username", "password");
//        request.auth().oauth2("token");
//        request.cookie("");
        request.pathParam("id", 1);
        //request.queryParam("queryParam", "query value");



        Response response = request.get("/course/{id}");
        response.prettyPrint();
    }
}
