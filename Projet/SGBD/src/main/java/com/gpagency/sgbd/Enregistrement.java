/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gpagency.sgbd;

import java.nio.charset.Charset;
import java.util.Random;

/**
 *
 * @author Jules
 */
public class Enregistrement {
    private int id;
    private String desc;
    private int valeur;

    public String getDesc() {
        return desc;
    }

    public int getValeur() {
        return valeur;
    }

    public int getId() {
        return id;
    }

    
    public Enregistrement(int p_id){
        this.id=p_id;
        
        this.valeur = 1 + (int)(Math.random() * 9999);
        
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        this.desc = new String(array, Charset.forName("UTF-8"));
    }
    
    @Override
    public String toString(){
        String res = ""+this.id+"\nValeur : "+this.valeur+"\nDescription : "+this.desc;
        System.out.println(res);
        return res;
    }
    
}
