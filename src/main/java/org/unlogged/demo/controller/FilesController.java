package org.unlogged.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
@RequestMapping("/api/files")
public class FilesController {

    private String filePath = "src/main/resources/testFile";

    @PostMapping(value = "/create", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void createFile(@RequestBody(required = false) String initialContent) throws IOException {
        Path path = Paths.get(filePath);
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        if (initialContent != null && !initialContent.isEmpty()) {
            Files.writeString(path, initialContent, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

    @GetMapping(value = "/read", produces = MediaType.TEXT_PLAIN_VALUE)
    public String readFile() throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }

    @PostMapping(value = "/write", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void writeFile(@RequestBody String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @PostMapping(value = "/write-with-charset", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void writeFileWithCharset(@RequestBody String content,
                                     @RequestParam String charsetName) throws IOException {
        Path path = Paths.get(filePath);
        Charset charset = Charset.forName(charsetName);
        Files.writeString(path, content, charset, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}

