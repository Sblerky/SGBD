/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.sgbd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jules
 */
public class Bloc {
    private List <Enregistrement> liste = new ArrayList<Enregistrement>();
    

    public List<Enregistrement> getListe() {
        return liste;
    }
    public Enregistrement getEnr(int i){
        return this.liste.get(i);
    }
    
    public Bloc(List <Enregistrement> p_liste){
        this.liste=p_liste;
    }
    
}
