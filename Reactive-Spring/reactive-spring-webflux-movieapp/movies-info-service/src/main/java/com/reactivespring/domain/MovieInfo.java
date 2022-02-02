package com.reactivespring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class MovieInfo {

    @Id
    private String moviesInfoId;
    @NotBlank(message = "movie info name must be present")
    private String name;
    @NotNull
    @Positive(message = "movie info year must be number")
    private Integer year;
    private List< @NotBlank(message = "movie info year must have cast members") String> cast;
    private LocalDate releaseDate;
}
