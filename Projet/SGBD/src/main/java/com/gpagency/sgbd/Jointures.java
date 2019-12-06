/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.sgbd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jules
 */
public class Jointures {
    
    public static void sortMerge(Segment s1, Segment s2, Buffer b, ArrayList<Resultat> liste){
        List <Bloc> lb1 = s1.getListe();
        List <Bloc> lb2 = s2.getListe();
        
        int indice_bloc1 = 0;
        int indice_bloc2 = 0;
        
        int pos1=0;
        int pos2=0;
        
        b.getListe().add(s1.getBloc(pos1));
        b.getListe().add(s2.getBloc(pos2));
        
        while (pos1 <= s1.getListe().size()*s1.getBloc(0).getListe().size()-1 && pos2 <= s2.getListe().size()*s2.getBloc(0).getListe().size()-1){
            //si même valeur
            Enregistrement enr1 = s1.getBloc(pos1/10).getEnr(pos1%10);
            Enregistrement enr2 = s2.getBloc(pos2/10).getEnr(pos2%10);
            
            int val1=s1.getBloc(pos1/10).getEnr(pos1%10).getValeur();
            int val2=s2.getBloc(pos2/10).getEnr(pos2%10).getValeur();
            
            if(val1 == val2){
                //on ajoute le couple a la liste resultat
                Resultat r = new Resultat(enr1, enr2);
                liste.add(r);
                int stock = pos2/10;
                pos2++;
                if(pos2/10>stock/10){
                    b.getListe().add(s2.getBloc(stock));
                }
            }
            else if(val1 > val2){
                int stock = pos2/10;
                pos2++;
                if(pos2/10>stock/10){
                    b.getListe().add(s2.getBloc(stock));
                };
            }
            else{
                int stock = pos1/10;
                pos1++;
                if(pos1/10>stock/10){
                    b.getListe().add(s1.getBloc(stock));
                }
            }
        }
         
    }
    
}
