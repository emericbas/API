package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C01_Get_ApiSorgulama {
/*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
*/
//1- Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body'i hazirla
//2- Eger soruda bize verilmisse Expected Data'yi hazirla
//3- Bize donen Response'i Actual Data olarak kaydet
//4- Expected Data ile Actual Data'yi karsilastirmamiz yani Assertion yap
    @Test
    public void get01(){



        //1- Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body'i hazirla
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- Eger soruda bize verilmisse Expected Data'yi hazirla
        //3- Bize donen Response'i Actual Data olarak kaydet
        Response response=given().when().get(url);
       response.prettyPrint();// consol'da gormemizi saglar

        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Content Type: "+response.getContentType());
        System.out.println("Server Header Degeri: "+response.getHeader("Server"));
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Response Time: "+response.getTime());

        //4- Expected Data ile Actual Data'yi karsilastirmamiz yani Assertion yap
    }


}
