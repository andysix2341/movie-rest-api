package com.movie.Dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record MovieRequestDto(
    @NotBlank(message = "Please don't make this movie name empty")
    @Size(max = 250, message = "maximum character movie name is 50")
    String movieName,
    @NotBlank(message = "Please don't make this movie name empty")
    @Size(max = 150, message = "Maximum character director is 150")
    String movieDirector
) {
}
