package com.pmateus.entities;

import static com.pmateus.utils.Settings.FILE_DATA_SEPARATOR;
import static com.pmateus.utils.Settings.FILE_SALE_ITEM_SEPARATOR;
import static com.pmateus.utils.Settings.FILE_SALE_ITEM_DATA_INI;
import static com.pmateus.utils.Settings.FILE_SALE_ITEM_DATA_END;

import com.pmateus.exceptions.SaleException;
import com.pmateus.exceptions.SaleItemException;
import java.util.ArrayList;

/**
 *
 * @author Paulo Mateus
 */
public class Sale {

    private String id;
    private String saleId;
    private String seller;
    private ArrayList<SaleItem> itens;

    public Sale(String id, String saleId, String seller) {
        this.id = id;
        this.saleId = saleId;
        this.seller = seller;
    }

    public static Sale parser(String line) throws SaleException {
        /*
            003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
         */
        String lineAux = line.split(FILE_SALE_ITEM_DATA_INI)[0];
        lineAux = lineAux + line.split(FILE_SALE_ITEM_DATA_END)[1].substring(1);
        String[] data = lineAux.split(FILE_DATA_SEPARATOR);

        Sale sale = new Sale(data[0], data[1], data[2]);

        lineAux = line.split(FILE_SALE_ITEM_DATA_INI)[1];
        lineAux = lineAux.split(FILE_SALE_ITEM_DATA_END)[0];
        data = lineAux.split(FILE_SALE_ITEM_SEPARATOR);
        for (String in : data) {
            try {
                SaleItem saleItem = SaleItem.parse(in);
                sale.addItem(saleItem);
            } catch (SaleItemException ex) {
                ex.printStackTrace();
            }
        }

        return sale;
    }

    /**
     * @param item the SaleItem to add
     */
    public void addItem(SaleItem item) {
        if (getItens() == null) {
            setItens(new ArrayList<>());
        }

        getItens().add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(getSaleId());
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(FILE_SALE_ITEM_DATA_INI.replace("\\", ""));
        if (getItens() != null) {
            for (SaleItem in : getItens()) {
                sb.append(in.toString());
                sb.append(FILE_SALE_ITEM_SEPARATOR);
            }
            sb.setLength(sb.length() - 1);
        }
        sb.append(FILE_SALE_ITEM_DATA_END.replace("\\", ""));
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(getSeller());

        return sb.toString();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the saleId
     */
    public String getSaleId() {
        return saleId;
    }

    /**
     * @param saleId the saleId to set
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    /**
     * @return the seller
     */
    public String getSeller() {
        return seller;
    }

    /**
     * @param seller the seller to set
     */
    public void setSeller(String seller) {
        this.seller = seller;
    }

    /**
     * @return the itens
     */
    public ArrayList<SaleItem> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(ArrayList<SaleItem> itens) {
        this.itens = itens;
    }

}
