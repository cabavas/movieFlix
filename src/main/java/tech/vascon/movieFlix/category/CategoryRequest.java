package tech.vascon.movieFlix.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Nome da categoria é obrigatório.") String name) {
}
