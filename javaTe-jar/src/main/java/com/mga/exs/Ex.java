package com.mga.exs;

import com.mga.dto.Personne;
  
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Some Java Te Exercices 
 * 
 * @author : MGA
 * @version : 1.0
 * @date : 12/03/2016
 * 
 */
public class Ex {
  
  /**
   * Inheritance ex
   * 
   * @param no_param
   * @return no_return 
   */
  public void fatherAndSun () {
    //================================
    //Father ++ Son ++ interfaceTest ==> to do in eclipse (See on the botom)
    //================================    
    System.out.println("======================================switch case default");
    int sw = 1;
    switch (sw) {
      case (1) :  System.out.println("it is realy 1 ! ");
      case (2) :  System.out.println("it is  2 ?! ");
      case (3) :  System.out.println("oh no it is 3 ?! - after a break all things will be OK "); break;
      case (4) :  System.out.println("don't say that is 4 ! "); break;
    }  
    System.out.println("=====================================");    
  }
   
    /**
     * Primitive Type Exs
     *
     * @param no_param  
     * @return no_return
     */
    public void primitiveType() {
      //================================ Primitive type 
      int i1 = 1;
      Integer I1 = i1; //auto casted  // Boxing
      System.out.println("I1 = " + I1); 
      //Long L1 = i1; //auto casted //Error int cannot be converted to Long
      Long L1 = (long)i1;  // OK 
      Long L2 = Long.parseLong(I1.toString());
      //Long L3 = (Long)I1;
      //Long I2 = (Long)I1; //Error : Integer cannot be converted to Long
      Long I3 = 12L;  
      //Long I4 = (Long)12;  //Error : Integer cannot be converted to Long
    }
  
    /**
     * List and Array Exs
     * 
     * @param no_param
     * @return no_return
     */ 
    public void listAndTab() {
          //=========================== List & tab
         String[] tabS = new String[0];
        //tabS[0] = "chaine1";   //==> Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
                         //at HelloWorld.main(HelloWorld.java:15)

        String[] tabS2 = new String[2];
        tabS2[0] = "chaine1";    
       tabS2[1] = "chaine2";					  
        for(String s : tabS2) {
          System.out.println(s);
        } 
        //==
        ArrayList<String> artists = new ArrayList<>();
        try {
                artists.add(1, "Will Biteman");
                artists.add(2, "Hermann Longlegs");
        } catch (Exception e) {
                e.printStackTrace();  //==> Error
        }
        //==
        try {
                artists.add(0, "Will Biteman");
                artists.add(1, "Hermann Longlegs");
                artists.add(2, "artiste 3");

        } catch (Exception e) {
                e.printStackTrace();
        }
        for (String artist : artists) {
                System.out.println(artist);
        }
        artists.add(1, "artiste 2");
        System.out.println("========== START DISPLAY artiste after insert in ============= ");
        for (String artist : artists) {
                System.out.println(artist);
        }
        System.out.println("========== END DISPLAY artiste after insert in ============= ");
        //
        ArrayList<String> list = new ArrayList<>();
        list.add("Benson1");
        list.add("Benson2");
        String[] names = list.toArray(new String[0]);
        for (String name : names) {
            System.out.println("name ==> " + name);
        }
        //
        //ArrayList<int> intList = new ArrayList<>();  //An ArrayList may only contain objects and not primitives.
        ArrayList<Integer> intList = new ArrayList<>();  

        intList.add(1);
        intList.add(2);
        //intList.add(3,4); //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 3, Size: 2
        intList.add(2,3);
        intList.add(3,4);

        //==================================================== Ex delete from List all personne which have more then x age
        System.out.println("======================================Delete from List all personne which have more then x age");
        Personne p1 = new Personne("first1", "last1", 11);
        Personne p2 = new Personne("first2", "last2", 12);
        Personne p3 = new Personne("first3", "last3", 13);
        Personne p4 = new Personne("first4", "last4", 14);

        ArrayList<Personne> pList = new ArrayList<>(); 
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);


