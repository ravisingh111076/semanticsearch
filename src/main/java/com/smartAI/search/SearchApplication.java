package com.smartAI.search;

import com.smartAI.search.dao.Loader;
import org.springframework.ai.document.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SearchApplication {

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(SearchApplication.class, args);

//		Loader loader = new Loader();
//		loader.load("/Users/ravisingh/mlearning/search/src/main/resources/movie.json");
//		TimeUnit.SECONDS.sleep(5);
//
//		List<Document> result = loader.similaritySearch("back to the future");
//		result.stream().forEach(doc-> System.out.print(doc.getContent()));
	}

}
