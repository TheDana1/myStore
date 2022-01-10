//Malak Saifelnasr 101142247
//Dana El Sherif 101148722

package mystore;

import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a storemanager
 * @author Dana and Malak
 * @version 5.0
 */
public class StoreManager {
    private final Inventory storeInventory = new Inventory();
    private final ArrayList<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
    private int shoppingCartCounter = 0;

    /**
     * this method gets the product quantity of product given a product
     * @param p product object
     * @return an int of the quantity
     */
    public int getProductStock(Product p) {
        return storeInventory.getProductQuantity(p);
    }

    /**
     * this method creates a new shoppingCart and gives it an id
     * @return an int of the id
     */
    public int assignNewCartID() {
        int id = shoppingCartCounter++;
        shoppingCarts.add(new ShoppingCart(id));
        return id;
    }

    /**
     * this method adds an item to a cart
     * @param cartID an int representing the cart the item will be added to
     * @param p product object that will be added
     * @param amount an int of the quantity of the product to be added
     * @return a boolean, true if the item was added
     */
    public boolean addToCart(int cartID, Product p, int amount) {
        if (storeInventory.removeProductQuantity(p, amount)) {
            for (ShoppingCart cart : shoppingCarts) {
                if (cart.getCartID() == cartID) {
                    cart.addProductQuantity(p, amount);
                    return true;
                }
            }
            storeInventory.addProductQuantity(p, amount);
        }
        return false;
    }

    /**
     * this method removes the product from the cart
     * @param cartID an int of the cartID
     * @param p a product object to be added
     * @param amount an int representing the quantity of product to be removed
     * @return a boolean, true if the product has been removed
     */
    public boolean removeFromCart(int cartID, Product p, int amount) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                if (cart.removeProductQuantity(p, amount)) {
                    storeInventory.addProductQuantity(p, amount);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * this method returns a list of the products in the inventory
     * @return an arrayList of the product
     */
    public ArrayList<ProductStockPair> getAvailableProducts() {
        return storeInventory.getProducts();
    }

    /**
     * this method returns a list of the items in the cart
     * @param cartID an int of the id
     * @return an arrayList of contents
     */
    public ArrayList<ProductStockPair> getCartContents(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                ArrayList<ProductStockPair> contents = new ArrayList<>(cart.getProducts());
                // filtering out 0 stocks; unique to viewing cart contents
                contents.removeIf(productStockPair -> productStockPair.stock < 1);
                return contents;
            }
        }
        return null; // just give an empty ArrayList if not found
    }

    /**
     * this method clears the contents of the cart and returns them to the inventory
     * @param cartID an int of the cart id
     */
    public void clearCartContents(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                List<ProductStockPair> stuffToPutBack = cart.getProducts();
                for (ProductStockPair pair : stuffToPutBack) {
                    storeInventory.addProductQuantity(pair.product, pair.stock);
                }
                // delete cart from shoppingCarts
                shoppingCarts.remove(cart);
                return;
            }
        }
    }

    /**
     * this method returns the total cost for a given cartID
     * @param cartID an int of the id
     * @return a double of the cost, -1 if the cartID is not found
     */
    public double getCartTotal(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                return cart.getTotal();
            }
        }
        return -1.0;
    }

    /**
     * this method returns the number of products in the inventory
     * @return an int of the number of products
     */
    public int getNumOfProducts() {
        return storeInventory.getNumOfProducts();
    }

    /**
     * this method checks what
     * @param cartID
     * @param p
     * @return
     */
    public boolean isInCart(int cartID, Product p) {
        for (ShoppingCart sC : shoppingCarts) {
            if (sC.getCartID() == cartID) {
                return sC.getProductQuantity(p) > 0;
            }
        }
        return false;
    }
}

