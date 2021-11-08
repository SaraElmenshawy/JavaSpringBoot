package com.springboot.first.app;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.CustomsearchRequestInitializer;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;
import com.springboot.first.app.dto.Variable;

@RestController
public class HelloWorldController {

	/*
	@RequestMapping(value="/GoogleSearch1",method = RequestMethod.GET )
	public String getSearchResults2()
	{
		return "hello sara";
	}*/
	
	@RequestMapping(value="/GoogleSearch",method = RequestMethod.POST, consumes="application/json")
	public List<Result> getSearchResults(@RequestBody Variable variable) throws IOException, GeneralSecurityException
	{
		String searchQuery = variable.getKeyword(); //The query to search
	    String cx = "f04801c6618c03160"; //Your search engine

	    //Instance Customsearch
	    Customsearch cs = new Customsearch.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null) 
	                   .setApplicationName("SearchApp") 
	                   .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer("AIzaSyD8V-uoh9rQs3hwLEDgwAMdjMOMFC8fiyc")) 
	                   .build();

	    //Set search parameter	 
	    Customsearch.Cse.List list = cs.cse().list(searchQuery).setCx(cx); 

	    //Execute search
	    Search result = list.execute();
	    
	    /*
	    if (result.getItems()!=null){
	    	System.out.println(result.getItems());
	    	
	        for (Result ri : result.getItems()) {
	            //Get title, link, body etc. from search
	            System.out.println(ri.getTitle() + ", " + ri.getLink());
	        }
	    }*/
	        
		return result.getItems();
	}
}
