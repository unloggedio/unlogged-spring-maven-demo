package org.unlogged.demo.dao.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.unlogged.demo.models.MongoPojo;

public interface MongoPojoRepo extends MongoRepository<MongoPojo, String> {
}