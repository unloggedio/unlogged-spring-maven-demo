package org.unlogged.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.DeliveryPromptCard;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class LocalFileService {

    public boolean writeReport(boolean canDeliver, CustomerProfile customerProfile) {
        ObjectMapper objectMapper = new ObjectMapper();
        Date date = new Date();
        File file = new File("delivery_prompt_" + customerProfile.getCustomerid() + "_" + date.getTime());
        try (FileOutputStream resourceFile = new FileOutputStream(file)) {
            String json = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(new DeliveryPromptCard(canDeliver, customerProfile));
            resourceFile.write(json.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
