package tech.vascon.movieFlix.category;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
