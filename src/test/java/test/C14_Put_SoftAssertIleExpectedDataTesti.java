package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {
/*
http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
{
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40
}
}
Response Body
{ "status": "success",
"data": {
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40 }
},
"message": "Successfully! Record has been updated."}


 */
@Test
    public  void put01(){
    
    //1- Irl ve Body hazirla
    String url="https://dummy.restapiexample.com/api/v1/update/21";
    JSONObject data=new JSONObject();
    data.put("name","Ahmet");
    data.put("salary","1230");
    data.put("age", "44");
    data.put("id", 40);
    JSONObject reqBody=new JSONObject();
    reqBody.put("status", "success");
    reqBody.put("data", data);
    reqBody.put("message", "Successfully! Record has been updated.");
    System.out.println("reqBody = " + reqBody);
     // 2 - Expected Data Hazirla
   /* Response Body
    {
        "status": "success",
                "data": {
            "name": “Ahmet",
            "salary": "1230",
                    "age": "44",
                    "id": 40 }
    },
        "message": "Successfully! Record has been updated."}
        
    */
    JSONObject expBody=new JSONObject();
    expBody.put("status", reqBody);
    expBody.put("message", "Successfully! Record has been updated.");
    System.out.println("expBody = " + expBody);

    //3- response hazirla
    Response response=given().contentType(ContentType.JSON).when().put(url);
    response.prettyPrint();

    //4 -Assertion
    JsonPath respJS=response.jsonPath();
    SoftAssert softAssert=new SoftAssert();
    softAssert.assertEquals(respJS.get("status") ,reqBody.get("status"));
    softAssert.assertEquals(respJS.get("message") ,reqBody.get("message"));
    softAssert.assertEquals(respJS.get("data"),reqBody.getJSONObject("data").get("name"));
    softAssert.assertEquals(respJS.get("data"),reqBody.getJSONObject("data").get("salary"));
    softAssert.assertEquals(respJS.get("data"),reqBody.getJSONObject("data").get("age"));
    softAssert.assertEquals(respJS.get("data"),reqBody.getJSONObject("data").get("id"));
    softAssert.assertAll();
}
}