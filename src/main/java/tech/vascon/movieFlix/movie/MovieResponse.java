package tech.vascon.movieFlix.movie;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import tech.vascon.movieFlix.category.CategoryResponse;
import tech.vascon.movieFlix.streaming.StreamingResponse;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(Long id,
                            String title,
                            String description,
                            @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate releaseDate,
                            double rating,
                            List<CategoryResponse> categories,
                            List<StreamingResponse> streamings) {
}
