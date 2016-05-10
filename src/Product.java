import java.util.ArrayList;

/**
 * Created by Jonathan Correia de Barros on 10/05/16.
 *
 * Application of Extract Superclass in order to fix the Code Smell: Duplicated Code.
 * This Code Smell has been found on the classes: Pastry, Bagel and Coffee where they have identical properties.
 */
public abstract class Product {

    protected ArrayList<String> string;
    protected ArrayList<Integer> price;

    Product()
    {
        string = new ArrayList<String>();
        price = new ArrayList<Integer>();
    }

    public void clear()
    {
        string.clear();
        price.clear();
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
