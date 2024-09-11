//package com.smartAI.search.admin;
//
//import io.milvus.client.MilvusServiceClient;
//import io.milvus.param.ConnectParam;
//import io.milvus.param.R;
//import io.milvus.param.RpcStatus;
//import io.milvus.param.collection.CreateDatabaseParam;
//
//public class CreateMilvusDB {
//    public static String URI = "http://localhost:19530";
//    public static String TOKEN = "root:Milvus";
//    public static void main(String [] args) {
//        // 1. Connect to Milvus server
//        ConnectParam connectParam = ConnectParam.newBuilder()
//                .withUri(URI)
//                .withToken(TOKEN)
//                .build();
//
//        MilvusServiceClient client = new MilvusServiceClient(connectParam);
//
//// 3. Create a new database
//        CreateDatabaseParam createDatabaseParam = CreateDatabaseParam.newBuilder()
//                .withDatabaseName("atom")
//                .build();
//
//        R<RpcStatus> response = client.createDatabase(createDatabaseParam);
//
//        System.out.print("DB is created");
//    }
//}
