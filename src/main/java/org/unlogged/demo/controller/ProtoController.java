package org.unlogged.demo.controller;

import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.protos.generated.AddressBook;
import org.unlogged.demo.protos.generated.Person;

import java.io.IOException;

@RestController
@RequestMapping("/proto")
public class ProtoController {

    private String referenceJson = "{\n" +
            "  \"memoizedHashCode\" : 0,\n" +
            "  \"memoizedSize\" : -1,\n" +
            "  \"unknownFields\" : {\n" +
            "    \"fields\" : { }\n" +
            "  },\n" +
            "  \"people_\" : [ {\n" +
            "    \"memoizedHashCode\" : 0,\n" +
            "    \"memoizedSize\" : -1,\n" +
            "    \"unknownFields\" : {\n" +
            "      \"fields\" : { }\n" +
            "    },\n" +
            "    \"bitField0_\" : 1,\n" +
            "    \"name_\" : \"Amg\",\n" +
            "    \"id_\" : 0,\n" +
            "    \"email_\" : \"\",\n" +
            "    \"phones_\" : [ ],\n" +
            "    \"memoizedIsInitialized\" : 1\n" +
            "  } ],\n" +
            "  \"memoizedIsInitialized\" : 1\n" +
            "}";

    @RequestMapping("/addressbook")
    public AddressBook getAddressbook() {
        AddressBook addressBook = AddressBook.newBuilder().addPeople(
                Person.newBuilder().setName("Amg").build()
        ).build();
        return addressBook;
    }

    @RequestMapping("/fromJson")
    private Message convertFromJson() {
        try {
            Struct.Builder structBuilder = Struct.newBuilder();
            JsonFormat.parser().ignoringUnknownFields().merge(referenceJson, structBuilder);
            return structBuilder.build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert json");
        }
    }

    private String convertAddressBook() throws IOException {
        return toJson(AddressBook.newBuilder().addPeople(
                Person.newBuilder().setName("Amg")
        ));
    }

    private String toJson(MessageOrBuilder messageOrBuilder) throws IOException {
        return JsonFormat.printer().print(messageOrBuilder);
    }

}
