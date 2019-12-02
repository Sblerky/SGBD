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
public class Segment {
    private List <Bloc> liste = new ArrayList<Bloc>();

    public List<Bloc> getListe() {
        return liste;
    }
    
    public Bloc getBloc(int i){
        return this.liste.get(i);
    }
    
    public Segment(Table t){
        int count = t.getListe().size();
        int i=0;
        int j=0;
        for (i=0; i<count; i=i+10){
            
            List <Enregistrement> li_enr = new ArrayList<Enregistrement>();
            for(j=0; j<10; j++){
                li_enr.add(t.getListe().get(i+j));
            }
            Bloc b = new Bloc(li_enr);
            this.liste.add(b);
        }
    }
    
    public Segment(Index in){
        int count = in.getListe().size();
        int i=0;
        int j=0;
        for (i=0; i<count; i=i+10){
            
            List <Enregistrement> li_enr = new ArrayList<Enregistrement>();
            for(j=0; j<10; j++){
                li_enr.add(new Enregistrement(i+j, in.getListe().get(i+j)));
            }
            Bloc b = new Bloc(li_enr);
            this.liste.add(b);
        }
    }
}
