import Product.Bagel.*;
import Product.Coffee.*;
import Product.Pastry.*;
import Product.Product;

import java.util.ArrayList;

/**
 * By Jonathan Correia de Barros on 10/05/16.
 *
 * Application of - Extract Superclass - in order to fix the Code Smell: Duplicated Code.
 * This Code Smell has been found on the classes: Pastry, Bagel and Coffee where they have identical properties.
 */
public abstract class Products {

    protected ArrayList<String> string = new ArrayList<>();
    protected ArrayList<Integer> price = new ArrayList<>();

    protected ArrayList<Product> productList = new ArrayList<>();

    private Extra extra = new Extra();

    Products()
    {
        productList.add(new White());
        productList.add(new LoxTopping());
        productList.add(new Extra());
        productList.add(new NovaLoxTopping());
        productList.add(new Popy());
        productList.add(new Salt());
        productList.add(new Seseme());
        productList.add(new Wheat());

        productList.add(new ExtraCream());
        productList.add(new ExtraSugar());
        productList.add(new Large());
        productList.add(new Small());
        productList.add(new Medium());

        productList.add(new ApricotDanish());
        productList.add(new Crossant());
        productList.add(new BlueberryMuffin());
        productList.add(new EnglishMuffin());
        productList.add(new PruneDanish());
    }

    public void clear()
    {
        string.clear();
        price.clear();
    }

    public void pricing(){
        for(int x = 0; x < string.size(); x++){
            for (Product product : productList){
                if(string.get(x).startsWith(product.getName())){
                    price.add(product.getPrice());
                }else if(string.get(x).endsWith(extra.getName())){
                    price.add(50);
                }
            }
        }
    }

    public ArrayList<String> getString() {
        return string;
    }
    public void setString(ArrayList<String> string) {
        this.string = string;
    }
    public ArrayList<Integer> getPrice() {
        return price;
    }
    public void setPrice(ArrayList<Integer> price) {
        this.price = price;
    }
}
