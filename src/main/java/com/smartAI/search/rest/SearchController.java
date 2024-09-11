package com.smartAI.search.rest;

import com.smartAI.search.model.SearchRequest;
import com.smartAI.search.model.SearchResponse;
import com.smartAI.search.model.VectorData;
import com.smartAI.search.service.SearchService;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/simple", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<SearchResponse> getDocuments(@RequestBody SearchRequest query) {
        List<Document> documents = searchService.search(query.getQuery());
        List<SearchResponse> responses = documents.stream()
                .map(document -> document.getContent().split("\n"))
                .flatMap(Stream::of).map(data -> {
                            String[] temp = data.split("\t");
                            SearchResponse response = new SearchResponse();
                             if(temp.length > 2) {
                                 response.setContentId(temp[1]);
                                 response.setDetail(temp[2]);
                                 response.setCategory(temp[3]);
                             }else if (temp.length > 3) {
                                 response.setContentId(temp[1]);
                                 response.setDetail(temp[2]);
                                 response.setCategory(temp[3]);
                             }
                            return response;
                        }
                )
                .limit(5).collect(Collectors.toList());
        return responses;
    }

//    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public SearchResponse create(@RequestBody VectorData data) {
//        Document document = searchService.create(data);
//        SearchResponse response = new SearchResponse();
//        return response;
//    }


}
