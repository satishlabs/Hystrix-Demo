package com.satishlabs.booksearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@CrossOrigin
@RestController
public class BookSearchController {
	static Logger logInfo=LoggerFactory.getLogger(BookSearchController.class);
	
	
	@GetMapping("/allbooks")
	@CircuitBreaker(name = "BookSearchMS", fallbackMethod = "getAllBooksFallback")
	public List<String> getAllBooks(){
		logInfo.info("--- BookSearchController --- getAllBooks() ---");
		List<String> booksList = new ArrayList<String>();
		booksList.add("Java");
		booksList.add("Spring");
		booksList.add("Spring Boot");
		booksList.add("Angular");
		booksList.add("React");
		return booksList;
	}
	
	public List<String> getAllBooksFallback(Throwable throwable) {
	    return List.of("Fallback Book 1", "Fallback Book 2");
	}

	@GetMapping("/booksByAuthor/{author}")
	//@HystrixCommand(fallbackMethod = "getBooksByAuthorFallback")
	@CircuitBreaker(name = "BookSearchMS", fallbackMethod = "getBooksByAuthorFallback")
	public List<String> getBooksByAuthor(@PathVariable String author){
		logInfo.info("--- BookSearchController --- getBooksByAuthor() ---");
		
		if(1==1) {
			throw new ArithmeticException();
		}
		return null;
	}
	

	public List<String> getBooksByAuthorFallback(String author, Throwable throwable){
	    logInfo.info("--- BookSearchController --- getBooksByAuthorFallback() --- Error: " + throwable.getMessage());
		List<String> booksList = new ArrayList<String>();
		booksList.add("No Books Available Currently for Author: "+author);
		return booksList;
	}
}
