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
    private List <Bloc> liste = new ArrayList<Bloc>();
    
    public List<Bloc> getListe() {
        return liste;
    }
    
    public Bloc getBloc(int i){
        return this.liste.get(i);
    }
    
}
