package com.pmateus.entities;

import static com.pmateus.utils.Settings.FILE_DATA_SEPARATOR;

import com.pmateus.exceptions.ClientException;

/**
 *
 * @author Paulo Mateus
 */
public class Client {

    private String id;
    private String cnpj;
    private String name;
    private String businessArea;

    public Client(String id, String cnpj, String name, String businessArea) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(getCnpj());
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(getName());
        sb.append(FILE_DATA_SEPARATOR);
        sb.append(getBusinessArea());

        return sb.toString();
    }

    public static Client parser(String line) throws ClientException {
        //002çCNPJçNameçBusiness Area

        String[] data = line.split(FILE_DATA_SEPARATOR);
        Client client = new Client(data[0], data[1], data[2], data[3]);

        return client;
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
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
     * @return the businessArea
     */
    public String getBusinessArea() {
        return businessArea;
    }

    /**
     * @param businessArea the businessArea to set
     */
    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

}
