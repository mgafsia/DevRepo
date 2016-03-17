package com.ad.run;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ad.exceptions.ListToolsException;
import com.ad.partition.Partition;
import com.ad.partition.impl.PartitionImpl;

/**
 * MainTestRun - Main class to run some tests.
 * 
 * @version 1.0
 * @author 	MGA
 * @date  	07/02/2016
 *
 */
public class MainTestRun {
	
	private static Logger logger = LoggerFactory.getLogger( MainTestRun.class );
	
	/**
	 * Get main params and run tests.
	 * @param args
	 * @return 
	 * @throws ListToolsException 
	 * 
	 */
	public static void main(String[] args) throws ListToolsException {
		if(args.length == 0 || !(args[0].equals("test"))) {
			logger.info("Please use commande <java -jar listtools-jar.jar test> to run tests");
		    System.exit(0);
		} else if (args[0].equals("test")) {
			/* 
			 * Tests 
			 * 
			 * */ 
			try {
				logger.debug("=========================================== List of Integer Test ="); 
				logger.debug("partitionIntListByStreamTest() == Starts ========================="); 
				//
				Partition<Integer> partition = new PartitionImpl<Integer>();			 
				List<Integer> inputIntlist;  				/* Integer Input List 	*/
				List<List<Integer>> outputSplittedtList; 	/* OutPut List 			*/
				List<List<Integer>> expectedSplittedList	= new ArrayList<List<Integer>>();  /* Expected OutPut List */
				String outputSplittedtListString 			= "";  /* Concatenated String for outPut sub lists */
				String expectedSplittedListString 			= "";  /* Concatenated String for all expected sub list */
				
				/* Test (1) */
				/* InPut 	*/
				inputIntlist = Arrays.asList(1,2,3,4,5);
				logger.info("Test(1) === Sub List size = " + 2);
				logger.info("  In(1) <== " + inputIntlist);	
				
				/* Output */		
				outputSplittedtList = partition.listPartition(inputIntlist, 2);		
				logger.info("  Out(1) ==> " + outputSplittedtList);
				
				/* Expected Splitted List */		
				expectedSplittedList.add(Arrays.asList(1,2));
				expectedSplittedList.add(Arrays.asList(3,4));
				expectedSplittedList.add(Arrays.asList(5));				
				
				/* Convert two lists into string and compare them */
				outputSplittedtListString 	= partition.concatWithSep(outputSplittedtList);
				expectedSplittedListString 	= partition.concatWithSep(expectedSplittedList);
				
				/* Assert */
				assertEquals(expectedSplittedListString, outputSplittedtListString);
				
				
				/* Test (2) */
				/* InPut 	*/
				//inputIntlist = Arrays.asList(1,2,3,4,5);
				logger.info("Test(2) === Sub List size = " + 3);
				logger.info("  In(2) <== " + inputIntlist);
				
				
				/* Output */
				outputSplittedtList = null; 
				outputSplittedtList = partition.listPartition(inputIntlist, 3);		
				logger.info("  Out(2) ==> " + outputSplittedtList);
				
				/* Expected Splitted List */
				expectedSplittedList.clear();
				expectedSplittedList.add(Arrays.asList(1,2,3));
				expectedSplittedList.add(Arrays.asList(4,5));
				
				/* Convert two lists into string and compare them */
				outputSplittedtListString 	= partition.concatWithSep(outputSplittedtList);
				expectedSplittedListString 	= partition.concatWithSep(expectedSplittedList);
				
				/* Assert */
				assertEquals(expectedSplittedListString, outputSplittedtListString);
				
				/* Test (3) */
				/* InPut 	*/
				//inputIntlist = Arrays.asList(1,2,3,4,5);
				logger.info("Test(3) === Sub List size = " + 1);
				logger.info("  In(3) <== " + inputIntlist);		
				
				/* Output */		
				outputSplittedtList = partition.listPartition(inputIntlist, 1);		
				logger.info("  Out(3) ==> " + outputSplittedtList);
				
				/* Expected Splitted List */
				expectedSplittedList.clear();
				expectedSplittedList.add(Arrays.asList(1));
				expectedSplittedList.add(Arrays.asList(2));
				expectedSplittedList.add(Arrays.asList(3));
				expectedSplittedList.add(Arrays.asList(4));
				expectedSplittedList.add(Arrays.asList(5));
				
				/* Convert two lists into string and compare them */
				outputSplittedtListString 	= partition.concatWithSep(outputSplittedtList);
				expectedSplittedListString 	= partition.concatWithSep(expectedSplittedList);
				
				/* Assert */
				assertEquals(expectedSplittedListString, outputSplittedtListString);
				 
				//
				logger.debug("partitionIntListByStreamTest()    == End =========================");
				logger.debug("=================================================================="); 
				
			} catch (ListToolsException e) {
				logger.info(e.getMessage());
			} 							
		}	 
	}
}
