package com.smartAI.search.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "ai-search.ai-app")
public class VectorStoreProperties {
    private String vectorStorePath;
    private List<Resource> documentsToLoad;
    public String getVectorStorePath() {
        return vectorStorePath;
    }

    public void setVectorStorePath(String vectorStorePath) {
        this.vectorStorePath = vectorStorePath;
    }

    public void setDocumentsToLoad(List<Resource> documentsToLoad) {
        this.documentsToLoad = documentsToLoad;
    }

    public List<Resource> getDocumentsToLoad() {
        return documentsToLoad;
    }
}
