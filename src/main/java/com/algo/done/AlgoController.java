package com.algo.done;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.done.utility.KnapsackUtility;
import com.algo.done.utility.SumSetUtility;

@RestController
public class AlgoController {
	
	@Autowired
	AlgoSolution algoSolution;
	
	@Autowired
	KnapsackUtility kanpsackUtility;
	
	@Value(value = "classpath:data.txt")
	private Resource dataFile;
	
	@Autowired
	SumSetUtility sumSet;
	
	/**
	 * @param time
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "/time/{time2}", method = RequestMethod.GET)
	String readTime(@PathVariable Integer time) throws FileNotFoundException, IOException {
		
		
		System.out.println("the input time is ::"+time);
		return "Maximum satisfaction that can be attained by Mr. Gorden in "+time+" is :"+algoSolution.getSatisfaction(time);
	}
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "/{timeVal}", method = RequestMethod.GET)
	String readRoot(@PathVariable Integer timeVal) throws FileNotFoundException, IOException {
		List<Integer> satisfaction = new ArrayList<Integer>();
		List<Integer> times = new ArrayList<Integer>();
		
		
		// reading data.txt from resource folder and storing it in list
		try (BufferedReader br = new BufferedReader(new FileReader(dataFile.getFile()))) {
		 String line;
		   while ((line = br.readLine()) != null) {
		     // process the line.
		   	String[] val = line.split(" ");
		   	int satisfactionAmount = Integer.parseInt(val[0]);
		   	int time = Integer.parseInt(val[1]);
		   	times.add(time);
		   	satisfaction.add(satisfactionAmount);
		    }
		}
		    //10000 100
		
	        int n = 100; 
	        int []wt = new int[satisfaction.size()];
	        for (int i=0;i<=satisfaction.size()-1;i++) {
	        	wt[i] = satisfaction.get(i);
			}
	 
	       
	        int []val = new int[times.size()];
	        for(int i = 0;i<=times.size()-1;i++){
	        	val[i] = times.get(i);
	        }
	 
	       
	        int W = timeVal;// maximum capicity
	 
	        System.out.println("The maximum value that can be put in a knapsack of capacity W is: " + kanpsackUtility.knapSack(W, wt, val, n));
	       
		
		
		
		return "Maximum satisfaction that can be attained by Mr. Gorden in "+timeVal+" is :"+kanpsackUtility.knapSack(W, wt, val, n);
	}
	
	
	
	

}
