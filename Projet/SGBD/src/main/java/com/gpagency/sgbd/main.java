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
public class main {
    public static void main(String args[]){
        System.out.println("C'est parti");
        Table test_table = new Table();
        Table test_table2 = new Table();
        Buffer test_b = new Buffer();
        ArrayList<Resultat> res = new ArrayList<Resultat>();
        
        Segment test_seg = new Segment(test_table);
        Index test_ind = new Index(test_table);
        Segment test_segind = new Segment(test_ind);
        
        //Tests
        Jointures.sortMerge(test_table, test_table2, test_b, res);
        
        int i=0;
        
        for(i=0; i<res.size(); i++){
            res.get(i).getE1().toString();
            res.get(i).getE2().toString();
            System.out.println("\n\n");
        }
    }
    
}
