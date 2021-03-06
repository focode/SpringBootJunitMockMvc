package com.algo.done;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.algo.done.dto.MealsSatisfaction;
import com.algo.done.dto.TempDataForPartial;
import com.google.common.primitives.Ints;


import com.algo.done.utility.*;

@Component
public class AlgoSolution {
	
	
	@Value(value = "classpath:data.txt")
	private Resource dataFile;
	
	@Autowired
	SumSetUtility sumSet;
	    /**
	     * 
	     * @param targetTime
	     * @return
	     * @throws FileNotFoundException
	     * @throws IOException
	     */
		public int getSatisfaction(int targetTime) throws FileNotFoundException, IOException{

			List<MealsSatisfaction> timeAndSatisfaction = new ArrayList<MealsSatisfaction>();
			List<Integer> times = new ArrayList<Integer>();
			// reading data.txt from resource folder and storing it in list
			try (BufferedReader br = new BufferedReader(new FileReader(dataFile.getFile()))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			       // process the line.
			    	String[] val = line.split(" ");
			    	int staisfaction = Integer.parseInt(val[0]);
			    	int time = Integer.parseInt(val[1]);
			    	times.add(time);
			    	timeAndSatisfaction.add(new MealsSatisfaction(time,staisfaction));
			    }
			}
			
			
			// Organizing the output
			Integer[] numbers = Arrays.stream( Ints.toArray(times) ).boxed().toArray( Integer[]::new );
			List <TempDataForPartial> tempDataForPartial= sumSet.sum_up_recursive(new ArrayList<Integer>(Arrays.asList(numbers)),targetTime,new ArrayList<Integer>());
			int count = -1;
			int satisfaction = 0;
			int[]sat = new int[tempDataForPartial.size()];
			for (TempDataForPartial tempDataForPartial2 : tempDataForPartial) {
				
				count++;
				satisfaction = 0;
				
				
				List<Integer> tempTimes  = tempDataForPartial2.getTemp();
				for(MealsSatisfaction mealsSatisfaction:timeAndSatisfaction){
					int val = matchFound(mealsSatisfaction,tempTimes);
					satisfaction = satisfaction+val;
					sat[count] = satisfaction;
				}
			}
			
			Arrays.sort(sat);
			
			tempDataForPartial = null;
			satisfaction = 0;
			if(sat.length>0){
			// after sorting last number is the maximum satisfaction	
			System.out.println("Maximum satisfaction:"+sat[sat.length-1]);
			int satVal = sat[sat.length-1];
			 sat = null;
			return satVal;
			}else{
				// their might not be any satisfaction
				System.out.println("Sorry wrong input");
				return 0;
			}
			
		}
		/**
		 * 
		 * @param mealsSatisfaction
		 * @param tempTimes
		 * @return
		 */
		private static int matchFound(MealsSatisfaction mealsSatisfaction, List<Integer> tempTimes) {
			int satisfaction = 0;
			for (Integer integer : tempTimes) {
				if(integer.equals(mealsSatisfaction.getTime())){
					int mealSat = mealsSatisfaction.getStatisfaction();
					satisfaction = satisfaction+mealSat;			
				}
			}
			
			return satisfaction;
		}
		
	}

	


