/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.sgbd;

/**
 *
 * @author Jules
 */
public class main {
    public static void main(String args[]){
        System.out.println("C'est parti");
        Table test_table = new Table();
        Segment test_seg = new Segment(test_table);
        Index test_ind = new Index(test_table);
        Segment test_segind = new Segment(test_ind);
        
        //Tests
        /*
        int i=1;
        String test=test_seg.getBloc(i).getEnr(0).toString();
        test=test_seg.getBloc(i).getEnr(9).toString();
        System.out.println("_____________________");
        test=test_table.getEnr(i*10+0).toString();
        test=test_table.getEnr(i*10+9).toString();
        */
        int i=1;
        String test=test_segind.getBloc(i).getEnr(0).toString();
        test=test_segind.getBloc(i).getEnr(9).toString();
        System.out.println("_____________________");
        System.out.println(test_ind.getEnr(i*10+0));
        System.out.println(test_ind.getEnr(i*10+9));
        
    }
    
}
