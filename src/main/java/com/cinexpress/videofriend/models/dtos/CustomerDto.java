package com.cinexpress.videofriend.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private String type;
    private String subscription;
    private List<String> preferences;
    private List<Long> movies;
    private CompanyDto companyDto;
    private List<Long> recommendations;


}
