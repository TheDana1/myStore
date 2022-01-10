//Malak Saifelnasr 101142247
//Dana El Sherif 101148722

package mystore;

/**
 * this class represents the inventory
 * @author Dana and Malak
 * @version 5.0
 */
public class Inventory extends ProductStockContainer {

    /**
     * this is the inventory constructor
     */
    public Inventory() {
        initialize();
    }

    /**
     * this method overrides the removeProductQuantity
     * @param p the product object
     * @param q an int of quantity to be removed
     * @return
     */
    @Override
    public boolean removeProductQuantity(Product p, int q) {
        for (int i = 0; i < super.getProducts().size(); i++) {
            ProductStockPair pair = super.getProducts().get(i);
            if (pair.product.id == p.id) {
                if (pair.stock >= q) {
                    super.getProducts().set(i, new ProductStockPair(pair.product, pair.stock - q));
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * this method adds product to the inventory
     */
    private void initialize() {

        super.addProductQuantity(new Product(1.25, "APPLE", 0), 7);
        super.addProductQuantity(new Product(2.50, "ORANGE", 1), 10);
        super.addProductQuantity(new Product(0.99, "GRAPE", 2), 32);
        super.addProductQuantity(new Product(5.50, "WATERMELON", 3), 3);
        super.addProductQuantity(new Product(0.10, "BANANA", 4), 12);
        super.addProductQuantity(new Product(6.70, "PINEAPPLE", 5), 13);
        super.addProductQuantity(new Product(10.00, "POMEGRANATE", 6), 2);
        super.addProductQuantity(new Product(4.65, "PLUM", 7), 7);
        super.addProductQuantity(new Product(1.99, "PEACH", 8), 10);
        super.addProductQuantity(new Product(7.90, "CANTALOUPE", 9), 14);
        super.addProductQuantity(new Product(0.80, "BLUEBERRY", 10), 6);
        super.addProductQuantity(new Product(5.80, "APRICOT", 11), 11);
        super.addProductQuantity(new Product(11.99, "CRANBERRY", 12), 23);
        super.addProductQuantity(new Product(0.45, "GUAVA", 13), 35);
        super.addProductQuantity(new Product(0.20, "PEAR", 14), 50);

    }

}
