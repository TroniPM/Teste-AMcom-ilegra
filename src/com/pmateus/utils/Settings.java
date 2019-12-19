/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.utils;

import java.io.File;

/**
 *
 * @author Paulo Mateus
 */
public class Settings {

    public static final String FILE_DATA_SELLER_ID = "001";
    public static final String FILE_DATA_CLIENT_ID = "002";
    public static final String FILE_DATA_SALE_ID = "003";

    public static final String FILE_EXTENSION = ".dat";
    public static final String FILE_OUTPUT_LABEL = "done";

    public static final String FILE_DATA_SEPARATOR = "ç";
    public static final String FILE_SALE_ITEM_DATA_SEPARATOR = "-";
    public static final String FILE_SALE_ITEM_SEPARATOR = ",";
    public static final String FILE_LINE_BREAKER = "\r\n";
    public static final String FILE_SALE_ITEM_DATA_INI = "\\[";
    public static final String FILE_SALE_ITEM_DATA_END = "]";

    public static final String READ_PATH = System.getProperty("user.home") + File.separator + "data" + File.separator + "in";
    public static final String WRITE_PATH = System.getProperty("user.home") + File.separator + "data" + File.separator + "out";

    public static final int WAIT_DELAY_SECONDS = 5;
}
