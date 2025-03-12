package com.satishlabs.bookstoreweb.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(value = "BookSearchMS", url = "http://localhost:8000")
@FeignClient(name = "BookSearchMS")
public interface BookSearchProxy {
	
	@GetMapping("/allbooks")
	public List<String> getAllBooks();
	
	@GetMapping("/booksByAuthor/{author}")
	public List<String> getBooksByAuthor(@PathVariable String author);
}
