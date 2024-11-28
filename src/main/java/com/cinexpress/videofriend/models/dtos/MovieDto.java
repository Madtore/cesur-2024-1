package com.cinexpress.videofriend.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long id;
    private String title;
    private String format;
    private String genre;
    private String language;
    private String year;

    private List<String> actors;
    private String director;
    private boolean availability;

    private CompanyDto companyDto;
    private CustomerDto customerDto;
}
