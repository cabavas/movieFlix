package tech.vascon.movieFlix.streaming;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}
