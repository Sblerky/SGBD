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
        
        int i=0;
        for(i=0; i<100;i++){
            String test=test_table.getListe().get(i).toString();
        }
        
    }
    
}
