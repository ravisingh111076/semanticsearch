package com.smartAI.search.dao;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.JsonReader;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

public class Loader {
    @Autowired
    VectorStore vectorStore;

    public void load(String sourceFile) {
        JsonReader jsonReader = new JsonReader(new FileSystemResource(sourceFile),
                "contentid", "text", "category");
        List<Document> documents = jsonReader.get();
        this.vectorStore.add(documents);
    }

    public List<Document> similaritySearch(String text) {
        List<Document> similarDocuments = vectorStore.similaritySearch(SearchRequest.query(text).withTopK(5));
        //List<Document> similarDocuments = vectorStore.similaritySearch(text);
        return similarDocuments;
    }
}
