/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
        
/**
 *
 * @author john
 */
public class Environment {
    
    private static ArrayList<Creature> creatureList = new ArrayList<Creature>();
    private static final char MAXCREATURES = 10;
    private int creatureIndex;

    Environment(){
        creatureIndex = 0;
        
        for(int i = 0; i < MAXCREATURES; i++){
            creatureList.add(new Creature(creatureIndex++));
        }
    }
    
    private int calculateCrossoverPoint(){
        double x = Math.random() * 6;
        //System.out.println("CP = " + (int)x);
        return ((int)(x));
    }
    
    public void doCrossover(Creature mother, Creature father){
        boolean buffer[] = new boolean[6];
        int crossPoint = calculateCrossoverPoint();
        
        boolean breed1[] = new boolean[6];
        boolean breed2[] = new boolean[6];
        
        breed1 = mother.getGenes().clone();
        breed2 = father.getGenes().clone();
        
        
        for(int i = 0; i < crossPoint; i++){
            buffer[i] = breed1[i];
            breed1[i] = breed2[i];
            breed2[i] = buffer[i];
        }
        
        creatureList.add(new Creature(creatureIndex++, breed1));
        creatureList.add(new Creature(creatureIndex++, breed2));
        
    }
    
    // Primero cruzamos y después se calcula si hubo mutaciones en el proceso.
    public void breed(){
        for (int i = 0; i < 5; i++){
            doCrossover(creatureList.get(i), creatureList.get(i+5));
        }
        for(Creature critter:creatureList){
            critter.computeMutation();
            critter.flipGene();
        }
    }
    
    public void showCreatures(){
        Collections.sort(creatureList);

        for(Creature critter:creatureList){
            System.out.println(critter.getId() + " " + critter + " " + critter.computeFitness());
        }
    }
    
    public boolean gotConvergence2(){
        for(Creature critter: creatureList){
            if (critter.computeFitness() == 6){
                return true;
            }
        }
        return false;
    }
    
    public boolean gotConvergence(){
        int convergence = 0;
        for(Creature critter: creatureList){
            convergence += critter.computeFitness();
        }
        if (convergence > 50){
            return true;
        }else{
            return false;
        }
    }
    
    public void killCreatures(){
        Collections.sort(creatureList);
        for(int i = 0; i < MAXCREATURES; i++){
            creatureList.remove(i);
        }
    }
}
