/**
 * An Item represents a food product. Each Item has an assigned name (strName),
 * a corresponding price (dPrice), its total calorie count (nCaloricValue), and 
 * the number of such items remaining in stock (nQuantity).
 */

package com.Item;

public class Item {
    private String strName;
    private double dPrice;
    private int nCaloricValue;
    private int nQuantity;

    /**
     * creates an Item object for dispensing purposes by assigning it a name, price,
     * caloric value, and the number of such items to be stocked.
     * @param strName item name
     * @param dPrice item price
     * @param nCaloricValue total number of calories for the item
     * @param nQuantity total number of items to stock
     */
    public Item (String strName, double dPrice, int nCaloricValue, int nQuantity) {
        this.strName = strName;
        this.dPrice = dPrice;
        this.nCaloricValue = nCaloricValue;
        this.nQuantity = nQuantity;
    }

    /**
     * creates an Item object for documentation purposes by assigning it a name, price,
     * and the number of such items that were stocked.
     * @param strName item name
     * @param dPrice item price
     * @param nQuantity total number of items stocked
     */
    public Item (String strName, double dPrice, int nQuantity) {
        this.strName = strName;
        this.dPrice = dPrice;
        this.nQuantity = nQuantity;
    }

    /**
     * returns the item name.
     */
    public String getName () {
        return this.strName;
    }

    /**
     * returns the item price.
     */
    public double getPrice () {
        return this.dPrice;
    }

    /**
     * returns the total number of calories for the item.
     */
    public int getCaloricValue () {
        return this.nCaloricValue;
    }

    /**
     * returns the number of remaining items in stock.
     */
    public int getQuantity () {
        return this.nQuantity;
    }

    /**
     * sets the item name to the given name.
     */
    public void setName (String strName) {
        this.strName = strName;
    }

    /**
     * sets the item price to the given amount.
     */
    public void setPrice (double dPrice) {
        this.dPrice = dPrice;
    }

    /**
     * sets the item quantity to the given count.
     */
    public void setQuantity (int nQuantity) {
        this.nQuantity = nQuantity;
    }
    
}