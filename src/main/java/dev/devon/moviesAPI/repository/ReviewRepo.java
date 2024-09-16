package dev.devon.moviesAPI.repository;

import dev.devon.moviesAPI.entities.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepo extends MongoRepository<Review, ObjectId> {
}
