package tech.vascon.movieFlix.streaming;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotBlank(message = "Nome do serviço de streaming é obrigatório") String name) {
}
