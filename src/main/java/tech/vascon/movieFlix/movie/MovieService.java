package tech.vascon.movieFlix.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.vascon.movieFlix.category.Category;
import tech.vascon.movieFlix.category.CategoryService;
import tech.vascon.movieFlix.streaming.Streaming;
import tech.vascon.movieFlix.streaming.StreamingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return repository.save(movie);
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Optional<Movie> findById(Long id) {
            return repository.findById(id);
    }

    public Optional<Movie> update(Long id, Movie updatedMovie) {
        Optional<Movie> optMovie = repository.findById(id);
        if(optMovie.isPresent()) {

            List<Category> categories = this.findCategories(updatedMovie.getCategories());
            List<Streaming> streamings  = this.findStreamings(updatedMovie.getStreamings());

            Movie  movie = optMovie.get();

            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(updatedMovie.getDescription());
            movie.setReleaseDate(updatedMovie.getReleaseDate());
            movie.setRating(updatedMovie.getRating());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            repository.save(movie);
            return Optional.of(movie);
        }
        return Optional.empty();
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.findById(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }

    public List<Movie> findByCategory(Long categoryId) {
        return repository.findByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
