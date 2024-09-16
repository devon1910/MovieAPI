package dev.devon.moviesAPI.service;

import dev.devon.moviesAPI.entities.Movie;
import dev.devon.moviesAPI.entities.Review;
import dev.devon.moviesAPI.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ReviewRepo reviewRepo;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepo.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return  review;
    }
}
