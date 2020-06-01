package Ultility;

import data.Product;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class ReadProductdata {
    JSONObject jsonObject, product;
    public ReadProductdata(){
        File file = new File(System.getProperty("user.dir")+"/src/test/data/product.json");
        try {
            product = new JSONObject(FileUtils.readFileToString(file,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Product getProduct(String id){
        jsonObject= (JSONObject) product.get(id);
        return new Product(jsonObject.getString("url"),
                jsonObject.getString("name"),
                jsonObject.getString("size"),
                jsonObject.getString("color"),
                jsonObject.getString("price"));
    }
}
