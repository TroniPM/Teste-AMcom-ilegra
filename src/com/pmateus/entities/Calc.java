/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.entities;

import static com.pmateus.utils.Settings.FILE_LINE_BREAKER;

import com.pmateus.data.Repository;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Paulo Mateus
 */
public class Calc {

    public int clients = -1;
    public int sellers = -1;
    public int idMostExpensiveSale = -1;
    public String worstSeller = "";//Usarei o conceito de vendedor com menos dinheiro arrecadado.

    public static Calc calculate(Repository repository) {
        Calc calc = new Calc();
        calc.clients = repository.getClients().size();
        calc.sellers = repository.getSellers().size();

        BigDecimal best = BigDecimal.ZERO;
        for (Sale sale : repository.getSales()) {
            for (SaleItem item : sale.getItens()) {
                if (best.compareTo(item.getItemPrice()) == -1) {
                    best = item.getItemPrice();
                    calc.idMostExpensiveSale = item.getItemId();
                }
            }
        }

        HashMap<String, BigDecimal> hash = new HashMap<>();

        //Somando todos os valores por vendedor
        for (Seller seller : repository.getSellers()) {
            if (!hash.containsKey(seller.getName())) {
                hash.put(seller.getName(), BigDecimal.ZERO);
            }

            for (Sale sale : repository.getSales()) {

                if (seller.getName().equals(sale.getSeller())) {
                    BigDecimal value = hash.get(seller.getName());
                    value = value == null ? BigDecimal.ZERO : value;
                    BigDecimal total = value.add(calculateItensSum(sale.getItens()));
                    hash.put(seller.getName(), total);
                }
            }
        }

        String name = "";
        best = null;
        for (Map.Entry<String, BigDecimal> in : hash.entrySet()) {
            if (best == null) {
                best = in.getValue();
                name = in.getKey();
            }

            int rs = best.compareTo(in.getValue());
            if (rs == 1) {
                best = in.getValue();
                name = in.getKey();
            }
        }

        calc.worstSeller = name;

        return calc;
    }

    public static BigDecimal calculateItensSum(List<SaleItem> itens) {
        BigDecimal total = BigDecimal.ZERO;

        for (SaleItem saleItem : itens) {
            total = total.add(saleItem.getItemPrice());
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quantidade de clientes no arquivo de entrada: ");
        sb.append(clients);
        sb.append(FILE_LINE_BREAKER);

        sb.append("Quantidade de vendedor no arquivo de entrada: ");
        sb.append(sellers);
        sb.append(FILE_LINE_BREAKER);

        sb.append("ID da venda mais cara: ");
        sb.append(idMostExpensiveSale);
        sb.append(FILE_LINE_BREAKER);

        sb.append("O pior vendedor: ");
        sb.append(worstSeller);

        return sb.toString();
    }

}
