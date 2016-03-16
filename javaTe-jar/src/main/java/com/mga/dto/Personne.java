package com.mga.dto;


/**
 * Personne dto
 * 
 * @author : MGA
 * @version : 1.0
 * @date : 12/12/2015
 * 
 */
public class Personne
{
  
    String firstname;  // see the defalut acess called friendly ==> public for the current package
    String lastname;   // see the defalut acess called friendly
    public int age;    // test --        
  
  
  public Personne(String firstname, String lastname, int age) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.age = age;    
  }  
  
  @Override
  public String toString() {
    return  "firstname : " + firstname  + " - lastname : " + lastname + " - age : " + age;  
  }  
  
}