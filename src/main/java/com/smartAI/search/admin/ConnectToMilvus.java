//package com.smartAI.search.admin;
//
//import io.milvus.client.MilvusServiceClient;
//import io.milvus.param.ConnectParam;
//
//public class ConnectToMilvus {
//    private String _dbName = "default";
//    String URI = "http://localhost:19530";
//    String TOKEN = "root:Milvus";
//    public void newBuilder() {}
//
//    public MilvusServiceClient build() {
//        ConnectParam connectParam = ConnectParam.newBuilder()
//                .withUri(URI)
//                .withToken(TOKEN)
//                .withDatabaseName("default")
//                .build();
//
//        return new MilvusServiceClient(connectParam);
//    }
//
//}
