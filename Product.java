//Malak Saifelnasr 101142247
//Dana El Sherif 101148722

package mystore;

/**
 * this class represents a product object
 * @author Dana and Malak
 * @version 5.0
 */
public class Product {
    public final double price;
    public final String name;
    public final int id;

    /**
     * this is the product constructor
     * @param price
     * @param name
     * @param id
     */
    public Product(double price, String name, int id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }
}
