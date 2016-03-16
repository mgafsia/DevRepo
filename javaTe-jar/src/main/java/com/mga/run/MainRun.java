package com.mga.run;

import com.mga.exs.Ex;


/**
 * Main class for runnig some java Exs
 * 
 * @author : MGA 
 * @version : 1.0
 * @Date : 12/03/2016
 * 
 */
public class MainRun {

    public static void main(String[] args) {
        System.out.println("=========================== START");
        Ex ex = new Ex();
        ex.failFastFailSafe();
        System.out.println("=========================== END==");
    }
}
