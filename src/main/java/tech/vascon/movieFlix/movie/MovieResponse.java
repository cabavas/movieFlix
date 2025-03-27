package tech.vascon.movieFlix.movie;

import lombok.Builder;
import tech.vascon.movieFlix.category.CategoryResponse;
import tech.vascon.movieFlix.streaming.StreamingResponse;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(Long id,
                            String title,
                            String description,
                            LocalDate releaseDate,
                            double rating,
                            List<CategoryResponse> categories,
                            List<StreamingResponse> streamings) {
}
