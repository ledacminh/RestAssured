package Utils;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import io.restassured.RestAssured;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HelperMethods {

    /*
    Verify the http response status returned. Check status Code is 200?
    we can use Rest Assured library's response's getStatusCode method.
     */
    public static void checkStatusIs200(Response response){
        Assert.assertEquals("Status Check successfully!", 200, response.getStatusCode());
    }
    /*
    Get list all value by JsonPath
     */
    public static ArrayList<String> getListByJsonpath(String value, JsonPath jsonPath){
        ArrayList<String> list = jsonPath.get(value);
        return list;
    }

    /*
    Get relate value by JsonPath and index
     */
    public static ArrayList getRelateVauleByJsonpathAndIndex(JsonPath jsonPath, String value, int index){
        ArrayList relateList = jsonPath.get(value);
        ArrayList splitRelateList =  (ArrayList)relateList.get(index);
        return splitRelateList;
    }
    /*
    Merge 2 list
     */
    public static ArrayList mergeLists(ArrayList list1, ArrayList list2){
        ArrayList mergeList = new ArrayList(list1);
        mergeList.add(list2);
        return mergeList;
    }
    /*
    Find Duplicate Value Interger
     */
    public static boolean findDuplicateValue(List<Integer> list){
        for (int i = 0; i < list.size(); i++){
            if(Collections.frequency(list, list.get(i) )> 1){
                System.out.println("This value is Duplicated" + list.get(i));
                return false;
            }
        }
        return true;
    }
}
