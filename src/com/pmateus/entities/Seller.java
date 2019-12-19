/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.entities;

import static com.pmateus.utils.Settings.FILE_DATA_SEPARATOR;

import com.pmateus.exceptions.SellerException;
import java.math.BigDecimal;

/**
 *
 * @author Paulo Mateus
 */
public class Seller {

    private String id;
    private String cpf;
    private String name;
    private BigDecimal salary;

    public Seller(String id, String cpf, String name, String salary) throws SellerException {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.salary = new BigDecimal(salary);
    }

    public Seller(String id, String cpf, String name, BigDecimal salary) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(getCpf());
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(getName());
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(getSalary().toString());

        return sb.toString();
    }

    public static Seller parser(String line) throws SellerException {
        // 001çCPFçNameçSalary

        String[] data = line.split(FILE_DATA_SEPARATOR);
        Seller seller = new Seller(data[0], data[1], data[2], data[3]);

        return seller;
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
