package tech.vascon.movieFlix.movie;

import lombok.experimental.UtilityClass;
import tech.vascon.movieFlix.category.Category;
import tech.vascon.movieFlix.category.CategoryMapper;
import tech.vascon.movieFlix.category.CategoryResponse;
import tech.vascon.movieFlix.streaming.Streaming;
import tech.vascon.movieFlix.streaming.StreamingMapper;
import tech.vascon.movieFlix.streaming.StreamingResponse;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request) {
        List<Category> categories = request.categories()
                .stream()
                .map((id) -> Category.builder().id(id).build())
                .toList();

        List<Streaming> streamings = request.streamings()
                .stream()
                .map(id -> Streaming.builder().id(id).build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .rating(request.rating())
                .releaseDate(request.releaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {

        List<CategoryResponse> categories = movie.getCategories()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}
