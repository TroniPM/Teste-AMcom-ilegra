/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmateus.exceptions;

/**
 *
 * @author Paulo Mateus
 */
public class ClientException extends Exception {

    public ClientException(String errorMessage) {
        super(errorMessage);
    }
}
