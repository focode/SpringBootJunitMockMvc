package com.algo.done;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgoController {
	
	@Autowired
	UltimateSolution ultimateSolution;
	
	@RequestMapping(value = "/{time}", method = RequestMethod.GET)
	String readTime(@PathVariable Integer time) throws FileNotFoundException, IOException {
		
		System.out.println("the input time is ::"+time);
		return "Maximum satisfaction that can be attained by Mr. Gorden in "+time+" is :"+ultimateSolution.getSatisfaction(time);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String readRoot() throws FileNotFoundException, IOException {
		return "ok";
	}
	

}
