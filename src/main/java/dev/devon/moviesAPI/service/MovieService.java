package dev.devon.moviesAPI.service;

import dev.devon.moviesAPI.entities.Movie;
import dev.devon.moviesAPI.repository.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired//let framework know that it should instantiate the class for us
    private MovieRepo movieRepo;

    public List<Movie> allMovies(){
        return  movieRepo.findAll();

    }

    public Optional<Movie> getSingleMovie(String imdbId){
        return  movieRepo.findMovieByImdbId(imdbId);
    }


}
