/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.limoca.arvorebinariarn.arvorern;

enum Cor{preto, vermelho};

public class No {
    
    No esq, dir, pai;
    int  dado;
    Cor cor;
    Object objeto;
    
    public No(){
         dado = 0;
    }
    public No(int dado){
        this.dado = dado; 
    }
    public No(int dado, Object objeto){
        this.dado = dado;
        this.objeto = objeto;
    }
}
