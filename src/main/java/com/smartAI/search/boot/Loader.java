package com.smartAI.search.boot;

import com.smartAI.search.config.VectorStoreProperties;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Slf4j
@Component
@Profile("milvus")
public class Loader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Loader.class);
    @Autowired
    VectorStore vectorStore;

    @Autowired
    VectorStoreProperties vectorStoreProperties;

    @Override
    public void run(String... args) throws Exception {
      //  if(vectorStore.similaritySearch("back to the future").isEmpty()) {
            vectorStoreProperties.getDocumentsToLoad().forEach(
                    doc -> {
                        try {
                            TikaDocumentReader documentReader = new TikaDocumentReader(doc);
                            List<Document> docs = documentReader.get();
                            TextSplitter textSplitter = new TokenTextSplitter();
                            List<Document> splitDoc = textSplitter.apply(docs);
                            vectorStore.add(splitDoc);
                        }catch (Exception e) {
                            logger.debug("Exception during embedding" + e.getMessage());
                        }
                    }
            );
        //}

        logger.debug("Vector data loaded into DB");
    }
}
