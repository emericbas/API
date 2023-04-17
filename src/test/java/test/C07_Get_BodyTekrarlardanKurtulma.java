package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {

     /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname“in,"Mark",
                    ve "lastname“in, "Jackson",
                    ve "totalprice“in, 233,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */
   @Test
    public void get01(){

       // 1- Request icin gerekli url hazirla
       String url="https://restful-booker.herokuapp.com/booking/10 ";

       // 2-Expected data hazirla


       //3 -Response'i kaydet
       Response response=given().when().get(url);
       response.prettyPrint();

       //4 - Assertion
    /*   response
               .then()
               .assertThat()
               .statusCode(200).contentType(ContentType.JSON)
               .body("firstname", Matchers.equalTo("Mark"),
                       "lastname",Matchers.equalTo("Jackson"),
                       "totalprice",Matchers.equalTo(233),"depositpaid",
                       Matchers.equalTo(false),
                       "additionalneeds",Matchers.equalTo("Breakfast"));

     */
// Tekrarlardan kurtulduk. Bir tane Matchers'i silince alti kirmizi cizgili oldu.MatchersEqualTo Method'una import etttik
       response
               .then()
               .assertThat()
               .statusCode(200).contentType(ContentType.JSON)
               .body("firstname", equalTo("Mark"),
                       "lastname", equalTo("Jackson"),
                       "totalprice", equalTo(233),"depositpaid",
                       equalTo(false),
                       "additionalneeds", equalTo("Breakfast"));
   }
















}