        // diplay List of personne 
        for (Personne p : pList) {
           System.out.println(p.toString());
           // Delete the personnes who has more the 13 age
          if (p.age  > 13) {  // see the direct acess 
            //pList.remove(); // don't work !!! - we should use iterator 
          }  
        }  
        System.out.println("_____ with Itertor ");
        // here with iterator 
        Iterator<Personne> i = pList.iterator();
        while (i.hasNext()) {
          // i.next() will go to next object so if we use twice it will jump 2 
          Personne pTmp = i.next();
          System.out.println(pTmp.toString());
          // now we can delete 
          if (pTmp.age > 13) {
             System.out.println("Here the iterator will be  removed"); 
             pList.remove(i); // be aware if we use this, we will delete the iterator and not the item
          }  
        }  

        System.out.println("_____ after delete with Itertor ");
        while (i.hasNext()) {
          // i.next() will go to next object so if we use twice it will jump 2 
          Personne pTmp = i.next();
          System.out.println(pTmp.toString()); 
        }  

        // here will be good 
        i = pList.iterator();
         while (i.hasNext()) {

          Personne pTmp = i.next();
          System.out.println(pTmp.toString());
          // now we can delete 
          if (pTmp.age > 13) {
             System.out.println("The current Object will be removed"); 
             i.remove(); 
          }  
        }  

        System.out.println("_____ after delete with Itertor by obkect  ");
        for (int k = 0; k < pList.size(); k++) {
           System.out.println(pList.get(k).toString());        
        }  

        //Anathor way 
        System.out.println("_____ Anathor way  ");
        for (int k = 0; k < pList.size(); k++) {     
           if (pList.get(k).age > 12) 
             pList.remove(k);
        }  
        for (int k = 0; k < pList.size(); k++) {     
           System.out.println(pList.get(k).toString());        
        }   
    }
  
   /**
   * FailFast & FailSafe exs
   * 
   * @param no_param 
   * @return no_retrun 
   */
  public void failFastFailSafe() {
     //  Fail fast
    Map<String,String> premiumPhone = new HashMap<String,String>();
    premiumPhone.put("Apple", "iPhone");
    premiumPhone.put("HTC", "HTC one");
    premiumPhone.put("Samsung","S5");

    Iterator iterator = premiumPhone.keySet().iterator();
    System.out.println("Here will try to add an entry in fail fast List ");
    try {
      while (iterator.hasNext())
      {
        System.out.println(premiumPhone.get(iterator.next()));
        premiumPhone.put("Sony", "Xperia Z");
      }
    } catch (ConcurrentModificationException e) {
      System.out.println("Exception !! : ConcurrentModificationException ... this is a Fail Fast ");
    }
      
    //-----------------------------------------
    // Fail safe 
    System.out.println("------ ");
    System.out.println("Here will try to add an entry in fail safe List ...");
    ConcurrentHashMap<String,String> premiumPhoneFailSafe = new ConcurrentHashMap<String,String>();
    premiumPhoneFailSafe.put("Apple", "iPhone");
    premiumPhoneFailSafe.put("HTC", "HTC one");
    premiumPhoneFailSafe.put("Samsung","S5");
        
    Iterator iterator2 = premiumPhoneFailSafe.keySet().iterator();    
     
      while (iterator2.hasNext())
      {
        System.out.println(premiumPhoneFailSafe.get(iterator2.next()));
        //premiumPhoneFailSafe.put("Sony", "Xperia Z");
      }
      
    System.out.println("==> No Exception ... let check the lists ");
    System.out.println("let see the original list");
    System.out.println("with the same iterator");
    // let see the original list , it has been changed ?
    // let first use the same iterator     
    System.out.println("\n======= after add in the loop");
    iterator2 = premiumPhoneFailSafe.keySet().iterator();
    while (iterator2.hasNext()) {
      System.out.println(premiumPhoneFailSafe.get(iterator2.next()));  //--> No Change       
    }  
    
    System.out.println("=======\n======= A new iterator ");
    // let's get anothor iterartor
    Iterator iterator3 =  premiumPhoneFailSafe.keySet().iterator();
    while (iterator3.hasNext()) {
      System.out.println(premiumPhoneFailSafe.get(iterator3.next()));  //--> No Change also !       
    } 
    System.out.println("========\n======= Add new entry manually ");
    iterator3 =  premiumPhoneFailSafe.keySet().iterator();
    premiumPhoneFailSafe.put("Asus","pade2");
    while (iterator3.hasNext()) {
      System.out.println(premiumPhoneFailSafe.get(iterator3.next()));  //--> No Change also !       
    }    
  }   
}
