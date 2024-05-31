package request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import payload.Booking;
import payload.BookingDate;

import java.util.HashMap;
import java.util.Map;

public class PutRequestTest {

    @Test
    public void updateBookingUsingPutTest(){
        //1. Create new booking
        BookingDate bookingDate=new BookingDate();
        bookingDate.setCheckin("2018-01-01");
        bookingDate.setCheckout("2019-01-01");

        Booking booking=new Booking();
        booking.setFirstname("kusu");
        booking.setLastname("p");
        booking.setTotalprice(10000.0);
        booking.setDepositpaid(true);
        booking.setBookingdates(bookingDate);
        booking.setAdditionalneeds("Desserts");

        RequestSpecification request= RestAssured.given();
        request.contentType(ContentType.JSON);
        request.body(booking);
        Response response = request.post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
        System.out.println("========================================================");
        //2. get id from the above response
        int bookingId = response.jsonPath().getInt("bookingid");
        System.out.println("Booking id: "+bookingId);
        System.out.println("========================================================");
        //3. update the new resource
        BookingDate updateBookingDate=new BookingDate();
        updateBookingDate.setCheckin("2023-01-01");
        updateBookingDate.setCheckout("2024-01-01");

        Booking updateBooking=new Booking();
        updateBooking.setFirstname("Nitii");
        updateBooking.setLastname("H S");
        updateBooking.setTotalprice(50000);
        updateBooking.setDepositpaid(false);
        updateBooking.setBookingdates(updateBookingDate);
        updateBooking.setAdditionalneeds("Ice cream");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.pathParam("id", bookingId);
        requestSpecification.body(updateBooking);
        requestSpecification.header(new Header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM="));
        Response updatedResponse = requestSpecification.put("https://restful-booker.herokuapp.com/booking/{id}");
        updatedResponse.prettyPrint();
       // System.out.println(updatedResponse.statusCode());
        System.out.println("\n"+updatedResponse.jsonPath().getString("bookingdates.checkout"));
        System.out.println(updatedResponse.jsonPath().getString("additionalneeds"));
        System.out.println("========================================================");
    }

    @Test
    public void updateRequestUsingPatchTest(){
        var updateMap=new HashMap<>();
        updateMap.put("firstname","Nitiii");
        updateMap.put("lastname", "kusuuu");

        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.header(new Header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM="));
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.pathParam("id", 1);
        requestSpecification.header(new Header("Cookie", "token=abc123"));
        requestSpecification.body(updateMap);
        Response updatedResponse = requestSpecification.patch("https://restful-booker.herokuapp.com/booking/{id}");
        updatedResponse.prettyPrint();
    }
}
