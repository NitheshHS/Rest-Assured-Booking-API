package request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import payload.Booking;
import payload.BookingDates;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PostRequestTest {

    @Test
    public void postRequestUsingStringPayloadTest(){
        RequestSpecification specification= RestAssured.given();
        specification.contentType(ContentType.JSON);
        specification.body("{\n" +
                "    \"firstname\" : \"Kusuma\",\n" +
                "    \"lastname\" : \"P\",\n" +
                "    \"totalprice\" : 10000,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-05-24\",\n" +
                "        \"checkout\" : \"2024-06-03\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}");

        Response response = specification.post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
        System.out.println("Content-type: "+ response.contentType());
        System.out.println("Status code: "+response.statusCode());
        System.out.println("Response time: "+response.getTimeIn(TimeUnit.MILLISECONDS));
    }

    @Test
    public void postRequestUsingFilePayloadTest(){
        RequestSpecification specification= RestAssured.given();
        specification.contentType(ContentType.JSON);
        specification.body(new File("./booking.json"));
        Response response = specification.post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
        System.out.println("Content-type: "+ response.contentType());
        System.out.println("Status code: "+response.statusCode());
        System.out.println("Response time: "+response.getTimeIn(TimeUnit.MILLISECONDS));
    }

    @Test
    public void postRequestUsingMapPayloadTest(){

        Map<String, Object> bookingdatesMap=new HashMap<>();
        bookingdatesMap.put("checkin" , "2018-01-01");
        bookingdatesMap.put("checkout" , "2019-01-01");

        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", "Nithesh");
        payload.put("lastname", "H S");
        payload.put("totalprice", "1500");
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingdatesMap);
        payload.put("additionalneeds", "Beer");

        RequestSpecification specification= RestAssured.given();
        specification.contentType(ContentType.JSON);
        specification.body(payload);
        Response response = specification.post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
        System.out.println("Content-type: "+ response.contentType());
        System.out.println("Status code: "+response.statusCode());
        System.out.println("Response time: "+response.getTimeIn(TimeUnit.MILLISECONDS));
    }

    @Test
    public void postRequestUsingPojoTest(){

        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");

        Booking booking=new Booking();
        booking.setFirstname("Kusuma");
        booking.setLastname("P");
        booking.setTotalprice(1500.1);
        booking.setDepositpaid(true);
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Mushroom Biriyani");

        RequestSpecification request=RestAssured.given();
        request.contentType(ContentType.JSON);
        request.body(booking);
        Response response = request.post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
    }

}
