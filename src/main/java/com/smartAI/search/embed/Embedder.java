//package com.smartAI.search.embed;
//
//import com.smartAI.search.dao.Loader;
//import org.springframework.ai.chat.client.advisor.observation.AdvisorObservationContext;
//import org.springframework.ai.document.Document;
//import org.springframework.ai.embedding.EmbeddingRequest;
//import org.springframework.ai.embedding.EmbeddingResponse;
//import org.springframework.ai.ollama.OllamaEmbeddingModel;
//import org.springframework.ai.ollama.api.OllamaApi;
//import org.springframework.ai.ollama.api.OllamaModel;
//import org.springframework.ai.ollama.api.OllamaOptions;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class Embedder {
//
//    public static void main(String [] args) throws InterruptedException {
//        Loader loader = new Loader();
//        loader.load("/Users/ravisingh/mlearning/search/src/main/resources/movie.json");
//        TimeUnit.SECONDS.sleep(5);
//
//        List<Document> result = loader.similaritySearch("back to the future");
//        result.stream().forEach(doc-> System.out.print(doc.getContent()));
////        var ollamaApi = new OllamaApi();
////
////        var embeddingModel = new OllamaEmbeddingModel(ollamaApi,
////                OllamaOptions.builder()
////                        .withModel(OllamaModel.MISTRAL.id())
////                        .build());
////
////        EmbeddingResponse embeddingResponse = embeddingModel.call(
////                new EmbeddingRequest(List.of("looper"),
////                        OllamaOptions.builder()
////                                .withModel("chroma/all-minilm-l6-v2-f32").withTruncate(false)
////                        .build()));
////
////
////        System.out.print(embeddingResponse.getMetadata());
//    }
//}
