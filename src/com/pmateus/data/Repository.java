/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.data;

import com.pmateus.entities.Calc;
import com.pmateus.entities.Client;
import com.pmateus.entities.Sale;
import com.pmateus.entities.Seller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Mateus
 */
public class Repository {

    private List<Client> clients = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();
    private List<Seller> sellers = new ArrayList<>();
    private File file;
    private Calc calc;

    public void reset() {
        clients = new ArrayList<>();
        sales = new ArrayList<>();
        sellers = new ArrayList<>();
    }

    public void addClient(Client c) {
        if (clients == null) {
            clients = new ArrayList<>();
        }
        clients.add(c);
    }

    public void addSale(Sale sa) {
        if (sales == null) {
            sales = new ArrayList<>();
        }
        sales.add(sa);
    }

    public void addSeller(Seller se) {
        if (sellers == null) {
            sellers = new ArrayList<>();
        }
        sellers.add(se);
    }

    /**
     * @return the clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return the sales
     */
    public List<Sale> getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    /**
     * @return the sellers
     */
    public List<Seller> getSellers() {
        return sellers;
    }

    /**
     * @param sellers the sellers to set
     */
    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Calc getCalc() {
        return calc;
    }

    public void setCalc(Calc calc) {
        this.calc = calc;
    }
}
