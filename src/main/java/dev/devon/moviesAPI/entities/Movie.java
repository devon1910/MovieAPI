package dev.devon.moviesAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Data;//takes care of getters and setters and tostrings
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection="movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;

    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference //saves only the Ids of the reviews and they will be stored elsewhere
    private List<Review> reviewIds;







}
