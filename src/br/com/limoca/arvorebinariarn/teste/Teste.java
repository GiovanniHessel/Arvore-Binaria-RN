/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.limoca.arvorebinariarn.teste;

import br.com.limoca.arvorebinariarn.arvorern.ArvoreRN;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Giovanni
 */
public class Teste {

    public static void main(String[] args) {
        ArvoreRN rn = new ArvoreRN();
        Random rnd = new Random();
        ArrayList num = new ArrayList();
        ///*
        
        
         for (int i = 0; i <= 6; i++) {
         //num.add();
         int x = rnd.nextInt(100) + 1;
         rn.insere(x);
         System.out.println("Dado : " + x + " inserido com sucesso");

         }
         //*/
        /*
        rn.insere(1);
        rn.insere(2);
        rn.insere(3);
        rn.insere(4);
        rn.insere(5);
        rn.insere(11);
         rn.insere(10);
         rn.insere(9);
         rn.insere(8);
         rn.insere(7);
         */
         //rn.preOrdem();
         //rn.remove(rn.getRaiz());
         //rn.remove(rnd.nextInt(100) + 1);
         //rn.preOrdem();
         
        System.out.print("Em Ordem : ");
        rn.emOrdem();
        System.out.print("Pre Ordem : ");
        rn.preOrdem();
        System.out.print("Pos Ordem : ");
        rn.posOrdem();
        System.out.print("Em Nivel : ");
        rn.emNivel();
        /*
       
         System.out.println("Dado " + rn.buscarDado(2));

         if (rn.remove(3)) {
         System.out.println("Dado removido");
         } else {
         System.out.println("Dado não removido");
         }
        
         System.out.println("Tamanho " + rn.size());
         }
         */
    }
}
