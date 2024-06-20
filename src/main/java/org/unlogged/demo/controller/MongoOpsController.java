package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.dao.mongo.MongoPojoRepo;
import org.unlogged.demo.models.MongoPojo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongoops")
public class MongoOpsController {

    @Autowired
    private MongoPojoRepo mongoPojoRepo;

    @RequestMapping("/defaultIns")
    public MongoPojo insertDefault() {
        MongoPojo pojo = new MongoPojo();
        pojo.setId("aaa");
        pojo.setName("Name AAA");
        return mongoPojoRepo.insert(pojo);
    }

    @RequestMapping("/insert")
    public MongoPojo insertNew(MongoPojo payload) {
        return mongoPojoRepo.insert(payload);
    }

    @RequestMapping("/getall")
    public List<MongoPojo> getall() {
        return mongoPojoRepo.findAll();
    }

    public MongoPojo getById(String id) {
        return mongoPojoRepo.findById(id).map(result -> {
            if (result == null) {
                return new MongoPojo();
            }
            return result;
        }).get();
    }

    public MongoPojo updatePojo(MongoPojo pojo) {
        return mongoPojoRepo.save(pojo);
    }

    public void deleteById(String id) {
        mongoPojoRepo.deleteById(id);
    }
}
