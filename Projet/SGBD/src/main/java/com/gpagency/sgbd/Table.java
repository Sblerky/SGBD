/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.sgbd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Jules
 */
public class Table {
    
    private List <Enregistrement> liste = new ArrayList<Enregistrement>();

    public List<Enregistrement> getListe() {
        return liste;
    }

    public Table(){
        int i=0;
        for(i=0; i<10000; i++){
            this.liste.add(new Enregistrement(i));
        }
    }
    
}
