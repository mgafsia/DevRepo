package com.ad.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ad.exceptions.ListToolsException;
import com.ad.partition.Partition;
import com.ad.partition.impl.PartitionImpl;

 

/**
 * TestCases - Junit tests class : 
 * 
 * @version 1.0
 * @author 	MGA
 * @date   	08/02/2016
 * 
 */
public class TestCases {
	
	private static Logger logger = LoggerFactory.getLogger( TestCases.class );
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * 
	 * Test function for Partition of Integer List with stream functions
	 * JDK >= 8
	 * 
	 * @param 
	 * @return 
	 * @throws ListToolsException 
	 * 
	 */
	@Test
	public void partitionIntListByStreamTest() throws ListToolsException  {
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
	}
			
	/**
	 * 
	 * Test function for Partition of String List with stream functions
	 * JDK >= 8
	 * 
	 * @param 
	 * @return 
	 * @throws ListToolsException 
	 * 
	 */
	@Test
	public void partitionStringListByStreamTest() throws ListToolsException  { 
		
		logger.debug("============================================ List of String Test =");  
		logger.debug("partitionStringListByStreamTest() == Starts ======================");	
		//
		Partition<String> stringPartition 	= new PartitionImpl<String>();		
		List<String> inputStringList		= new ArrayList<String>();  /* String  Input List 	*/
		List<List<String>> outputSplittedtList; 	/* OutPut List 			*/
		List<List<String>> expectedSplittedList	= new ArrayList<List<String>>();  /* Expected OutPut List */
		String outputSplittedtListString 			= "";  /* Concatenated String for outPut sub lists */
		String expectedSplittedListString 			= "";  /* Concatenated String for all expected sub list */
		
		/* Test (1) */
		/* InPut 	*/		
		
		/* String List */
		inputStringList.add("str1");
		inputStringList.add("str2");
		inputStringList.add("null");
		inputStringList.add("str4");		
		inputStringList.add("str5");
		
		logger.info("Test(1) === Sub List size = " + 2);
		logger.info("  In(1) <== " + inputStringList);
				
		/* Output */		
		outputSplittedtList = stringPartition.listPartition(inputStringList, 2);
		
		logger.info("  Out(1) ==> " + outputSplittedtList);
		
		/* Expected Splitted List */		
		expectedSplittedList.add(Arrays.asList("str1","str2"));
		expectedSplittedList.add(Arrays.asList(null,"str4"));
		expectedSplittedList.add(Arrays.asList("str5"));
		 
		
		/* Convert two lists into string and compare them */
		outputSplittedtListString 	= stringPartition.concatWithSep(outputSplittedtList);
		expectedSplittedListString 	= stringPartition.concatWithSep(expectedSplittedList);
		
		/* Assert */
		assertEquals(expectedSplittedListString, outputSplittedtListString);
				 
		// 
		logger.debug("partitionStringListByStreamTest()    == End ======================");
		logger.debug("==================================================================");
	}
	
	/**
	 * 
	 * Test function for Partition List tool - size params exceptions.
	 * JDK >= 8
	 * 
	 * @param 
	 * @return 
	 * @throws ListToolsException 
	 * 
	 */
	@Test
	public void partitionListSizeParamExcepTest() throws ListToolsException  {
		
		logger.debug("================================================= size Parm Test ="); 
		logger.debug("partitionListSizeParamExcepTest() == Starts ======================"); 
		
		/* Expected Exception */
		thrown.expect(ListToolsException.class);		
		thrown.expectMessage("Invalide size param");		 
		
		Partition<Integer> partition = new PartitionImpl<Integer>();
		
		/* Integer Input List */	 
		List<Integer> inputIntlist = Arrays.asList(1,2,3,4,5);
		logger.info("Test === Sub List size = " , -5);
		logger.info("In <== " + inputIntlist);
		
		/* Output List */		
		@SuppressWarnings("unused")
		List<List<Integer>>  outputSplittedtList;
		outputSplittedtList = partition.listPartition(inputIntlist, -5);	
		
		logger.debug("partitionListSizeParamExcepTest()    == End ======================");
		logger.debug("==================================================================");

	}

	/**
	 * 
	 * Test function for Partition List tool - input List exceptions.
	 * JDK >= 8
	 * 
	 * @param 
	 * @return 
	 * @throws ListToolsException 
	 * 
	 */
	@Test
	public void partitionListParamExcepTest() throws ListToolsException  {
		
		logger.debug("================================================= size Parm Test ="); 
		logger.debug("partitionListParamExcepTest() == Starts ==========================");
		
		/* Expected Exception */
		thrown.expect(ListToolsException.class);		
		thrown.expectMessage("List is null");		 
		
		Partition<Integer> partition = new PartitionImpl<Integer>();
		
		/* Integer Input List is null ... */	 
		List<Integer> inputIntlist = null; 
		logger.info("In <== " + inputIntlist);
		
		/* Output List */		
		@SuppressWarnings("unused")
		List<List<Integer>>  outputSplittedtList;
		outputSplittedtList = partition.listPartition(inputIntlist, 2);		
	
		logger.debug("partitionListParamExcepTest()    == End ==========================");
		logger.debug("==================================================================");
	}

	
}
 