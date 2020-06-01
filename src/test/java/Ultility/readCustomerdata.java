package Ultility;

import data.Product;
import data.customerInfor;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class readCustomerdata {
    JSONObject jsonObject, customer;
    public readCustomerdata(){
        File file = new File(System.getProperty("user.dir")+"/src/test/data/customer.json");
        try {
            customer = new JSONObject(FileUtils.readFileToString(file,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public customerInfor getCustomer(String id){
        jsonObject= (JSONObject) customer.get(id);
        return new customerInfor(jsonObject.getString("firstname"),
                jsonObject.getString("lastname"),
                jsonObject.getString("email"),
                jsonObject.getString("stress_address"),
                jsonObject.getString("city"),
                jsonObject.getString("state"),
                jsonObject.getString("country"),
                jsonObject.getString("zip_code"),
                jsonObject.getString("phone_number")
        );
    }
}
