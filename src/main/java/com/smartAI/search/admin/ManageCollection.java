//package com.smartAI.search.admin;
//
//
//import io.milvus.v2.client.ConnectConfig;
//import io.milvus.v2.client.MilvusClientV2;
//
//import io.milvus.v2.common.DataType;
//import io.milvus.v2.service.collection.request.AddFieldReq;
//import io.milvus.v2.service.collection.request.DropCollectionReq;
//import io.milvus.v2.service.collection.request.CreateCollectionReq;
//public class ManageCollection {
//    static String CLUSTER_ENDPOINT = "http://localhost:19530";
//
//    public static void main(String [] args) {
//        // 1. Connect to Milvus server
//        ConnectConfig connectConfig = ConnectConfig.builder()
//                .uri(CLUSTER_ENDPOINT)
//                .dbName("atom")
//                .build();
//
//        MilvusClientV2 client = new MilvusClientV2(connectConfig);
//        createCollection(client, "atom_vector5");
//        //dropCollection(client, "atom_vector4");
//
//
////        CreateCollectionParam createParam = CreateCollectionParam.newBuilder()
////                .withCollectionName("atom_vector3")
////                .
////                .build();
//
//
//    }
//    public static void createCollection(MilvusClientV2 client, String collectionName) {
//        CreateCollectionReq.CollectionSchema schema = client.createSchema();
//
//        schema.addField(AddFieldReq.builder()
//                .fieldName("doc_id")
//                .dataType(DataType.VarChar)
//                .isPrimaryKey(true)
//                .autoID(false)
//                .build());
//       schema.addField(AddFieldReq.builder()
//                       .fieldName("embedding")
//                .dataType(DataType.FloatVector)
//                .dimension(5)
//                .build());
//        schema.addField(AddFieldReq.builder()
//                .fieldName("content")
//                .dataType(DataType.VarChar)
//                .dimension(5)
//                .build());
////        schema.addField(AddFieldReq.builder()
////                .fieldName("metadata")
////                .dataType(DataType.VarChar)
////                .dimension(5)
////                .build());
////        schema.addField(AddFieldReq.builder()
////                .fieldName("content")
////                .dataType(DataType.VarChar)
////                .dimension(5)
////                .build());
//// 2. Create a collection in quick setup mode
//        CreateCollectionReq quickSetupReq = CreateCollectionReq.builder()
//                .collectionName(collectionName)
//                .collectionSchema(schema)
//                .autoID(true)
//                .dimension(5)
//                .build();
//        client.createCollection(quickSetupReq);
//        System.out.print("Collection is created");
//    }
//    public static void dropCollection(MilvusClientV2 client, String collectionName) {
//        DropCollectionReq dropQuickSetupParam = DropCollectionReq.builder()
//                .collectionName(collectionName)
//                .build();
//
//        client.dropCollection(dropQuickSetupParam);
//
//        System.out.print(collectionName + " collection has been dropped");
//    }
//}
