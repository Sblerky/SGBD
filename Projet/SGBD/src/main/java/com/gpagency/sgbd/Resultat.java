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
public class Resultat {
    private Enregistrement e1;
    private Enregistrement e2;

    public Enregistrement getE1() {
        return e1;
    }

    public Enregistrement getE2() {
        return e2;
    }
    
    public Resultat(Enregistrement en1, Enregistrement en2){
        this.e1=en1;
        this.e2=en2;
    }
    
    
}
