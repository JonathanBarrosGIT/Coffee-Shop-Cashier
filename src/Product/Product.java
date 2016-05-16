package Product;

/**
 * By Jonathan Correia de Barros on 14/05/16.
 *
 * Application of 'Replace Data Value with Object' in order to fix the Code Smell: Primitive Obsession.
 * This Code Smell has been found on the classes: Pastry, Bagel and Coffee where they have identical method and they
 * rely too much on string type.
 */

public class Product {

    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
