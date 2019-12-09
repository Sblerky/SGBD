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
        
        //Collections.sort(test_table.getListe());
        //Collections.sort(test_table2.getListe());
        
        Segment test_seg = new Segment(test_table);
        Segment test_seg2 = new Segment(test_table2);
        
        Index i_test = new Index(test_table);
        Index i_test2 = new Index(test_table2);
        
        Collections.sort(i_test.getListe());
        Collections.sort(i_test2.getListe());
        
        Segment test_iseg = new Segment(i_test);
        Segment test_iseg2 = new Segment(i_test2);
        
        
        //Tests
        //Jointures.sortMerge(test_seg, test_seg2, test_b, res);
        //Jointures.keyLookup(test_seg, test_iseg, test_b, res);
        //Jointures.cartesian(test_seg, test_seg2, test_b, res);
        //Jointures.omiecinski(test_iseg, test_iseg2, test_b, res);
        Jointures.hash(test_seg, test_seg2, test_b, res);
        
        int i=0;
        
        for(i=0; i<res.size(); i++){
            res.get(i).getE1().toString();
            res.get(i).getE2().toString();
            System.out.println("\n\n");
        }
        
        System.out.println(test_b.getListe().size());
    }
    
}
