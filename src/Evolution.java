/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john
 */
public class Evolution {
    public static void main(String [] argv){
        Environment entorno = new Environment();
        
        while(!entorno.gotConvergence2()){
            StaticCounter.incrementCount();
            System.out.println("xoxoxoxoxoxoxoxoxoxoxoxoxoxoxo");
            entorno.breed();
            entorno.killCreatures();
            entorno.showCreatures();
        }
        System.out.println("Yipes! Got convergence in " + StaticCounter.getCount() + " iterations");
        entorno.showCreatures();
    }
}
