// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/java/org/unlogged/demo/protos/entity.proto

// Protobuf Java Version: 3.25.1
package org.unlogged.demo.protos.generated;

public interface EntityObjectPropertyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tutorial.EntityObjectProperty)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, .tutorial.EntityProperty&gt; property_map = 1;</code>
   */
  int getPropertyMapCount();
  /**
   * <code>map&lt;string, .tutorial.EntityProperty&gt; property_map = 1;</code>
   */
  boolean containsPropertyMap(
      java.lang.String key);
  /**
   * Use {@link #getPropertyMapMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, org.unlogged.demo.protos.generated.EntityProperty>
  getPropertyMap();
  /**
   * <code>map&lt;string, .tutorial.EntityProperty&gt; property_map = 1;</code>
   */
  java.util.Map<java.lang.String, org.unlogged.demo.protos.generated.EntityProperty>
  getPropertyMapMap();
  /**
   * <code>map&lt;string, .tutorial.EntityProperty&gt; property_map = 1;</code>
   */
  /* nullable */
org.unlogged.demo.protos.generated.EntityProperty getPropertyMapOrDefault(
      java.lang.String key,
      /* nullable */
org.unlogged.demo.protos.generated.EntityProperty defaultValue);
  /**
   * <code>map&lt;string, .tutorial.EntityProperty&gt; property_map = 1;</code>
   */
  org.unlogged.demo.protos.generated.EntityProperty getPropertyMapOrThrow(
      java.lang.String key);
}
