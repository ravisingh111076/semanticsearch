package com.smartAI.search.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
//import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.util.List;
//
//import static org.springframework.ai.vectorstore.PgVectorStore.DEFAULT_SCHEMA_VALIDATION;
//import static org.springframework.ai.vectorstore.PgVectorStore.INVALID_EMBEDDING_DIMENSION;

@Slf4j
@Configuration
public class VectorStoreConfig {

    private static final Logger logger = LoggerFactory.getLogger(VectorStoreConfig.class);
    @Bean("simpleVectorStore")
    @Profile("simple")
    SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel, VectorStoreProperties vectorStoreProperties ) {
       var store = new SimpleVectorStore(embeddingModel);
       File vectorStoreFile = new File(vectorStoreProperties.getVectorStorePath());
       if(vectorStoreFile.exists()) {
           store.load(vectorStoreFile);
       } else {
           logger.debug("Loading documents into vector store");
           for (Resource resource : vectorStoreProperties.getDocumentsToLoad()) {
               TikaDocumentReader documentReader = new TikaDocumentReader(resource);
               List<Document> docs = documentReader.get();
               TextSplitter textSplitter = new TokenTextSplitter();
               List<Document> splitDoc = textSplitter.apply(docs);
               store.add(splitDoc);
           }
           store.save(vectorStoreFile);
       }
       return store;
    }

//    @Bean("postgresVectorStore")
//    @Profile("postgres")
//    public VectorStore vectorStore(JdbcTemplate jdbcTemplate, EmbeddingModel embeddingModel, VectorStoreProperties vectorStoreProperties) {
//        var store = new PgVectorStore(jdbcTemplate, embeddingModel);
////        new PgVectorStore("content", "vector_store", DEFAULT_SCHEMA_VALIDATION, jdbcTemplate, embeddingModel, INVALID_EMBEDDING_DIMENSION, PgVectorStore.PgDistanceType.COSINE_DISTANCE, false,
////                PgVectorStore.PgIndexType.NONE, false);
//       // File vectorStoreFile = new File(vectorStoreProperties.getVectorStorePath());
////        if(vectorStoreFile.exists()) {
////            store.load(vectorStoreFile);
////        } else {
//            logger.debug("Loading documents into vector store");
//           if(store.similaritySearch("I want to Indian movie").isEmpty()) {
//               for (Resource resource : vectorStoreProperties.getDocumentsToLoad()) {
//                   try {
//                       TikaDocumentReader documentReader = new TikaDocumentReader(resource);
//                       List<Document> docs = documentReader.get();
//                       TextSplitter textSplitter = new TokenTextSplitter();
//                       List<Document> splitDoc = textSplitter.apply(docs);
//                       store.doAdd(splitDoc);
//                   } catch (Exception ex) {
//                       System.out.print("ex :" + ex.getMessage());
//                   }
//               }
//           }
//        return store;
//    }
}
