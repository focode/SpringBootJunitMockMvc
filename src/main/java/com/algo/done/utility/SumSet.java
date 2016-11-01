package com.algo.done.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.algo.done.dto.TempDataForPartial;


@Component
public class SumSet {
	List <TempDataForPartial> tempPartials = new ArrayList<TempDataForPartial>();
	public List <TempDataForPartial>  sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
      
       int s = 0;
       for (int x: partial) s += x;
       if (s == target){
       TempDataForPartial tempDataForPartial = new TempDataForPartial();
       tempDataForPartial.setTemp(partial);
       tempPartials.add(tempDataForPartial);
       }
       if (s >= target){
    	   return tempPartials;
       }
           
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
	return tempPartials;
    }
    
}
