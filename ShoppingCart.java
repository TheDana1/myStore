//Malak Saifelnasr 101142247
//Dana El Sherif 101148722

package mystore;

/**
 * This class represents a shoppingCart
 * @author Dana and Malak
 * @version 5.0
 */
public class ShoppingCart extends ProductStockContainer{

    private final int cartID;
    private double total = 0.0;

    public ShoppingCart(int cartID) {
        this.cartID = cartID;
    }

    /**
     * this method adds quantity of a product from the shoppingCart
     * @param p the product to be added
     * @param q the number of products to be added
     */
    @Override
    public void addProductQuantity(Product p, int q) {
        super.addProductQuantity(p,q);
        total += p.price * q;

    }

    /**
     * this method removes a quantity of product from the shopping cart
     * @param p the product type object to be added
     * @param q an int of the amount of product to be removed
     * @return
     */
    @Override
    public boolean removeProductQuantity(Product p, int q) {
        for (int i = 0; i < super.getProducts().size(); i++) {
            ProductStockPair pair = super.getProducts().get(i);
            if (pair.product.id == p.id) {
                if (pair.stock >= q) {
                    super.getProducts().set(i, new ProductStockPair(pair.product, pair.stock - q));
                    total -= p.price * q;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * this method returns the total of the shopping cart
     * @return a double of the total cost
     */
    public double getTotal() {
        return total;
    }

    /**
     * this method returns the cartID
     * @return an int of the cartID
     */
    public int getCartID() { return cartID; }
}

