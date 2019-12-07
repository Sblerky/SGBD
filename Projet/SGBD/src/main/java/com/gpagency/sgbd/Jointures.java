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
        
        int pos1=0;
        int pos2=0;
        
        int stock1=0;
        int stock2=0;
        
        //on boucle jusqu'a comparer toutes les valeurs
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
                stock2 = pos2/10;
                pos2++;
                if(pos2/10>stock2){
                    b.getListe().add(s2.getBloc(stock2));
                }
            }
            //sinon si 1>2, on incrémente 2
            else if(val1 > val2){
                stock2 = pos2/10;
                pos2++;
                if(pos2/10>stock2){
                    b.getListe().add(s2.getBloc(stock2));
                };
            }
            //sinon on incrémente 1
            else{
                stock1 = pos1/10;
                pos1++;
                if(pos1/10>stock1){
                    b.getListe().add(s1.getBloc(stock1));
                }
            }
        }
        
        if(pos1/10>stock1){
                    b.getListe().add(s1.getBloc((pos1-1)/10));
        }
        if(pos2/10>stock2){
                    b.getListe().add(s2.getBloc((pos2-1)/10));
        }
         
    }
    
    public static void keyLookup(Segment s1, Segment s2, Buffer b, ArrayList<Resultat> liste){
        int i=0;
        int j=0;
        int stock=0;
        
        int stockj = 0;
        
        //juste deux boucles imbriquées pour comparer les tuples
        for(i=0; i<s1.getListe().size()*s1.getBloc(0).getListe().size(); i++){
            Enregistrement enr1 = s1.getBloc(i/10).getEnr(i%10);
            int val1=s1.getBloc(i/10).getEnr(i%10).getValeur();
            if(i/10>stock){
                    b.getListe().add(s1.getBloc(stock));
                }
            
            for(j=0; j<s2.getListe().size()*s2.getBloc(0).getListe().size(); j++){
                
                if(j/10>stockj){
                    b.getListe().add(s2.getBloc(stockj));
                }
                
                Enregistrement enr2 = s2.getBloc(j/10).getEnr(j%10);
                int val2=s2.getBloc(j/10).getEnr(j%10).getValeur();
                if(val1 == val2){
                    Resultat r = new Resultat(enr1, enr2);
                    liste.add(r);
                }
                stockj=j/10;
            }
            
            stock = i/10;
        }
        
        if(i/10>stock){
                    b.getListe().add(s1.getBloc((i-1)/10));
        }
        if(j/10>stockj){
                    b.getListe().add(s2.getBloc((j-1)/10));
        }
    }
    
    public static void cartesian(Segment s1, Segment s2, Buffer b, ArrayList<Resultat> liste){
        //Dans la fonction on charge 5 blocs de s1, et un bloc de s2 comme sur le schéma
        int i=0;
        int j=0;
        int k=0;
        int l=0;
        int capa = 5;
        int stock_k=0;
        int stock_l=0;
        
        List <Bloc> lb1 = new ArrayList<Bloc>();
        
        //On répète size/capa fois (ici 2)
        for(i=0; i<(s1.getListe().size())/capa; i++){
            
            //on charge les blocs à lire de r1
            lb1.clear();
            for(j=0; j<capa; j++){
                lb1.add(s1.getBloc(i*5+j));
            }
            
            //on parcours tous les blocs de r2 pour les comparer avec les 5 blocs
            for(k=0; k<s2.getListe().size()*s2.getBloc(0).getListe().size(); k++){
                if(k/10>stock_k){
                    b.getListe().add(s2.getBloc(stock_k));
                }
                
                //valeur de r2 actuelle 
                Enregistrement enr2 = s2.getBloc(k/10).getEnr(k%10);
                int val2=s2.getBloc(k/10).getEnr(k%10).getValeur();
                
                for(l=0; l<lb1.size()*lb1.get(0).getListe().size(); l++){
                    if(l/10>stock_l){
                        b.getListe().add(lb1.get(stock_l));
                    }
                    
                    //c'est des L et des un, attention de pas confondre 
                    Enregistrement enr1 = lb1.get(l/10).getEnr(l%10);
                    int val1=lb1.get(l/10).getEnr(l%10).getValeur();
          
                    if(val1 == val2){
                        Resultat r = new Resultat(enr1, enr2);
                        liste.add(r);
                    }
                    
                    stock_l=l/10;
                }
                
                stock_k=k/10;
            }
            
        }
        
        if(k/10>stock_k){
                    b.getListe().add(s1.getBloc((k-1)/10));
        }
        if(l/10>stock_l){
                    b.getListe().add(lb1.get((l-1)/10));
        }
    }
    
    
}
