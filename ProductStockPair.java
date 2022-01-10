//Malak Saifelnasr 101142247
//Dana El Sherif 101148722

package mystore;

/**
 * this class represents a ProductStockPair
 */
public class ProductStockPair {

    public final Product product;
    public final int stock;

    /**
     * this is the class constructor
     * @param product Product object
     * @param stock quanity of the given product
     */
    public ProductStockPair(Product product, int stock) {
        this.product = product;
        this.stock = stock;
    }
}