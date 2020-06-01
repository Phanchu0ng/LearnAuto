package data;
import java.util.List;
public class Calculation {

    public  Calculation() {
    }
        public static float getSubTotal(List<Product> list){
            float subTotal = 0;
            for (Product product: list) {
                Float price  = Float.parseFloat(product.getPrice().replace("US$", "").replace(",","."));

                subTotal+= price;
            }

            return subTotal;
        }
    }
