// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addressbook.proto

// Protobuf Java Version: 3.25.1
package org.unlogged.demo.protos.generated;

public final class AddressBookProtos {
  private AddressBookProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Person_PhoneNumber_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Person_PhoneNumber_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_AddressBook_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_AddressBook_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021addressbook.proto\022\010tutorial\"\243\002\n\006Person" +
      "\022\014\n\004name\030\001 \001(\t\022\n\n\002id\030\002 \001(\005\022\r\n\005email\030\003 \001(" +
      "\t\022,\n\006phones\030\004 \003(\0132\034.tutorial.Person.Phon" +
      "eNumber\032X\n\013PhoneNumber\022\016\n\006number\030\001 \001(\t\0229" +
      "\n\004type\030\002 \001(\0162\032.tutorial.Person.PhoneType" +
      ":\017PHONE_TYPE_HOME\"h\n\tPhoneType\022\032\n\026PHONE_" +
      "TYPE_UNSPECIFIED\020\000\022\025\n\021PHONE_TYPE_MOBILE\020" +
      "\001\022\023\n\017PHONE_TYPE_HOME\020\002\022\023\n\017PHONE_TYPE_WOR" +
      "K\020\003\"/\n\013AddressBook\022 \n\006people\030\001 \003(\0132\020.tut" +
      "orial.PersonB(\n\021org.unlogged.demoB\021Addre" +
      "ssBookProtosP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tutorial_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Person_descriptor,
        new java.lang.String[] { "Name", "Id", "Email", "Phones", });
    internal_static_tutorial_Person_PhoneNumber_descriptor =
      internal_static_tutorial_Person_descriptor.getNestedTypes().get(0);
    internal_static_tutorial_Person_PhoneNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Person_PhoneNumber_descriptor,
        new java.lang.String[] { "Number", "Type", });
    internal_static_tutorial_AddressBook_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_tutorial_AddressBook_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_AddressBook_descriptor,
        new java.lang.String[] { "People", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
