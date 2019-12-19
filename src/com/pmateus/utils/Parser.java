/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.utils;

import static com.pmateus.utils.Settings.READ_PATH;
import static com.pmateus.utils.Settings.FILE_DATA_SELLER_ID;
import static com.pmateus.utils.Settings.FILE_DATA_CLIENT_ID;
import static com.pmateus.utils.Settings.FILE_DATA_SALE_ID;
import static com.pmateus.utils.Settings.FILE_EXTENSION;
import static com.pmateus.utils.Settings.FILE_OUTPUT_LABEL;

import com.pmateus.data.Repository;
import com.pmateus.entities.Client;
import com.pmateus.entities.Sale;
import com.pmateus.entities.Seller;
import com.pmateus.exceptions.ClientException;
import com.pmateus.exceptions.SaleException;
import com.pmateus.exceptions.SellerException;
import java.io.File;
import java.util.List;

/**
 *
 * @author Paulo Mateus
 */
public class Parser {

    public static void getFileNames(List<File> used, List<File> neew) throws Exception {
        File f = new File(READ_PATH);
        if (!f.exists()) {
            throw new Exception("Path invalid.");
        }

        UtilsIO.getFileNames(".*\\" + FILE_EXTENSION, f, used, neew);
//        if (neew == null || neew.isEmpty()) {;;
//            throw new Exception("Path(" + f.getAbsolutePath() + ") has no .dat files.");
//        }
    }

    public static Repository getDataFromFile(File in) {
        Repository rp = new Repository();
        String[] lines = UtilsIO.readFile(in);

        for (String line : lines) {
            if (line.startsWith(FILE_DATA_SELLER_ID)) {
                Seller seller;
                try {
                    seller = getSeller(line);
                    rp.addSeller(seller);
                } catch (SellerException ex) {
                    ex.printStackTrace();
                }
            } else if (line.startsWith(FILE_DATA_CLIENT_ID)) {
                Client client;
                try {
                    client = getClient(line);
                    rp.addClient(client);
                } catch (ClientException ex) {
                    ex.printStackTrace();
                }
            } else if (line.startsWith(FILE_DATA_SALE_ID)) {
                Sale sale;
                try {
                    sale = getSale(line);
                    rp.addSale(sale);
                } catch (SaleException ex) {
                    ex.printStackTrace();
                }
            }
        }

        rp.setFile(in);

        return rp;
    }

    private static Client getClient(String line) throws ClientException {
        return Client.parser(line);
    }

    private static Sale getSale(String line) throws SaleException {
        return Sale.parser(line);
    }

    private static Seller getSeller(String line) throws SellerException {
        return Seller.parser(line);
    }

    public static void generateOutput(Repository in) {
        String name = in.getFile().getName();
        name = name.substring(0, name.lastIndexOf('.')).concat(".").concat(FILE_OUTPUT_LABEL).concat(FILE_EXTENSION);
        String content = in.getCalc().toString();
        UtilsIO.writeFile(name, content, false);
    }
}
