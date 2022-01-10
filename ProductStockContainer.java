//Malak Saifelnasr 101142247
//Dana El Sherif 101148722

package mystore;

import java.util.ArrayList;


/**
 * this is the abstract representation of product stock container objects
 */
public abstract class ProductStockContainer {
    private final ArrayList<ProductStockPair> products = new ArrayList<ProductStockPair>();
    private int numOfProducts = 0;

    /**
     * this method gets the quantity of a product
     * @param p the product object
     * @return an int of the quantity
     */
    public int getProductQuantity(Product p){
        for (ProductStockPair pair : products) {
            if (pair.product.id == p.id) {
                return pair.stock;
            }
        }
        return -1;
    }

    /**
     * this method checks that a product can be added and increases the numOfProducts count
     * @param p the Product object that will be added
     * @param q an int of the quantity to be added
     */
    public void addProductQuantity(Product p, int q){
        if (p.id < 0) return;

        for (int i = 0; i < products.size(); i++) {
            ProductStockPair pair = products.get(i);
            if (pair.product.id == p.id) {
                products.set(i, new ProductStockPair(p, pair.stock + q));
                return;
            }
        }
        products.add(new ProductStockPair(p, q));
        this.numOfProducts++;
    }

    /**
     * this is an abstract method that removes product from a list
     * @param p the product object
     * @param q an int of quantity to be removed
     * @return a boolean, true if removed
     */
    abstract boolean removeProductQuantity(Product p, int q);

    /**
     * this method gets the number of products
     * @return an int of the number of products
     */
    public int getNumOfProducts(){
        return this.numOfProducts;
    }

    /**
     * this method returns a list of the products
     * @return an ArrayList of the products
     */
    public ArrayList<ProductStockPair> getProducts() {
        return this.products;
    }

    /**
     * this method sets the number of products
     * @param numOfProducts an int
     */
    public void setNumOfProducts(int numOfProducts) {
        this.numOfProducts = numOfProducts;
    }
}
