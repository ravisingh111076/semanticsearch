//package com.smartAI.search;
//import org.deeplearning4j.models.word2vec.Word2Vec;
//import org.deeplearning4j.models.word2vec.Word2Vec.Builder;
//import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
//import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
//import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
//import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
//import org.nd4j.linalg.api.ndarray.INDArray;
//import org.nd4j.linalg.factory.Nd4j;
//import com.opencsv.CSVReader;
//
//import java.io.File;
//import java.io.FileReader;
//import java.util.*;
//
//public class SemanticSearch {
//
//    private Word2Vec word2Vec;
//
//    public static void main(String[] args) throws Exception {
//        // Initialize the SemanticSearch
//        SemanticSearch search = new SemanticSearch();
//       // search.trainWord2VecModel("/Users/ravisingh/mlearning/search/src/main/resources/movie.csv");
//
//        // Load data from CSV and convert it to vectors
//        Map<String, String> data = search.loadCSVData("/Users/ravisingh/mlearning/search/src/main/resources/movie.csv");
//
//        // Perform a search with a query
//        String query = "back to the future";
//        List<Map.Entry<String, Double>> results = search.search(query, data);
//
//        // Display results
//        System.out.println("Results for query: " + query);
//        for (Map.Entry<String, Double> entry : results) {
//            System.out.println("ID: " + entry.getKey() + ", Similarity: " + entry.getValue());
//        }
//    }
//
//    // Method to train a Word2Vec model
//    public void trainWord2VecModel(String corpusFilePath) throws Exception {
//        // SentenceIterator for your corpus (could be your text corpus for training)
//        SentenceIterator iterator = new BasicLineIterator(new File(corpusFilePath));
//        TokenizerFactory tokenizerFactory = new DefaultTokenizerFactory();
//
//        // Build the Word2Vec model
//        word2Vec = new Builder()
//                .minWordFrequency(5)
//                .iterations(10)
//                .layerSize(100)
//                .seed(42)
//                .windowSize(5)
//                .iterate(iterator)
//                .tokenizerFactory(tokenizerFactory)
//                .build();
//
//        // Train the model
//        word2Vec.fit();
//    }
//
//    // Method to load CSV data
//    public Map<String, String> loadCSVData(String csvFilePath) throws Exception {
//        Map<String, String> data = new HashMap<>();
//        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
//            String[] nextRecord;
//            while ((nextRecord = csvReader.readNext()) != null) {
//                // Skip header
//                if ("contentid".equals(nextRecord[0])) continue;
//
//               // int id = Integer.parseInt(nextRecord[0]);
//                String text = nextRecord[1];
//                data.put(nextRecord[0], text);
//            }
//        }
//        return data;
//    }
//
//    // Method to perform semantic search
//    public List<Map.Entry<String, Double>> search(String query, Map<String, String> data) {
//        List<Map.Entry<String, Double>> rankedResults = new ArrayList<>();
//
//        // Get the vector for the query
//        INDArray queryVector = getMeanWordVector(query);
//
//        // Compare the query vector with each document vector
//        for (Map.Entry<String, String> entry : data.entrySet()) {
//            INDArray documentVector = getMeanWordVector(entry.getValue());
//            if (documentVector != null && queryVector != null) {
//                double similarity = cosineSimilarity(queryVector, documentVector);
//                rankedResults.add(new AbstractMap.SimpleEntry<>(entry.getKey(), similarity));
//            }
//        }
//
//        // Sort results by similarity score (descending)
//        rankedResults.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
//
//        return rankedResults;
//    }
//
//    // Method to get the mean word vector for a sentence (document)
//    public INDArray getMeanWordVector(String sentence) {
//        String[] words = sentence.split("\\s+");
//        INDArray wordVectors = Nd4j.create(words.length, word2Vec.getLayerSize());
//        int count = 0;
//
//        for (String word : words) {
//            if (word2Vec.hasWord(word)) {
//                wordVectors.addiRowVector(word2Vec.getWordVectorMatrix(word));
//                count++;
//            }
//        }
//
//        // Avoid division by zero
//        if (count == 0) {
//            return null;
//        }
//
//        return wordVectors.div(count);  // Mean of the word vectors
//    }
//
//    // Method to calculate cosine similarity between two vectors
//    public double cosineSimilarity(INDArray vector1, INDArray vector2) {
//        double dotProduct = Nd4j.getBlasWrapper().dot(vector1, vector2);
//        double norm1 = vector1.norm2Number().doubleValue();
//        double norm2 = vector2.norm2Number().doubleValue();
//        return dotProduct / (norm1 * norm2);
//    }
//}
