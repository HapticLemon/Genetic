/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author john
 */
public class Creature implements Comparable<Creature>{
    private boolean genes[] = new boolean[6];
    private int id;
    
    Creature(int id){
        this.id = id;
        
        for(int i = 0; i< genes.length; i++){
            double x = Math.random();
            if (x<= 0.3){
                genes[i] = true;
            }else{
                genes[i] = false;
            }
        }
    }
    
    Creature(int id, boolean[] genes){
        this.id = id;
        this.genes = genes.clone();
    }
    
    public boolean[] getGenes(){
        return this.genes;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void computeMutation(){
        boolean intermedia;
        
        for(int i = 0; i < 3; i++){
            if(Math.random() <= 0.1){
                intermedia = genes[i];
                genes[i] = genes[i+1];
                genes[i+1] = intermedia;
                break;
            }
        }
    }
    
    public void flipGene(){
        Random r = new Random();
        int Low = 0;
        int High = 6;
        int position = r.nextInt(High-Low) + Low;
        
        if(Math.random() <= 0.1){
            this.genes[position] = !this.genes[position];
        }
    }
    
    public int computeFitness(){
        int fitness = 0;
        
        for(int i = 0; i < genes.length; i++){
            if (genes[i] ){
                fitness++;
            }
        }
        return (fitness);
    }
    
    public String toString(){
        String salida = "";
        for(int i = 0; i< genes.length; i++){
            if (genes[i]){
                salida = salida + "1";
            }else{
                salida = salida + "0";
            }
        }
        return salida;
    }
    

    // Está montado deprisa y corriendo; habría que añadir
    // un campo fitness para no tener que calcular al vuelo.
    @Override
    public int compareTo(Creature compareCritter) {
        int fitness=((Creature)compareCritter).computeFitness();
        /* For Ascending order*/
        return this.computeFitness()-fitness;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }
}
