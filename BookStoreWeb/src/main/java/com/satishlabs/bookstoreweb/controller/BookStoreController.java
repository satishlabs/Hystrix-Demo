/**
 * 
 */
package com.satishlabs.bookstoreweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.bookstoreweb.proxy.BookSearchProxy;

/**
 * @author Satish
 * 
 *         Jul 18, 2022
 */

@CrossOrigin
@RestController
public class BookStoreController {
	static Logger logInfo = LoggerFactory.getLogger(BookStoreController.class);

	@Autowired
	private BookSearchProxy bookSearchProxy;
	
	@GetMapping("/mybooks")
	public List<String> getMyBooks(){
		logInfo.info("---BookStoreController --- getMyBooks()---");
		List<String> booksList = bookSearchProxy.getAllBooks();
		return booksList;
	}
	
	@GetMapping("/mybooks/{author}")
	public List<String> getBooksByAuthor(@PathVariable String author){
		logInfo.info("---BookStoreController --- getBooksByAuthor()---");
		List<String> booksList = bookSearchProxy.getBooksByAuthor(author);
		return booksList;
	}

}
