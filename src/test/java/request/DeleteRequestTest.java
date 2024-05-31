package request;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteRequestTest {

    @Test
    public void deleteBookingTest(){
        //1. delete the existing resource
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header(new Header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM="));
        requestSpecification.pathParam("id", 475);
        Response response = requestSpecification.delete("https://restful-booker.herokuapp.com/booking/{id}");
        response.prettyPrint();

        //2. check the deleted resource by id
        Response getDeletedResponse = RestAssured.given()
                .pathParam("id", 475)
                .header(new Header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM="))
                .get("https://restful-booker.herokuapp.com/booking/{id}");

        getDeletedResponse.prettyPrint();
    }
}
