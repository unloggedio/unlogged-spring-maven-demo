// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/java/org/unlogged/demo/protos/entity.proto

// Protobuf Java Version: 3.25.1
package org.unlogged.demo.protos.generated;

public interface EntityBlobOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tutorial.EntityBlob)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string blob_name = 1;</code>
   * @return The blobName.
   */
  java.lang.String getBlobName();
  /**
   * <code>string blob_name = 1;</code>
   * @return The bytes for blobName.
   */
  com.google.protobuf.ByteString
      getBlobNameBytes();

  /**
   * <code>bytes blob_bytes = 2;</code>
   * @return The blobBytes.
   */
  com.google.protobuf.ByteString getBlobBytes();
}
