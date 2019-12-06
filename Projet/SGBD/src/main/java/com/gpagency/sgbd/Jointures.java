/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.sgbd;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jules
 */
public class Jointures {
    
    public static void sortMerge(Table t1, Table t2, Buffer b, ArrayList<Resultat> liste){
        Collections.sort(t1.getListe());
        Collections.sort(t2.getListe());
        
        int pos1=0;
        int pos2=0;
        
        while (pos1 <= t1.getListe().size()-1 && pos2 <= t2.getListe().size()-1){
            //si même valeur
            if(t1.getEnr(pos1).getValeur() == t2.getEnr(pos2).getValeur()){
                //on ajoute le couple a la liste resultat
                Resultat r = new Resultat(t1.getEnr(pos1), t2.getEnr(pos2));
                liste.add(r);
                pos2++;
            }
            else if(t1.getEnr(pos1).getValeur() > t2.getEnr(pos2).getValeur()){
                pos2++;
            }
            else{
                pos1++;
            }
        }
         
    }
    
}
