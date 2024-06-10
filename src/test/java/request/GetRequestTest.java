package request;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GetRequestTest {
    @Test
    public void getTest(){
        //Request
       /* RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        //Response
        Response response = requestSpecification.get("https://petstore.swagger.io/v2/pet/12");
        //validation
        response.prettyPrint();*/ //response body

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/pet/15757")
                .then()
                .log().all();//headers + response body

    }

    @Test
    public void getBookingIdList(){
        RestAssured.given()//headers+req body+auth+path param + query param + cookie
                .contentType(ContentType.JSON)
                .when()// get, post, put, delete, patch
                .get("https://restful-booker.herokuapp.com/booking")
                .then()// assertion, statuscode, logs, status, response time
                .assertThat().time(Matchers.lessThan(2500L), TimeUnit.MILLISECONDS)
                .assertThat().contentType(ContentType.JSON)
                //.assertThat().body("[1].bookingid", Matchers.equalTo(1052))//syntax -> .body("jsonpath", Matchers condition)
                .assertThat().header("X-Powered-By", Matchers.equalTo("Express"))//syntax -> .header("header key", Matchers conditions)
                .log().all();
        /*
        1. Given - request setup
        2. when -  crud operations
        3. then - response validation
         */
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
