package com.cinexpress.videofriend.utils.mappers;


import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.dtos.CompanyDto;


@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);


    @Mapping(target = "movieIds", expression = "java(getMovieIds(company))")
    @Mapping(target = "customerIds", expression = "java(getCustomerIds(company))")
    CompanyDto toDTO(Company company);

    default List<Long> getMovieIds(Company company) {
        if (company.getMovies() == null)
            return null;
        return company.getMovies().stream()
                .map(Movie::getId)
                .collect(Collectors.toList());
    }

    default List<Long> getCustomerIds(Company company) {
        if (company.getCustomers() == null)
            return null;
        return company.getCustomers().stream()
                .map(Customer::getId)
                .collect(Collectors.toList());
    }

   
}
