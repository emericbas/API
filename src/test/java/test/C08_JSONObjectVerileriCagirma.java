package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */
    
    
    @Test
    public void jsonPath01(){
        
        JSONObject homePhone=new JSONObject();
        homePhone.put("type", "home");
        homePhone.put("number", "0123-4567-8910");
       

        JSONObject moboliPhone=new JSONObject();
        moboliPhone.put("type", "iPhone");
        moboliPhone.put("number", "0123-4567-8888");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(0,homePhone);
       // phoneNumbers.put(homePhone); bu da olur, yeri garanti degil
        phoneNumbers.put(1,moboliPhone);
       // phoneNumbers.put(moboliPhone);
        
        JSONObject address=new JSONObject();
        address.put("streetAddress", "naist street");
        address.put("city", "Nara");
        address.put("postalCode", "630-0192");

        JSONObject person=new JSONObject();
        person.put("firstName", "John");
        person.put("lastName", "doe");
        person.put("age", 26);
        person.put("address",address);
        person.put("phoneNumbers",phoneNumbers);
        System.out.println("person = " + person);
       
        /*
    person =
         {
          "firstName":"John",
          "lastName":"doe",
          "address":
               {
               "streetAddress":"naist street",
               "city":"Nara",
               "postalCode":"630-0192"
               },
          "age":26,
          "phoneNumbers":
        [
        {"number":"0123-4567-8910","type":"home"},
        {"number":"0123-4567-8888","type":"iPhone"}
        ]
        }

         */

        System.out.println("Firstname :"+person.get("firstName"));
        System.out.println("LastName :"+person.get("lastName"));
        System.out.println("Age :"+person.get("age"));
        System.out.println("StreetAddress :"+person.getJSONObject("address").get("streetAddress"));
        System.out.println("PostalCode :"+person.getJSONObject("address").get("postalCode"));
        System.out.println("City :"+person.getJSONObject("address").get("city"));

        System.out.println("MobilePhone: "+person.getJSONArray("phoneNumbers")
                                         .getJSONObject(1).get("number"));

        System.out.println("MobilePhoneType: "+person.getJSONArray("phoneNumbers").
                                                getJSONObject(1).get("type"));
        System.out.println(person.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));//home

    }
}
