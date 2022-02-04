package DemoTest;

import io.restassured.path.json.JsonPath;

public class JsonPathSimpleObject {
    public static void main(String[] args) {
        String jsonObject = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \n" +
                "        {\n" +
                "            \"Hello1\" : \"2018-01-011111\",\n" +
                "            \"Hello2\" : \"2018-01-01\"\n" +
                "        },\n" +
                "        \n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        JsonPath json = new JsonPath(jsonObject);
        String checkin = json.getString("bookingdates.checkin.Hello1");
        System.out.println(checkin);

    }
}
