package com.smartAI.search.service;
import com.smartAI.search.model.VectorData;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    @Autowired
    @Qualifier("simpleVectorStore")
    private VectorStore store;

    public List<Document> search(String queryText) {
        List<Document> documents = store.similaritySearch(SearchRequest.query(queryText).withTopK(5));
        return documents;
        //A5EK5E17Hwqze2fpgW8CL	As a father comes to grips with his daughter's upcoming wedding, the true meaning of family is revealed, illustrating the ways the heart can adapt for love.	comedy
    }

//    public Document create(VectorData data) {
//        File vectorStoreFile = new File("/Users/ravisingh/mlearning/search/tmp/vectorstore.json");
//        Map<String, Object> metadata = new HashMap<>();
//        metadata.put("source", "atom");
//        Document document = new Document(data.toString(), metadata);
//        store.doAdd(List.of(document));
//        store.save(vectorStoreFile);
//        return document;
//    }
}
