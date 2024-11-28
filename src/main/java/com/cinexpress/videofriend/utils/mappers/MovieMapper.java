package com.cinexpress.videofriend.utils.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.dtos.CustomerDto;
import com.cinexpress.videofriend.models.dtos.MovieDto;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "movies", expression = "java(getMovieIds(customer))")
    @Mapping(target = "companyDto", source = "company")
    CustomerDto toDTO(Customer customer);

    Movie toEntity(MovieDto movieDto);

    default List<Long> getMovieIds(Customer customer) {
        if (customer.getMovies() == null) return null;
        return customer.getMovies().stream()
                .map(Movie::getId)
                .collect(Collectors.toList());
    }

    

}
