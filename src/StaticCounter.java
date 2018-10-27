/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john
 */
public class StaticCounter {
    private static int counter = 0;
    
    public static int getCount(){
        return counter;
    }
    
    public static void incrementCount(){
        counter++;
    }
}
