/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.sgbd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jules
 */
public class Index {
    
    private List <Integer> liste = new ArrayList<Integer>();

    public List<Integer> getListe() {
        return liste;
    }
    
    public Integer getEnr(int i){
        return this.liste.get(i);
    }
    
    public Index(Table t){
        Iterator<Enregistrement> iter = t.getListe().iterator();
        while (iter.hasNext()) {
            Enregistrement element = iter.next();
            int valeur = element.getValeur();
            this.liste.add(valeur);
        } 
    }
    
}
