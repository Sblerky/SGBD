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

public class Buffer {
    private List <Bloc> liste;

//Je sais pas encore si il faudra implémenter le compteur pour le coùt dans cette classe ou bien dans celle des jointures

    public List<Bloc> getListe() {
        return liste;
    }


    public Bloc getBlocL1(int i){
        return this.liste.get(i);
    }


    public Buffer(List <Bloc> l1){
        this.liste= l1;
    }
    
    public Buffer(){
        this.liste= new ArrayList<Bloc>();
    }


}
