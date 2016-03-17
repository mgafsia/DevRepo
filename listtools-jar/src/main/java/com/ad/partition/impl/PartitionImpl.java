package com.ad.partition.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ad.exceptions.ListToolsException;
import com.ad.partition.Partition;


/**
 * PartitionImp Class - List Partition tools implementation. 
 * 
 * @version 1.0
 * @author MGA
 * @date   07/02/2016
 * 
 */
public class PartitionImpl <T> implements Partition<T>, Serializable {
	
	private static Logger logger = LoggerFactory.getLogger( PartitionImpl.class );
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Split given List to sub list flowing the given size
	 * JDK >= 8 ( using stream functions )
	 * 
	 * @param  	inList : input list
	 * @param 	subListSize : size of sub list
	 * @return 	splitted list
	 * @throws 	ListToolsException 
	 * 
	 */
	@Override
	public List<List<T>> listPartition(List<T> inList, Integer subListSize) throws ListToolsException {
		
		verifiesListAndPram(inList, subListSize);  /* Check params */
		//
		AtomicInteger index = new AtomicInteger(0);	/* Count the current number of the current sub list */	
		final List<T> subList = new ArrayList<>();	/* Current sub list */
		//
		try {
			return inList.stream().collect(Collector.of( 
								() -> new ArrayList<List<T>>(),
								(l, elem) -> {
									/* logger.info("subListSize = " + subListSize + " | index = " + index); */
									subList.add(elem);   /* Add the current list to the sub list */
									index.incrementAndGet()	;
									//
		                        	if(  index.compareAndSet(subListSize, 0)  ) {	/* if the number of element added
		                        	                        			       		 * to list is equal to subListSize
		                        	                        			       		 * add the current sub list to the 
		                        	                        			       		 * mother  list. 
		                        	                        			       		 * */ 
		                        		l.add(new ArrayList<>(subList)); 
	                	            	subList.clear();          	  
	                	            }  	                        	
	                	         },
	                	         (l1, l2) -> {throw new RuntimeException("");},
	                	         l -> {if(subList.size() != 0) l.add(subList); return l;}
					));
		}
		catch (Exception e) {	
			throw new ListToolsException();
		}		
	}
	
	/**
	 * 
	 * Split given List to sub list flowing the given size
	 * JDK <= 8  
	 * 
	 * @param  	inList : input list
	 * @param 	size : size of sub list
	 * @return 	splitted list
	 * @throws 	ListToolsException 
	 * 
	 */
	public List<List<T>> listPartitionOld(List<T> inList, Integer subListSize) throws ListToolsException {
				
		/* Check params */
		verifiesListAndPram(inList, subListSize);
		//
		List<List<T>> motherList = new ArrayList<List<T>>();
		try {		
			  int i,j;
			  //
			  for(i=0; i< inList.size();) {  	/* for all elem of inList */
				  List<T> subList = new ArrayList<T>();			  
				  for (j=0 ; j< subListSize; j++ ) {  /* add subListSize elem to subList */
					  if (i+j < inList.size())
						  subList.add(inList.get(i+j));
					  else 
						  break;				  
				  }
				  i=i+j; /* Jump */
				  motherList.add(subList);
			  }			
		}
		catch (Exception e) {	
			throw new ListToolsException();
		}		
		return motherList;		
	}
		
	/**
	 * 
	 * Concact the given List of List in one String 
	 * JDK >= 8
	 * 
	 * @param  listOfList : list to be concatenated
	 * @return String with all elements 
	 * 
	 */
	public String concatWithSep(List<List<T>> listOfList) {		
		StringJoiner listJoinner =  new StringJoiner("|");  // Separator between sub lists
		StringJoiner elemJoinner = new StringJoiner(",");	// Separator between elem of same sub list
		//
		for (List<T> list : listOfList ) {
			for (T elem : list ) {
				if (elem == null) {
					elemJoinner.add("null");
				}
				else {
					elemJoinner.add(elem.toString());
				}	
			}
			listJoinner.add(elemJoinner.toString());
			elemJoinner = new StringJoiner(",");
		}
		return listJoinner.toString();				
	}

	
	/**
	 * 
	 * Verifies Partitions tools parames 
	 * JDK >= 8
	 * 
	 * @param  inList : input list
	 * @param  size : size of sub lists
	 * @return True if params are OK
	 * @exception ListToolsException
	 * 
	 */
	public boolean verifiesListAndPram(List<T> inList, Integer size) throws ListToolsException {
		String error_message = "";
		if (size == null) {
			error_message = "size is null";
			logger.error("Error ::  verifiesListAndPram :  " + error_message);
			throw new ListToolsException(error_message);
		} 
		else if (inList == null) {
				error_message = "List is null";
				logger.error("Error ::  verifiesListAndPram :  " + error_message);
		     	throw new ListToolsException(error_message);
		     }
		     else if (size < 1 || size > inList.size()) {
			    	 error_message = "Invalide size param. Should be between 1 and list size";
					 logger.error("Error ::  verifiesListAndPram :  " + error_message);
				     throw new ListToolsException(error_message);		    	 
			  	}	 	 
		return true;		
	}
}