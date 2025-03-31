package tech.vascon.movieFlix.movie;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@Schema(type = "string", description = "Nome do filme")
                           @NotBlank(message = "Título do filme é obrigatório") String title,
                           @Schema(type = "string", description = "Descrição do filme")
                           String description,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           @Schema(type = "date", description = "Data de lançamento do filme. ex: '19/05/1990'")
                           LocalDate releaseDate,
                           @Schema(type = "double", description = "Média das avaliações dos filmes")
                           double rating,
                           @Schema(type = "array", description = "Lista de códigos das categorias")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de códigos dos stramings")
                           List<Long> streamings) {
}
