package com.ad.partition;

import java.util.List;

import com.ad.exceptions.ListToolsException;

/**
 * Partition Interface - List Partition tools. 
 * 
 * @version 1.0
 * @author MGA
 * @date   07/02/2016
 * 
 */
public interface Partition <T>{	
	/* List Partition */
	public List<List<T>> listPartition(List<T> inList, Integer subListSize) 		throws ListToolsException;  	// jdk = 8 
	public List<List<T>> listPartitionOld(List<T> inList, Integer subListSize) 		throws ListToolsException ;  	// jdk <= 8
	/* List Compare */
	public String concatWithSep(List<List<T>> l);  
}