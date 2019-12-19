package com.pmateus.entities;

import static com.pmateus.utils.Settings.FILE_SALE_ITEM_DATA_SEPARATOR;

import com.pmateus.exceptions.SaleItemException;
import java.math.BigDecimal;

/**
 *
 * @author Paulo Mateus
 */
public class SaleItem {

    private int itemId;
    private double itemQuantity;
    private BigDecimal itemPrice;

    public SaleItem(String itemId, String itemQuantity, String itemPrice) throws SaleItemException {
        this.itemId = Integer.parseInt(itemId);
        this.itemQuantity = Integer.parseInt(itemQuantity);
        this.itemPrice = new BigDecimal(itemPrice);
    }

    public SaleItem(int itemId, int itemQuantity, BigDecimal itemPrice) throws SaleItemException {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getItemId());
        sb.append(FILE_SALE_ITEM_DATA_SEPARATOR);
        sb.append(getItemQuantity());
        sb.append(FILE_SALE_ITEM_DATA_SEPARATOR);
        sb.append(getItemPrice().toString());

        return sb.toString();
    }

    public static SaleItem parse(String item) throws SaleItemException {

        String[] data = item.split(FILE_SALE_ITEM_DATA_SEPARATOR);
        SaleItem saleItem = new SaleItem(data[0], data[1], data[2]);

        return saleItem;
    }

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the itemQuantity
     */
    public double getItemQuantity() {
        return itemQuantity;
    }

    /**
     * @param itemQuantity the itemQuantity to set
     */
    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * @return the itemPrice
     */
    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

}
